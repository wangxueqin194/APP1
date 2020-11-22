package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gradeone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradeone);
    }
    public void OnBack(View view){
        startActivity(new Intent(this, Vocabulary_Book.class));
    }
    public void hello(View view){
        startActivity(new Intent(this, Hello.class));
    }
}