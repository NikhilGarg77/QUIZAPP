package com.example.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewQuestions extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<QuestionModal> questionModalArrayList;
    private DBHandler dbHandler;
    private QuestionRVAdapter questionRVAdapter;
    private RecyclerView coursesRV;
    Button logout, back;
    SharedPreferences preferences;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_questions);

        // initializing our all variables.
        questionModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewQuestions.this);
        logout = (Button)findViewById(R.id.logout);
        back = (Button)findViewById(R.id.back);
        preferences = getSharedPreferences("UserInfo", 0);
        intent = new Intent(ViewQuestions.this, LoginActivity.class);

        //logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewQuestions.this, CreateQuizActivity.class);
                startActivity(intent);
            }
        });

        // getting our course array
        // list from db handler class.
        questionModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        questionRVAdapter = new QuestionRVAdapter(questionModalArrayList, ViewQuestions.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewQuestions.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(questionRVAdapter);
    }
    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this).setIcon(R.drawable.fjacalogo).setTitle("Exit")
                .setMessage("Are You Sure?..")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();

                    }
                }).setNegativeButton("No", null).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
}