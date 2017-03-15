package cn.a10086.www.studylesson.lesson1;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @time 2017/3/15  20:39
 * @desc ${TODD}
 */
public class ImageLoader {

//     单一原则  主要负责图片的显示加载

    //    获取图片缓存类
    ImageCache imageCache = new ImageCache();
//    线程池 线程的数量是CPU的数量

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    //    照片的显示
    public void displayImage(final String url, final ImageView imageView) {

        final Bitmap bitmap = imageCache.get(url);
//        一定需要注意非空的判断
        if (bitmap != null) {
            Log.i("TAG", "2111111111");
            imageView.setImageBitmap(bitmap);

            return;

        }
//        设置一个标记
        imageView.setTag(url);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.i("TAG", "1111111111");
                Bitmap bitmap1 = downloadImage(url);

                if (bitmap1 == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    Log.i("TAG", "3111111111");
                    imageView.setImageBitmap(bitmap1);

                }

                imageCache.put(url, bitmap1);
            }
        });


    }


    //    下载图片的操作
    private Bitmap downloadImage(String imageurl) {
        Bitmap bitmap = null;
        try {
            Log.i("TAG", "4111111111");
            URL url = new URL(imageurl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            获取输入流
            InputStream inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bitmap;

    }


}







