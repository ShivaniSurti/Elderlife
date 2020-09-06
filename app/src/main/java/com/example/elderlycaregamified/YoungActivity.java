package com.example.elderlycaregamified;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class YoungActivity extends AppCompatActivity
{

    Button buttonTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young);

        buttonTasks = (Button) findViewById(R.id.button_see_tasks);

    }

    public void seeTasks(View view)
    {
        Intent intent = new Intent(YoungActivity.this, MapTasksActivity.class);

        startActivity(intent);

    }
}
