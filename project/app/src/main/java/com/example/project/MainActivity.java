package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2500;

    ImageView imageView;
    TextView textView;
    Animation top, buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        top = AnimationUtils.loadAnimation(this, R.anim.top);
        buttom = AnimationUtils.loadAnimation(this, R.anim.buttom);

        imageView.setAnimation(top);
        textView.setAnimation(buttom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                //startActivity(intent);
                //finish();
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imageView, "logo_image");
                pairs[1] = new Pair<View, String>(textView, "logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        }, SPLASH_SCREEN);
    }
}