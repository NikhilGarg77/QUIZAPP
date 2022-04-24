package com.example.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateQuizActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText questionEdt, choice3Edt, choice1Edt, choice2Edt, choice4Edt, answerEdt;
    private Button addQuesBtn, previewQuesBtn;
    private DBHandler dbHandler;
    Button backToMain, Cancel;
    SharedPreferences preferences;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        // initializing all our variables.
        questionEdt = findViewById(R.id.idEdtQuestion);

        choice1Edt = findViewById(R.id.idEdtChoice1);
        choice2Edt = findViewById(R.id.idEdtChoice2);
        choice3Edt = findViewById(R.id.idEdtChoice3);
        choice4Edt = findViewById(R.id.idEdtChoice4);
        answerEdt = findViewById(R.id.idEdtAnswer);
        addQuesBtn = findViewById(R.id.idBtnAddQuestion);
        previewQuesBtn = findViewById(R.id.idBtnPreviewQues);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(CreateQuizActivity.this);

        // below line is to add on click listener for our add course button.
        addQuesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String question = questionEdt.getText().toString();

                String choice1 = choice1Edt.getText().toString();
                String choice2 = choice2Edt.getText().toString();
                String choice3 = choice3Edt.getText().toString();
                String choice4 = choice4Edt.getText().toString();

                String answer = answerEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (question.isEmpty() && choice1.isEmpty() && choice2.isEmpty() && choice3.isEmpty() && choice4.isEmpty() && answer.isEmpty()) {
                    Toast.makeText(CreateQuizActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(question, choice1, choice2, choice3, choice4, answer);

                // after adding the data we are displaying a toast message.
                Toast.makeText(CreateQuizActivity.this, "Question has been added.", Toast.LENGTH_SHORT).show();
                questionEdt.setText("");
                choice1Edt.setText("");
                choice2Edt.setText("");
                choice3Edt.setText("");
                choice4Edt.setText("");
                answerEdt.setText("");
            }
        });

        previewQuesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(CreateQuizActivity.this, com.example.project.ViewQuestions.class);
                startActivity(i);
            }
        });
        backToMain = (Button)findViewById(R.id.backToMain);
        Cancel = (Button)findViewById(R.id.cancel);


        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateQuizActivity.this, WelcomeActivity.class);
                startActivity(i);
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view){
                emptyField();
            }

        });
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

    public void emptyField(){
        questionEdt.setText("");
        choice1Edt.setText("");
        choice2Edt.setText("");
        choice3Edt.setText("");
        choice4Edt.setText("");
        answerEdt.setText("");
    }

}