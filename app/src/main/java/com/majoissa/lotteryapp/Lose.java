package com.majoissa.lotteryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity {
    private TextView winNumber;
    private TextView inputNumber;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        Intent intentMain = new Intent(this, MainActivity.class);

        Intent intent = getIntent();
        String inputNumberMessage = intent.getStringExtra("numInput");
        String winNumberMessage = intent.getStringExtra("winNum");

        inputNumber= findViewById(R.id.textView5);
        winNumber= findViewById(R.id.textView4);

        inputNumber.setText(inputNumberMessage);
        winNumber.setText(winNumberMessage);
        btn = findViewById(R.id.playagain2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentMain);
            }
        });
    }
}