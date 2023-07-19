package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    // Text views
    TextView calculationText;
    TextView answerText;
    // Buttons
    MaterialButton cancelBtn;
    MaterialButton percentBtn;
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
    void noticeClickedButton(MaterialButton button)
    {
        button.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calculationText = findViewById(R.id.calculationText);
        answerText = findViewById(R.id.resultText);

        //assign xml buttons and add onlick listener to each so when a button is click, we know
        cancelBtn = findViewById(R.id.cancelBtn);
        noticeClickedButton(cancelBtn);
        memClearBtn = findViewById(R.id.memClearBtn);
        noticeClickedButton(memClearBtn);
        percentBtn = findViewById(R.id.memPlusBtn);
        noticeClickedButton(percentBtn);

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

    void clearScreen(TextView text)
    {
        text.setText("");
    }

    @Override
    public void onClick(View view)
    {
        // get values of clicked buttons
        MaterialButton button = (MaterialButton) view;
        // get value of clicked button
        String clickedbuttonText = button.getText().toString();
        if (clickedbuttonText.equals("x"))
            clickedbuttonText = "*";
        if (clickedbuttonText.equals("%"))
            clickedbuttonText = "*0.01";
        //get data already entered
        String numbersToCalculate = calculationText.getText().toString();

        if (clickedbuttonText.equals("C"))
        {
            answerText.setText("0");
            clearScreen(calculationText);
            return;
        }
        else
        {
                if (calculationText.length() > 9 && calculationText.length() <= 15)
                {
                    calculationText.setTextSize(40);
                    answerText.setTextSize(20);
                }
                else if (calculationText.length() > 15)
                {
                    calculationText.setTextSize(30);
                    answerText.setTextSize(20);
                }
                else
                {
                    calculationText.setTextSize(50);
                    answerText.setTextSize(30);
                }
                numbersToCalculate += clickedbuttonText;
        }



        if (clickedbuttonText.equals("="))
        {


            if (calculationText.getText().toString().endsWith("+") || calculationText.getText().toString().endsWith("-")
                    || calculationText.getText().toString().endsWith("*") || calculationText.getText().toString().endsWith("/"))
            {
                calculationText.setText("Syntax Error");
                answerText.setText("Syntax Error");
            }
            else
            {
                calculationText.setText(answerText.getText());
                clearScreen(answerText);
            }
            return;
        }

//        Calculate result and display to screen.
        if (!calculationText.getText().equals("Syntax Error"))
        {
            calculationText.setText(numbersToCalculate);

            String answer = getAnswer(numbersToCalculate);

            if (!answer.equals("Error"))
            {
                answerText.setText(answer);
            }

        }
    }




    String getAnswer(String expression)
    {

        try
        {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String answer = context.evaluateString(scriptable, expression, "Javascript",
                    1, null).toString();

            if (answer.equals("Infinity"))
            {
                return "Zero divisionError";
            }
            DecimalFormat dpFormatter = new DecimalFormat("#.####");
            dpFormatter.setRoundingMode(RoundingMode.CEILING);
            double resultNumber = Double.parseDouble(answer);

            return dpFormatter.format(resultNumber);
//            return answer;
        }
        catch (Exception error)
        {
            return "Error";
        }

    }

}
