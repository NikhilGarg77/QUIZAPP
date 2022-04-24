package com.example.project;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question(" When did Google acquire Android ?",
                    new String[]{"2001", "2003", "2004", "2005"}, "2005"));
            myDataBaseHelper.addInitialQuestion(new Question(" In which Android Studio file, most coding is done?",
                    new String[]{"MainActivity.java", "AndroidManifest.xml", "ActivityMain.xml", "None of the above"}, "MainActivity.java"));
            myDataBaseHelper.addInitialQuestion(new Question(" What widget can replace any use of radio buttons?",
                    new String[]{"Toggle Button", "Spinner", "Switch Button", "ImageButton"}, "Spinner"));
            myDataBaseHelper.addInitialQuestion(new Question(" Which folder do you copy/paste an image into?",
                    new String[]{"Java", "Resources", "Layout", "Drawable"}, "Drawable"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}