package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import android.widget.Toast;

//import com.tbruyelle.rxpermissions3.RxPermissions;

//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Observer;
//import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void camera(View view){
        //startActivity(new Intent(MainActivity.this, Photograph.class));
        startActivity(new Intent(MainActivity.this, Photograph_Activity.class));
    }
    public void vocabulary(View view){
        startActivity(new Intent(MainActivity.this,MyVocabulary.class));
    }
    public void classfication(View view){
        startActivity(new Intent(MainActivity.this, Classfication.class));
    }
    public void mine(View view){
        startActivity(new Intent(MainActivity.this, Mine.class));
    }
}