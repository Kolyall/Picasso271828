package com.kolyall.picasso271828;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        mPicasso = new PicassoModule().getPicasso(this);
        mPicasso.load("https://cs5.livemaster.ru/storage/1e/21/22adc9daa03a237cb75f097910iw--kartiny-i-panno-kartina-pejzazh-vesennij-u-podnozhiya-gor-zel.jpg")
                .placeholder(R.color.placeholderColor)
                .error(R.color.errorColor)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d(TAG, "onSuccess: ");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e(TAG, "onError: ", e);
                    }
                });
    }
}
