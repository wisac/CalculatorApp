package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Text views
    TextView calculationText;
    TextView answerText;
    // Buttons
    MaterialButton cancelBtn;
    MaterialButton memPlusBtn;
    MaterialButton memClearBtn;
    MaterialButton plusBtn;
    MaterialButton minusBtn;
    MaterialButton multiplyBtn;
    MaterialButton divideBtn;
    MaterialButton equalBtn;
    MaterialButton button0;
    MaterialButton button1;
    MaterialButton button2;
    MaterialButton button3;
    MaterialButton button4;
    MaterialButton button5;
    MaterialButton button6;
    MaterialButton button7;
    MaterialButton button8;
    MaterialButton button9;
    MaterialButton dotBtn;

    //function for settings on click listener to all buttons
    void noticeClickedButton(MaterialButton button) {
        button.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calculationText = findViewById(R.id.calculationText);
        answerText = findViewById(R.id.resultText);

        //assign xml buttons and add onlick listener to each so when a button is click, we know
        cancelBtn = findViewById(R.id.cancelBtn);
        noticeClickedButton(cancelBtn);
        memClearBtn = findViewById(R.id.memClearBtn);
        noticeClickedButton(memClearBtn);
        memPlusBtn = findViewById(R.id.memPlusBtn);
        noticeClickedButton(memPlusBtn);

        plusBtn = findViewById(R.id.plusBtn);
        noticeClickedButton(plusBtn);

        minusBtn = findViewById(R.id.minusBtn);
        noticeClickedButton(minusBtn);

        multiplyBtn = findViewById(R.id.mulBtn);
        noticeClickedButton(multiplyBtn);

        divideBtn = findViewById(R.id.divBtn);
        noticeClickedButton(divideBtn);

        equalBtn = findViewById(R.id.equalBtn);
        noticeClickedButton(equalBtn);

        dotBtn = findViewById(R.id.dotBtn);
        noticeClickedButton(dotBtn);

        button0 = findViewById(R.id.button0);
        noticeClickedButton(button0);

        button1 = findViewById(R.id.button1);
        noticeClickedButton(button1);

        button2 = findViewById(R.id.button2);
        noticeClickedButton(button2);

        button3 = findViewById(R.id.button3);
        noticeClickedButton(button3);

        button4 = findViewById(R.id.button4);
        noticeClickedButton(button4);

        button5 = findViewById(R.id.button5);
        noticeClickedButton(button5);

        button6 = findViewById(R.id.button6);
        noticeClickedButton(button6);

        button7 = findViewById(R.id.button7);
        noticeClickedButton(button7);

        button8 = findViewById(R.id.button8);
        noticeClickedButton(button8);

        button9 = findViewById(R.id.button9);
        noticeClickedButton(button9);


    }

    @Override
    public void onClick(View view) {
        // get values of clicked buttons
        MaterialButton button = (MaterialButton) view;
        // get value of clicked button
        String clickedbuttonText = button.getText().toString();
        //get data alredy entered
        String numbersToCalculate = calculationText.getText().toString();
        //append new entered data to old data on screen
        numbersToCalculate += clickedbuttonText;
        //display all entered data on screen
        calculationText.setText(numbersToCalculate);




    }


}