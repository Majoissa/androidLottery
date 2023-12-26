package com.majoissa.lotteryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private EditText num3;
    private EditText num4;
    private EditText num5;

    private int winNumber;
    private String winNumberStr;

    private Random random;

    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentWin = new Intent (this, win.class);
        Intent intentLose = new Intent (this, Lose.class);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        btn = findViewById(R.id.play);
        //Strings de los valores anteriores

        //combinacion ganadora aleatoria

        random = new Random();
        winNumber = random.nextInt(90000) + 10000;
        winNumberStr = String.valueOf(winNumber);
        //winNumberStr = "19961";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creo variables strings de los objetos obtenidos de los edittexts
                String num1str = num1.getText().toString();
                String num2str = num2.getText().toString();
                String num3str = num3.getText().toString();
                String num4str = num4.getText().toString();
                String num5str = num5.getText().toString();
                //creo una variable que almacene los 5 numeros introducidos para enseñarla luego en las otras activities
                String numInput = num1str + num2str + num3str + num4str + num5str;

                intentWin.putExtra("winNum", winNumberStr);
                intentLose.putExtra("winNum", winNumberStr);
                intentWin.putExtra("numInput", numInput);
                intentLose.putExtra("numInput", numInput);

                if( (num1str + num2str + num3str + num4str + num5str).equals(winNumberStr)){
                 intentWin.putExtra("prize", "1");
                 startActivity(intentWin);
                }else if (!num1str.equals(winNumberStr.substring(0,1)) && (num2str + num3str + num4str + num5str).equals(winNumberStr.substring(1))){
                    intentWin.putExtra("prize", "2");
                    startActivity(intentWin);
                }else if (!(num1str + num2str).equals(winNumberStr.substring(0,2)) && (num3str + num4str + num5str).equals(winNumberStr.substring(2))){
                    intentWin.putExtra("prize", "3");
                    startActivity(intentWin);
                }else if (!(num1str + num2str + num3str).equals(winNumberStr.substring(0,3)) && (num4str + num5str).equals(winNumberStr.substring(3))){
                    intentWin.putExtra("prize", "4");
                    startActivity(intentWin);
                }else if (!(num1str + num2str + num3str + num4str).equals(winNumberStr.substring(0,4)) && num5str.equals(winNumberStr.substring(4))){
                    intentWin.putExtra("prize", "5");
                    startActivity(intentWin);
                }else{
                    startActivity(intentLose);
                }
            }
        });
    }
}