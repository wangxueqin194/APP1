package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions3.RxPermissions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class MainActivity extends AppCompatActivity {
    //采用RxPermissions框架动态申请权限
    RxPermissions rxPermissions = new RxPermissions(this);
    // 必须在初始化阶段完成，如onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxPermissions.request(Manifest.permission.CAMERA,    //申请相机拍摄权限
                Manifest.permission.WRITE_EXTERNAL_STORAGE,  //存储器写权限
                Manifest.permission.READ_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {    //存储器读权限
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Boolean aBoolean) { //判断权限是否被赋予
                if (aBoolean) {
                    //Toast.makeText(MainActivity.this, "已获取权限，可以干想干的咯", Toast.LENGTH_LONG).show();
                } else {
                    //只有用户拒绝开启权限，且选了不再提示时，才会走这里，否则会一直请求开启
                    Toast.makeText(MainActivity.this, "主人，我被禁止啦，去设置权限设置那把我打开哟", Toast.LENGTH_LONG)
                            .show();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public void camera(View view){
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