package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionRVAdapter extends RecyclerView.Adapter<QuestionRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<QuestionModal> questionModalArrayList;
    private Context context;

    // constructor
    public QuestionRVAdapter(ArrayList<QuestionModal> questionModalArrayList, Context context) {
        this.questionModalArrayList = questionModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        QuestionModal modal = questionModalArrayList.get(position);
        holder.questionTV.setText(modal.getQuestion());
        holder.choice1TV.setText(modal.getChoice1());
        holder.choice2TV.setText(modal.getChoice2());

        holder.choice3TV.setText(modal.getChoice3());
        holder.choice4TV.setText(modal.getChoice4());
        holder.answerTV.setText(modal.getAnswer());


    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return questionModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private final TextView questionTV;
        private final TextView choice1TV;
        private final TextView choice2TV;
        private final TextView choice3TV;
        private final TextView choice4TV;
        private final TextView answerTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            questionTV = itemView.findViewById(R.id.idTVQuestion);
            choice1TV = itemView.findViewById(R.id.idTVChoice1);
            choice2TV = itemView.findViewById(R.id.idTVChoice2);
            choice3TV = itemView.findViewById(R.id.idTVChoice3);
            choice4TV = itemView.findViewById(R.id.idTVChoice4);
            answerTV = itemView.findViewById(R.id.idTVAnswer);
        }
    }
}