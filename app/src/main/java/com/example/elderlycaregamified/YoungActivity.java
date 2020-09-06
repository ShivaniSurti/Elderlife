package com.example.elderlycaregamified;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YoungActivity extends AppCompatActivity
{

    private Button buttonTasks;

    private LinearLayout layout1;
    private LinearLayout layout2;
    private LinearLayout layout3;

    private TextView textViewTask1;
    private TextView textViewLoc1;
    private Button clearBtn1;

    private TextView textViewTask2;
    private TextView textViewLoc2;
    private Button clearBtn2;

    private TextView textViewTask3;
    private TextView textViewLoc3;
    private Button clearBtn3;

    public static int cnt = 0;
    public static boolean clickedMarker = false;

    public static String pastName = "";
    public static String pastLoc = "";

    private TextView[] tasks;
    private TextView[] locations;
    private LinearLayout[] layouts;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_young);

        buttonTasks = (Button) findViewById(R.id.button_see_tasks);

        layout1 = (LinearLayout) findViewById(R.id.layout_young_1);
        layout2 = (LinearLayout) findViewById(R.id.layout_young_2);
        layout3 = (LinearLayout) findViewById(R.id.layout_young_3);

        textViewLoc1 = (TextView) findViewById(R.id.textView_young_loc1);
        textViewLoc2 = (TextView) findViewById(R.id.textView_young_loc2);
        textViewLoc3 = (TextView) findViewById(R.id.textView_young_loc3);

        textViewTask1 = (TextView) findViewById(R.id.textView_young_task1);
        textViewTask2 = (TextView) findViewById(R.id.textView_young_task2);
        textViewTask3 = (TextView) findViewById(R.id.textView_young_task3);

        tasks = new TextView[]{textViewTask1, textViewTask2, textViewTask3};
        locations = new TextView[]{textViewLoc1, textViewLoc2, textViewLoc3};
        layouts = new LinearLayout[]{layout1, layout2, layout3};


        if(clickedMarker  && cnt == 1)
        {
            String task = getIntent().getStringExtra("TASK_NAME");
            String loc = getIntent().getStringExtra("LOCATION_NAME");

            tasks[cnt].setText(task);
            locations[cnt].setText(loc);
            layouts[cnt].setVisibility(View.VISIBLE);

            tasks[0].setText(pastName);
            locations[0].setText(pastLoc);
            layouts[0].setVisibility(View.VISIBLE);


            cnt++;

            clickedMarker = false;
        }
        else if(clickedMarker)
        {
            String task = getIntent().getStringExtra("TASK_NAME");
            String loc = getIntent().getStringExtra("LOCATION_NAME");

            pastName = task;
            pastLoc = loc;

            tasks[cnt].setText(task);
            locations[cnt].setText(loc);
            layouts[cnt].setVisibility(View.VISIBLE);
            cnt++;

            clickedMarker = false;
        }
    }



    public void seeTasks(View view)
    {
        Intent intent = new Intent(YoungActivity.this, MapTasksActivity.class);

        startActivity(intent);

    }
}
