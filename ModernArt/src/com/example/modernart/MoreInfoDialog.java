package com.example.modernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;

public class MoreInfoDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog, null));

        builder.setPositiveButton(R.string.moma_website, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent =
                    new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.moma.org"));
            startActivity(intent);
            }
        });

        builder.setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        // Create the Alert Dialog
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Button pButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        Button nButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_NEGATIVE);

        pButton.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
        pButton.setTextColor(Color.WHITE);
        nButton.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
        nButton.setTextColor(Color.WHITE);
    }
}
