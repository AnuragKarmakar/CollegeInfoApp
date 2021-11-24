package com.anurag.college_information.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anurag.college_information.R;

public class CollegeDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_details);

        Button btnApply;
        btnApply = findViewById(R.id.btn_apply);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "The institute will be notified, of your application",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "The college will contact you, Thank you",Toast.LENGTH_LONG).show();
            }
        });
    }
}