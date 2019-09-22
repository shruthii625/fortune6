package com.example.fortune6;







import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public TextView songname;

    MediaPlayer mPlayer ;
    private WebView webView;
    Button button;
    TextView textView;
    ImageView wheel;
    Random r;
    int degree=0;
    int degree_old=0;
    private static final float FACTOR=30f;
    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mPlayer =  MediaPlayer.create(this, R.raw.music);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        wheel= (ImageView) findViewById(R.id.wheel);
        r= new Random();

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                degree_old=degree%360;
                degree=r.nextInt(3600)+720;
                RotateAnimation rotate=new RotateAnimation(degree_old,degree,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        mPlayer.start();
                        textView.setText("");



                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.setText(currentNumber(360-(degree%360)));
                        mPlayer.stop();



                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                wheel.startAnimation(rotate);
            }
        });


    }


    private String currentNumber(int degrees){
        String text="";

        if(degrees>=(FACTOR*1)&&degrees<(FACTOR*3))
        {
            text="1";
            webView=(WebView) findViewById(R.id.webView) ;
            // webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://pythagorean.glitch.me");
            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);
        }
        if(degrees>=(FACTOR*3)&&degrees<(FACTOR*5))
        {
            text="2";
            webView=(WebView) findViewById(R.id.webView) ;
            webView.loadUrl("https://narrow-ocicat.glitch.me");
            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);

        }
        if(degrees>=(FACTOR*5)&&degrees<(FACTOR*7))
        {
            text="3";
            webView=(WebView) findViewById(R.id.webView) ;
            webView.loadUrl("https://spiny-box.glitch.me");
            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);

        }
        if(degrees>=(FACTOR*7)&&degrees<(FACTOR*9))
        {
            text="4";
            webView=(WebView) findViewById(R.id.webView) ;
            webView.loadUrl("https://absorbed-jackrabbit.glitch.me");
            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);

        }
        if(degrees>=(FACTOR*9)&&degrees<(FACTOR*11))
        {
            text="5";
            webView=(WebView) findViewById(R.id.webView) ;
            webView.loadUrl("https://trapezoidal-wheel.glitch.me");

            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);

        }
        if((degrees>=(FACTOR*11)&&degrees<360)||(degrees>=0 && degrees<(FACTOR*1)))
        {




            text="6";
            webView=(WebView) findViewById(R.id.webView) ;
            webView.loadUrl("https://dented-sauce.glitch.me");
            // WebView content=(WebView)findViewById(R.id.webView);

            WebSettings webSettings= webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);

        }
        return text;


    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else{


            super.onBackPressed();
        } }


}