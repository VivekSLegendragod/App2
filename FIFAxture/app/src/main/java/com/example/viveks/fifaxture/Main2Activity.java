package com.example.viveks.fifaxture;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AlertDialog.Builder builder = new AlertDialog.Builder(getCallingActivity());

        Intent intent = getIntent();
        String val = intent.getStringExtra("detail");

        TextView t1 = (TextView)findViewById(R.id.textView);
        TextView t2 = (TextView)findViewById(R.id.textView2);
        TextView date = (TextView)findViewById(R.id.textView3);
        TextView time = (TextView)findViewById(R.id.textView4);
        TextView ven = (TextView)findViewById(R.id.textView5);
        t1.setText(val);
    }
}
