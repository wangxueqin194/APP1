package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class Mine extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
    }
    public void OnBack(View view){
        Mine.this.finish();
    }
    public void setting(View view){
        startActivity(new Intent(this, Settings.class));
    }
    public void user(View view){
        startActivity(new Intent(this, User.class));
    }
}