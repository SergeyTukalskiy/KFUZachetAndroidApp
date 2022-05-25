package com.example.changedaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.changedaworld.util.databaseutil.DatabaseHelper;

import java.text.DecimalFormat;

public class StatisticsActivity extends AppCompatActivity {

    TextView percentage;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        percentage = findViewById(R.id.percentage);


        databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        databaseHelper.create_db();
    }
    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.open();
        //получаем данные из бд в виде курсора

        userCursor = db.rawQuery("select avg(" + DatabaseHelper.COLUMN_ISCORRECT + ") from " + DatabaseHelper.TABLE, null);
        userCursor.moveToFirst();
        double stat = Double.parseDouble(userCursor.getString(0)) * 100;
        String formattedDouble = new DecimalFormat("#0.00").format(stat);
        formattedDouble += "%";
        percentage.setText(formattedDouble);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}