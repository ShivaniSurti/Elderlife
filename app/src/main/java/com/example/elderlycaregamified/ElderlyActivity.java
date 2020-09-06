package com.example.elderlycaregamified;

import android.location.Address;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ElderlyActivity extends AppCompatActivity implements TaskDialog.TaskDialogListener
{

    private Button buttonTask;
    private TextView textViewTask1;
    private TextView textViewLoc1;

    public static String address1 = "";
    public static String task1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elderly);

        buttonTask = (Button) findViewById(R.id.button_create_task);

        textViewTask1 = (TextView) findViewById(R.id.textView_task1);
        textViewLoc1 = (TextView) findViewById(R.id.textView_loc1);

        buttonTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
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
        textViewTask1.setText(task);
        textViewLoc1.setText(location);

        address1 = location;
        task1 = task;
    }
}
