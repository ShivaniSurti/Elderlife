package com.example.elderlycaregamified;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ElderlyActivity extends AppCompatActivity implements TaskDialog.TaskDialogListener
{

    private Button buttonTask;

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

    public static String address1 = "";
    public static String task1 = "";

    public static String address2 = "";
    public static String task2 = "";

    public static String address3 = "";
    public static String task3 = "";

    public static int elderCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elderly);

        buttonTask = (Button) findViewById(R.id.button_create_task);
        buttonTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        layout1 = (LinearLayout) findViewById(R.id.layout_elder_1);
        layout2 = (LinearLayout) findViewById(R.id.layout_elder_2);
        layout3 = (LinearLayout) findViewById(R.id.layout_elder_3);

        textViewTask1 = (TextView) findViewById(R.id.textView_task1);
        textViewLoc1 = (TextView) findViewById(R.id.textView_loc1);
        clearBtn1 = (Button) findViewById(R.id.button_elder_clear_1);

        clearBtn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                layout1.setVisibility(View.INVISIBLE);
            }
        });

        textViewTask2 = (TextView) findViewById(R.id.textView_task2);
        textViewLoc2 = (TextView) findViewById(R.id.textView_loc2);
        clearBtn2 = (Button) findViewById(R.id.button_elder_clear_2);

        clearBtn2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                layout2.setVisibility(View.INVISIBLE);
            }
        });


        textViewTask3 = (TextView) findViewById(R.id.textView_task3);
        textViewLoc3 = (TextView) findViewById(R.id.textView_loc3);
        clearBtn3 = (Button) findViewById(R.id.button_elder_clear_3);

        clearBtn3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                layout3.setVisibility(View.INVISIBLE);
            }
        });




    }

    public void openDialog() {
        TaskDialog exampleDialog = new TaskDialog();
        exampleDialog.show(getSupportFragmentManager(), "Task Dialog");
    }

    @Override
    public void applyTexts(String task, String location)
    {

        switch(elderCount)
        {
            case 1:
                layout1.setVisibility(View.VISIBLE);
                textViewTask1.setText(task);
                textViewLoc1.setText(location);
                address1 = location;
                task1 = task;
                elderCount++;
                break;
            case 2:
                textViewTask2.setText(task);
                textViewLoc2.setText(location);
                layout2.setVisibility(View.VISIBLE);

                address2 = location;
                task2 = task;
                elderCount++;
                break;
            case 3:
                textViewTask3.setText(task);
                textViewLoc3.setText(location);
                layout3.setVisibility(View.VISIBLE);
                address3 = location;
                task3= task;
                elderCount = 1;
                break;
            default:
                break;
        }
    }
}
