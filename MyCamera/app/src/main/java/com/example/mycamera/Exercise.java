package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
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
    public void testvocabulary(View view){
        startActivity(new Intent(this, Test_Vocabulary.class));
    }
    public void on_line(View view){
        startActivity(new Intent(this, On_line.class));
    }
    public void listening(View view){
        startActivity(new Intent(this, Listeningandchoose.class));
    }

}