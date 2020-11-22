package com.example.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Test_Vocabulary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__vocabulary);
    }
    public void OnBack(View view){
        Test_Vocabulary.this.finish();
    }
}