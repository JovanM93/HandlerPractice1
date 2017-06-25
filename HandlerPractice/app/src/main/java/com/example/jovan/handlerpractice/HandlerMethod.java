package com.example.jovan.handlerpractice;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class HandlerMethod {
    boolean playing = true;
    //public ProgressDialog progress;

       public void handle (final ProgressDialog progress, final Handler handler){
          /* progress = new ProgressDialog(context);
           progress.setMax(max);
           progress.setMessage("Its loading....");
           progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           progress.setIndeterminate(true);
           progress.show();
           playing = true; */
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       while (progress.getProgress() <= progress
                               .getMax()) {
                           Thread.sleep(200);
                           handler.sendMessage(handler.obtainMessage());
                           if (progress.getProgress() == progress
                                   .getMax()) {
                               progress.dismiss();
                           }
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }).start();

       }
      /* Handler handleee = new Handler() {
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
               progress.incrementProgressBy(1);
           }
       }; */



    public void stopPlaying(){
        playing = false;
    }



}
