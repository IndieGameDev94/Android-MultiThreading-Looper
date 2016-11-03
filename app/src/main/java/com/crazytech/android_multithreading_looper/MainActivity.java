package com.crazytech.android_multithreading_looper;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSendMessage;
    private MyThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSendMessage = (Button) findViewById(R.id.main_activity_btn_sendMessage);
        thread = new MyThread();

        thread.start();
        Toast.makeText(MainActivity.this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();

    }

    public void sendMessage(View view) {
        thread.mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class MyThread extends Thread {

        Handler mHandler;

        public MyThread() {

        }

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler();
            Looper.loop();
        }
    }
}
