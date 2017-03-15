package cn.a10086.www.studylesson.lesson1;


import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author
 * @time 2017/3/15  20:40
 * @desc ${TODD}
 */
public class ImageCache {
//    负责图片的缓存

    LruCache<String, Bitmap> imageCache;

    public ImageCache() {
//        初始化图片缓存操作方式
        initImageCache();


    }

    private void initImageCache() {
//        计算可使用的最大内存
        int maxMemory = (int) ((Runtime.getRuntime().maxMemory()) / 1024);
//        取1/4作为缓存
        final int cacheSize = maxMemory / 4;
        imageCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }


    public void put(String url, Bitmap bitmap) {

        imageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {

        Bitmap bitmap = imageCache.get(url);

        return bitmap;

    }
}
