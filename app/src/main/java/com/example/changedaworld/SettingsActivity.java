package com.example.changedaworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.changedaworld.util.Restartable;
import com.example.changedaworld.util.ShureDeleteDialog;
import com.example.changedaworld.util.databaseutil.DatabaseHelper;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity implements Restartable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SwitchMaterial switchBtn = findViewById(R.id.switch1);

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    public void onResetClick(View view) {
        ShureDeleteDialog dialog = new ShureDeleteDialog();
        Bundle args = new Bundle();
        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "custom");
    }

    @Override
    public void restart() {
        DatabaseHelper databaseHelper;
        Cursor userCursor;
        SQLiteDatabase db;

        databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        databaseHelper.create_db();
        databaseHelper.open();

        db = databaseHelper.open();
        userCursor = db.rawQuery("DELETE FROM "+ DatabaseHelper.TABLE, null);
        userCursor.moveToFirst();
        db.close();
        userCursor.close();
    }
}