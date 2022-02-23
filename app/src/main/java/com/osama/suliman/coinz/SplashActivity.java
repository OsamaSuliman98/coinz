package com.osama.suliman.coinz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {
    private MyHandler myHandler;
    private boolean isRunning = true;
    private long currentTimeInMillis ;
    private long remaining =5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash);

        if (savedInstanceState != null){
            remaining =savedInstanceState.getLong("remaining delay" , 5000);
        }
        myHandler = new MyHandler(new WeakReference<>(this));
        Message message = myHandler.obtainMessage();
        currentTimeInMillis = System.currentTimeMillis();
        myHandler.sendMessageDelayed(message, remaining);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        remaining = remaining - (System.currentTimeMillis() - currentTimeInMillis);
        outState.putLong("remaining delay" ,remaining);
    }

    static class MyHandler extends Handler {
        private final WeakReference<SplashActivity> splashActivityWeakReference;

        public MyHandler(WeakReference<SplashActivity> splashActivityWeakReference) {
            super();
            this.splashActivityWeakReference = splashActivityWeakReference;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            SplashActivity splashActivity = splashActivityWeakReference.get();
            if (splashActivity != null && splashActivity.isRunning) {
                splashActivity.startActivity(new Intent(splashActivity, MainActivity.class));
                splashActivity.finish();

            }
        }
    }
}