package com.example.project21;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class GameEndDialog extends DialogFragment {

    private GameActivity activity;
    private View rootView;
    private Dialog dialog;

    public static GameEndDialog newInstance(GameActivity activity){
        GameEndDialog dialog = new GameEndDialog();
        dialog.activity = activity;

        return  dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialog.cancel();
                    }
                })
                .setTitle("End Game")
                .setMessage(activity.getMsg())
                .setView(rootView)
                .setCancelable(true)
                .create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);
        return alertDialog;
    }


}