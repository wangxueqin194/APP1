package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class On_line extends AppCompatActivity implements View.OnClickListener{

    private Button cbt1;
    private Button cbt2;
    private Button cbt3;
    private Button cbt4;
    private Button ebt1;
    private Button ebt2;
    private Button ebt3;
    private Button ebt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_line);

        cbt1=findViewById(R.id.c1);
        cbt2=findViewById(R.id.c2);
        cbt3=findViewById(R.id.c3);
        cbt4=findViewById(R.id.c4);
        ebt1=findViewById(R.id.e1);
        ebt2=findViewById(R.id.e2);
        ebt3=findViewById(R.id.e3);
        ebt4=findViewById(R.id.e4);

        cbt1.setOnClickListener(this);
        cbt2.setOnClickListener(this);
        cbt3.setOnClickListener(this);
        cbt4.setOnClickListener(this);
        ebt1.setOnClickListener(this);
        ebt2.setOnClickListener(this);
        ebt3.setOnClickListener(this);
        ebt4.setOnClickListener(this);
    }
    public void OnBack(View view){
    On_line.this.finish();
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.c1:
                setEnable(cbt1);
                break;
            case R.id.c2:
                setEnable(cbt2);
                break;
            case R.id.c3:
                setEnable(cbt3);
                break;
            case R.id.c4:
                setEnable(cbt4);
                break;
            case R.id.e1:
                setEnable(ebt1);
                break;
            case R.id.e2:
                setEnable(ebt2);
                break;
            case R.id.e3:
                setEnable(ebt3);
                break;
            case R.id.e4:
                setEnable(ebt4);
                break;
        }
    }



    private void setEnable(Button btn) {
        List<Button> buttonList=new ArrayList<>();
        if (buttonList.size()==0){
            buttonList.add(cbt1);
            buttonList.add(cbt2);
            buttonList.add(cbt3);
            buttonList.add(cbt4);
            buttonList.add(ebt1);
            buttonList.add(ebt2);
            buttonList.add(ebt3);
            buttonList.add(ebt4);
        }
        for (int i = 0; i <buttonList.size() ; i++) {
            buttonList.get(i).setEnabled(true);
        }
        btn.setEnabled(false);
    }



}
