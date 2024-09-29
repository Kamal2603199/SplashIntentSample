package com.example.splashintentsample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String studentName = fromAct.getStringExtra("StudentName");
        int rollNo = fromAct.getIntExtra("Roll No", Integer.parseInt("0"));

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);
        txtStudentInfo.setText("RollNo:"+rollNo+", Name: "+ studentName);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

    }
}