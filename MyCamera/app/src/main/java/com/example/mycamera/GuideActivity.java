package com.example.mycamera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        handler.sendEmptyMessageDelayed(1,2000);
    }
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            if(message.what==1){
                Intent intent=new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            return false;
        }
    });

}