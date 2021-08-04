package com.example.assignmentsql;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, contact, dob;
    Button insert, update, delete,view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);


        // start ViewDataActivity
        view.setOnClickListener( view -> startActivity(new Intent(getApplicationContext(), ViewStudentDataActivity.class)) );

        insert.setOnClickListener(view -> {

                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String dobTxt = dob.getText().toString();

                Boolean checkinsertData = DB.insertuserdata(nameTxt,contactTxt,dobTxt);

                if(checkinsertData){
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "New Entry NOT Inserted", Toast.LENGTH_SHORT).show();
                }

        });

        update.setOnClickListener(view -> {

                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String dobTxt = dob.getText().toString();

                Boolean checkupdate = DB.updateuserdata(nameTxt,contactTxt,dobTxt);

                if(checkupdate){
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Entry not Updated", Toast.LENGTH_SHORT).show();
                }

        });

        delete.setOnClickListener(view -> {

                String nameTxt = name.getText().toString();

                Boolean checkdeletedata = DB.deleteuserdata(nameTxt);

                if(checkdeletedata){
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Entry not Deleted", Toast.LENGTH_SHORT).show();
                }
        });

    }
}
