package com.example.changedaworld.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.changedaworld.SolveActivity;

public class ProblemDialog extends DialogFragment {

    private Restartable restartable;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        restartable = (Restartable) context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Boolean isCorrect = getArguments().getBoolean("isCorrect");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (isCorrect) {
            return builder
                    .setTitle("Правильно!")
                    .setIcon(android.R.drawable.btn_plus)
                    .setMessage("Решаем дальше?")
                    .setPositiveButton("OK", (dialog, which) -> restartable.restart())
                    .setNegativeButton("Отмена", null)
                    .create();
        } else {
            return builder
                    .setTitle("Неправильно :(")
                    .setIcon(android.R.drawable.btn_minus)
                    .setMessage("Решаем дальше?")
                    .setPositiveButton("OK", (dialog, which) -> restartable.restart())
                    .setNegativeButton("Отмена", null)
                    .create();
        }

    }
}
