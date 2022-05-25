package com.example.changedaworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.version:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Версия номер раз", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.devs:
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Трое нас", Toast.LENGTH_SHORT);
                toast1.show();
                return true;
            case R.id.exit:
                finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSolveClick(View view) {
        Intent intent = new Intent(this, SolveActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }


    public void onLinksClick(View view) {
        Intent intent = new Intent(this, LinksActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void onStatsClick(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}