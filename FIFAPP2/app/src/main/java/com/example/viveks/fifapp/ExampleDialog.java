package com.example.viveks.fifapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    DatabaseHelper myDb;

    private EditText id;
    private EditText t1;
    private EditText t2;
    private EditText da;
    private EditText ti;
    private EditText ven;
    private ExampleDialogListener listener;



    public Dialog onCreateDialog(Bundle savedInstanceState, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        myDb = new DatabaseHelper(this, context);

        builder.setView(view)
                .setTitle("Enter Fixture")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String iden = id.getText().toString();
                        String team1 = t1.getText().toString();
                        String team2 = t2.getText().toString();
                        String date = da.getText().toString();
                        String time = ti.getText().toString();
                        String venue = ven.getText().toString();
                        listener.applyTexts(team1, team2, date, time, venue);
                        myDb.insertData(team1, team2, date, time, venue);

                    }
                });

        id = view.findViewById(R.id.text0);
        t1 = view.findViewById(R.id.text);
        t2 = view.findViewById(R.id.text2);
        da = view.findViewById(R.id.text3);
        ti = view.findViewById(R.id.text4);
        ven = view.findViewById(R.id.text5);


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String team1, String team2, String date, String time, String venue);
    }

    public void AddData(){
    }
}
