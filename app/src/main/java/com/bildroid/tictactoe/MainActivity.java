package com.bildroid.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView firstPointer, secondPointer, player1Name, player2Name;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnR;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag =0;
    int count =0;
    Dialog dialog;
    Button custom_no_btn, custom_yes_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstPointer = findViewById(R.id.firstPointer);
        secondPointer = findViewById(R.id.secondPointer);
        player1Name = findViewById(R.id.player1name);
        player2Name = findViewById(R.id.player2name);



        String player1 = getIntent().getStringExtra("player1");
        String player2 = getIntent().getStringExtra("player2");

        player1Name.setText(player1);
        player2Name.setText(player2);

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);

        custom_no_btn = dialog.findViewById(R.id.custom_no_btn);
        custom_no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        custom_yes_btn = dialog.findViewById(R.id.custom_yes_btn);
        custom_yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
                firstPointer.setVisibility(View.VISIBLE);
                secondPointer.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Game is Reset!!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        btnR = findViewById(R.id.btnR);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        init();
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }


    public void check (View view){
    Button btnCurrent = (Button) view;
    if (btnCurrent.getText().toString().equals("")){

        count++;

        if(flag==0){
          btnCurrent.setText("X");
          btnCurrent.setTextColor(Color.RED);
          firstPointer.setVisibility(View.INVISIBLE);
          secondPointer.setVisibility(View.VISIBLE);
          flag =1;
        }else {
            btnCurrent.setText("O");
            btnCurrent.setTextColor(Color.GREEN);
            firstPointer.setVisibility(View.VISIBLE);
            secondPointer.setVisibility(View.INVISIBLE);
            flag =0;
        }
            if(count>4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //Conditions

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, "Winner is: " + b4, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    Toast.makeText(this, "Winner is: " + b7, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    Toast.makeText(this, "Winner is: " + b2, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is: " + b3, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is: " + b3, Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();

                }else if(count==9){
                    Toast.makeText(this, "Match is Draw!!!", Toast.LENGTH_SHORT).show();
                    firstPointer.setVisibility(View.VISIBLE);
                    secondPointer.setVisibility(View.INVISIBLE);
                    newGame();
                }
            }

        }

    }
    public View.OnClickListener newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag =0;
        count =0;
        return null;
    }

}
