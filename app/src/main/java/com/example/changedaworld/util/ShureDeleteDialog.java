package com.example.changedaworld.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ShureDeleteDialog extends DialogFragment {
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

        return builder
                .setTitle("Э!")
                .setIcon(android.R.drawable.btn_minus)
                .setMessage("Вы уверены?")
                .setPositiveButton("Да", (dialog, which) -> restartable.restart())
                .setNegativeButton("Нет", null)
                .create();


    }
}
