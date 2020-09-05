package com.example.elderlycaregamified;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startYoungActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this, YoungActivity.class);
        startActivity(intent);
    }

    public void startOldActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this, ElderlyActivity.class);
        startActivity(intent);
    }
}
