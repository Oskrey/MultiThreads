package com.example.multithreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    findViewById(R.id.buttonSync).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent switcher = new Intent(MainActivity.this, MainActivitySync.class);
            startActivity(switcher);
        }
    });

        findViewById(R.id.buttonAsync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switcher = new Intent(MainActivity.this, MainActivityAsync.class);
                startActivity(switcher);
            }
        });

        findViewById(R.id.buttonExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}