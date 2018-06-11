package com.example.viveks.fifapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    DatabaseHelper myDb;

    final Button edi = (Button)findViewById(R.id.button2);
    final Button del = (Button) findViewById(R.id.button3);
    final Button cre = (Button)findViewById(R.id.button);

    ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
    ListView lv = (ListView)findViewById(R.id.list);
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, final View view, final int position, long id) {
                del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Object a = adapter.getItem(position);
                        adapter.remove(a);
                    }
                });

                edi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Object a = adapter.getItem(position);
                        adapter.remove(a);
                        openDialog();
                        adapter.insert(s, position);


                    }
                });
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                lv.setAdapter(adapter);
                adapter.add(s);
            }
        });
    }


    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }

    @Override
    public void applyTexts(String team1, String team2, String date, String time, String venue) {

        s = team1 + "vs" + team2 + "on" + date + time + "at" + venue;

    }
}
