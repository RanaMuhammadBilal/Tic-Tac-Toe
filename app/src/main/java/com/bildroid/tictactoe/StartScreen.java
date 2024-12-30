package com.bildroid.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartScreen extends AppCompatActivity {

    EditText player1, player2;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player1.getText().toString().length() > 2 && player2.getText().toString().length() > 2) {
                    String player1Name = player1.getText().toString();
                    String player2Name = player2.getText().toString();

                    player1.setText("");
                    player2.setText("");

                    Intent intent = new Intent(StartScreen.this, MainActivity.class);
                    intent.putExtra("player1", player1Name);
                    intent.putExtra("player2", player2Name);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Please Fill all Fields", Toast.LENGTH_SHORT).show();
                    if (player1.getText().toString().length() < 3){
                        player1.setError("Name will be more than 2 letters");
                    }
                    if (player2.getText().toString().length() < 3) {
                        player2.setError("Name will be more than 2 letters");
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder extDialog = new AlertDialog.Builder(this);

        extDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        extDialog.setTitle("Exit");
        extDialog.setMessage("are you sure you want to exit?");
        extDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StartScreen.super.onBackPressed();
            }
        });
        extDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //null
            }
        });

        extDialog.show();
    }
}