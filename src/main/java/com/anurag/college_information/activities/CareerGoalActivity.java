package com.anurag.college_information.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anurag.college_information.R;

public class CareerGoalActivity extends AppCompatActivity {

    ListView goalList;
    String goal;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String GOAL = "goal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_goal);

        String[] goals = {"BE/BTech", "Pharmacy", "BSc", "BArch", "Commerce", "Arts", "Science", "MSc/MTech"};

        goalList = findViewById(R.id.lv_goals_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(CareerGoalActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, goals);

        goalList.setAdapter(adapter);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        goal = sharedPreferences.getString(GOAL, "");

        System.out.println("Goal is " + goal);


        if(!(goal.equals(""))){

            Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
            i.putExtra("Title", goal);
            //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
            startActivity(i);
            finish();
        }

        else {
            goalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getApplicationContext(),
                            "you clicked >> " + goals[position],
                            Toast.LENGTH_SHORT).show();

                    saveGoal(goals[position]);

                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    goal = sharedPreferences.getString(GOAL, "");

                    if (goal.equals("BE/BTech")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }

                    else if (goal.equals("Pharmacy")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("BSc")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("BArch")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("Commerce")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("Arts")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("Science")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }else if (goal.equals("MSc/MTech")) {

                        Intent i = new Intent(CareerGoalActivity.this, CollegeListActivity.class);
                        //Intent i = new Intent(CareerGoalActivity.this, CollegeDetailsActivity.class);
                        i.putExtra("Title", goal);
                        startActivity(i);
                        finish();

                    }


                }
            });
        }
    }

    public void saveGoal(String g){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(GOAL, g);
        editor.apply();
        System.out.println("Goal is "+ g);

    }


}