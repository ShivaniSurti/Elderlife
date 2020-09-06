package com.example.elderlycaregamified;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YoungActivity extends AppCompatActivity
{

    private Button buttonTasks;
    private TextView textViewtask;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young);

        buttonTasks = (Button) findViewById(R.id.button_see_tasks);
        textViewtask = (TextView) findViewById(R.id.textView_young_task);

        String task = getIntent().getStringExtra("TASK_NAME");

        textViewtask.setText(task);
    }

    public void seeTasks(View view)
    {
        Intent intent = new Intent(YoungActivity.this, MapTasksActivity.class);

        startActivity(intent);

    }
}
