package com.example.jovan.handlerpractice;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    public HandlerMethod handlerMethod;
    TextView textview;
    private ProgressDialog progressDoalog;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview =(TextView)findViewById(R.id.textView);
        handlerMethod = new HandlerMethod();

    }

    public void testMethod(View view){
        progress = new ProgressDialog(MainActivity.this);
        progress.setMax(100);
        progress.setMessage("Its loading....");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.show();
        handlerMethod.handle(progress,handle);

    }

    public void hmM(View view){

       // handlerMethod.handle(MainActivity.this,1000);
    }


    public void stopPlaying(View view){
        handlerMethod.stopPlaying();

    }
   public void progress(View view){
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(1000);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDoalog.getProgress() <= progressDoalog
                            .getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDoalog.getProgress() == progressDoalog
                                .getMax()) {
                            progressDoalog.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

            Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    progressDoalog.incrementProgressBy(1);
                }
            };


}



