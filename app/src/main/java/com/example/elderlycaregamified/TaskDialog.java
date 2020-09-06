package com.example.elderlycaregamified;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class TaskDialog extends AppCompatDialogFragment
{
    private EditText editTextTask;
    private EditText editTextLocation;
    private TaskDialogListener listener;

    private RadioGroup stickerRadioGroup;

    public static int stickerIcon;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view)
                .setTitle("Create Task")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String username = editTextTask.getText().toString();
                        String password = editTextLocation.getText().toString();
                        listener.applyTexts(username, password);
                    }
                });
        editTextTask = view.findViewById(R.id.edit_task);
        editTextLocation = view.findViewById(R.id.edit_location);


        stickerRadioGroup = (RadioGroup) view.findViewById(R.id.radiogroup_sticker);
        stickerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radio_boba:
                            stickerIcon = R.drawable.boba;
                        break;
                    case R.id.radio_panda:
                            stickerIcon = R.drawable.pandas;
                        break;
                    case R.id.radio_peach:
                            stickerIcon = R.drawable.peach;
                        break;
                    case R.id.radio_sushi:
                            stickerIcon = R.drawable.sushi;
                        break;
                }
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            listener = (TaskDialogListener) context;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() +
                    "must implement TaskDialogListener");
        }
    }

    public interface TaskDialogListener
    {
        void applyTexts(String task, String location);
    }
}
