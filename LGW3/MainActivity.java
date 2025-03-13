package com.example.lgw3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnToast) {
            displayToast("This is a toast!!");
        } else if (view.getId() == R.id.btnAlertDialog) {
            makeAndShowDialogBox("This is an AlertDialog");
        }
    }

    private void displayToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void makeAndShowDialogBox(String msg) {

        AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);

        // set message, title, and icon
        myDialogBox.setTitle("My Alert Dialog");
        myDialogBox.setMessage(msg);
        myDialogBox.setIcon(R.drawable.ic_launcher_background);

        // Set three option buttons
        myDialogBox.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "Yes" goes
                        // here
                    }
                });

        myDialogBox.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "No" goes
                        // here
                    }
                });

        myDialogBox.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "Cancel" goes
                        // here
                    }
                });

        myDialogBox.create();
        myDialogBox.show();
    }

}