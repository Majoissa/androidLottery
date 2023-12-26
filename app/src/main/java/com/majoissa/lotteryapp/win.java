package com.majoissa.lotteryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class win extends AppCompatActivity {
    private TextView prizeValue;
    private TextView winNumber;
    private TextView inputNumber;
    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        Intent intentMain = new Intent(this, MainActivity.class);

        Intent intent = getIntent();
        String prizeMessage = intent.getStringExtra("prize");
        String inputNumberMessage = intent.getStringExtra("numInput");
        String winNumberMessage = intent.getStringExtra("winNum");



        prizeValue = findViewById(R.id.prize2);
        inputNumber= findViewById(R.id.textView);
        winNumber= findViewById(R.id.textView2);

        prizeValue.setText(prizeMessage);
        inputNumber.setText(inputNumberMessage);
        winNumber.setText(winNumberMessage);

        btn = findViewById(R.id.playagain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentMain);
            }
        });
    }
}