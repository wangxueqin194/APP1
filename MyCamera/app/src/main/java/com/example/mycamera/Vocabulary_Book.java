package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Vocabulary_Book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary__book);
    }
    public void OnBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
    public void myV(View view){
        startActivity(new Intent(this, MyVocabulary.class));
    }
    public void exercise(View view){
        startActivity(new Intent(this, Exercise.class));
    }
    public void grade(View view){
        startActivity(new Intent(this, gradeone.class));
    }
}