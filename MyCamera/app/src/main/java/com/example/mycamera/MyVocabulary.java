package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyVocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vocabulary);
    }
    public void OnBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
    public void myV(View view){
        startActivity(new Intent(this, MyVocabulary.class));
    }
    public void VBook(View view){
        startActivity(new Intent(this, Vocabulary_Book.class));
    }
    public void exercise(View view){
        startActivity(new Intent(this, Exercise.class));
    }
    public void discernr(View view){
        startActivity(new Intent(this, Discern.class));
    }
}