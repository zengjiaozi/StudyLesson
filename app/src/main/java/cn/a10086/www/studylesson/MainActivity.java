package cn.a10086.www.studylesson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import cn.a10086.www.studylesson.lesson1.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView) findViewById(R.id.imageview);
//        imageView.setBackgroundResource(R.color.colorAccent);
        ImageLoader imageLoader = new ImageLoader();
        String url = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
        imageLoader.displayImage(url, imageview);
//        setContentView(imageView);

    }
}
