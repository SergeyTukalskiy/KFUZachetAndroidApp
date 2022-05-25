package com.example.changedaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.changedaworld.util.ProblemDialog;
import com.example.changedaworld.util.ProblemGenerator;
import com.example.changedaworld.util.ProblemSolver;
import com.example.changedaworld.util.Restartable;
import com.example.changedaworld.util.databaseutil.DatabaseHelper;

public class SolveActivity extends AppCompatActivity implements Restartable {

    TextView textView;
    String problem = "";
    String solution;
    ProblemGenerator generator;
    ProblemSolver solver;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        textView = findViewById(R.id.problemTextView);
        generator = new ProblemGenerator(10);
        solver = new ProblemSolver();
        while (problem.length() < 5) {
            problem = generator.Gen("E");
        }
        solution = String.valueOf(solver.Expr(problem)[0]);
        textView.setText(problem);

        sqlHelper = new DatabaseHelper(getApplicationContext());
        sqlHelper.create_db();
    }

    @Override
    public void onResume() {
        super.onResume();
        db = sqlHelper.open();
    }

    public void onCheckClick(View view) {
        EditText answer = findViewById(R.id.solutionEdit);
        ProblemDialog dialog = new ProblemDialog();
        Bundle args = new Bundle();
        Boolean isCorrect = answer.getText().toString().equals(solution);
        int correctKostyl = 0;
        if (isCorrect) {
            correctKostyl = 1;
        }
        args.putBoolean("isCorrect", isCorrect);
        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "custom");
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_PROBLEM, problem);
        cv.put(DatabaseHelper.COLUMN_SOLUTION, answer.getText().toString());
        cv.put(DatabaseHelper.COLUMN_ISCORRECT, correctKostyl);
        db.insert(DatabaseHelper.TABLE, null, cv);
    }

    @Override
    public void restart() {
        problem = "";
        while (problem.length() < 5) {
            problem = generator.Gen("E");
        }
        solution = String.valueOf(solver.Expr(problem)[0]);
        textView.setText(problem);
    }
}