package com.anurag.college_information.activities;

import static com.anurag.college_information.activities.CareerGoalActivity.SHARED_PREFS;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anurag.college_information.R;
import com.anurag.college_information.adapters.RecyclerAdapter;
import com.anurag.college_information.models.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class CollegeListActivity extends AppCompatActivity {

    private RecyclerAdapter.RecyclerViewClickListener listener;

    //ListView collegeList;
    TextView collegeListTitle;
    Button courseChange;
    RecyclerView recyclerView;
    LinearLayoutManager LayoutManager;
    RecyclerAdapter recyclerAdapter;
    List<ModelClass>cList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);


        initData();
        initRecyclerView();
        


        String[] colleges = {"Shivajirao Jondhale, Asangaon", "Shivajirao Jondhale, Dombivli", "Terna, Thane", "KC, thane", "A.P. Shah, Thane", "IIT Bombay, Mumbai"};

        //collegeList = findViewById(R.id.lv_college_list);
        collegeListTitle = findViewById(R.id.college_list_title);
        courseChange = findViewById(R.id.btn_change_course);
        courseChange.setTransformationMethod(null);



        courseChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent i = new Intent(CollegeListActivity.this, CareerGoalActivity.class);
                startActivity(i);
                finish();

            }
        });

        collegeListTitle.setText(getIntent().getStringExtra("Title")+" Colleges");

    }

    private void initData() {
        cList = new ArrayList<>();

        cList.add(new ModelClass(R.drawable.jondhale_college_building, "Shivajirao S jondhale College, Asangaon", "3.2"));
        cList.add(new ModelClass(R.drawable.iit_bombay, "Indian Institute of Technology, Mumbai", "5.0"));
        cList.add(new ModelClass(R.drawable.ap_shah, "A.P. Shah College of Engineering, Thane", "4.0"));
        cList.add(new ModelClass(R.drawable.vjti, "Veermata Jeejabai Technology Institute, Mumbai", "4.7"));
        cList.add(new ModelClass(R.drawable.terna, "Terna Institute of Technology, Thane", "3.9"));
    }

    private void initRecyclerView() {
        setOnClickListener();
        
        recyclerView = findViewById(R.id.recycler_view);
        LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerAdapter = new RecyclerAdapter(cList, listener);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }

    private void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(CollegeListActivity.this, CollegeDetailsActivity.class);

                // send college name to the CollegeDetails activity
                // to display the respective college details
                // here Using Intent.putExtra

                startActivity(i);
            }
        };
    }

}