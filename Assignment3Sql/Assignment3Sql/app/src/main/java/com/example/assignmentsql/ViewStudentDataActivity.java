package com.example.assignmentsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewStudentDataActivity extends AppCompatActivity {

    RecyclerView studentListview;
    TextView heading;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        heading = findViewById(R.id.view_results);

        ArrayList<StudentDataModel> studentsList = getStudentList();

        if(studentsList.size() == 0)
            heading.setText("No data!");
        else{
            // Recycler view
            studentListview = findViewById(R.id.student_listview);
            StudentAdapter studentAdapter = new StudentAdapter(this, studentsList);
            studentListview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            studentListview.setAdapter(studentAdapter);
        }

    }

    public ArrayList<StudentDataModel> getStudentList(){

        Cursor res = new DBHelper(this).getdata();
        ArrayList<StudentDataModel> studentsList = new ArrayList<>();

        while(res.moveToNext()){
            StudentDataModel student = new StudentDataModel();
            student.setName(res.getString(0));
            student.setAddress(res.getString(1));
            student.setDob(res.getString(2));
            studentsList.add(student);
        }
        return studentsList;
    }

}