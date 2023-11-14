package com.itschool.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonEquals;
    Button buttonOpen, buttonClose, buttonDot, buttonDel, buttonAC;
    TextView formula;


    private void initView() {
        formula = findViewById(R.id.formula);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);

        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMulti = findViewById(R.id.button_multi);
        buttonDiv = findViewById(R.id.button_div);
        buttonEquals = findViewById(R.id.button_equals);

        buttonOpen = findViewById(R.id.button_open);
        buttonClose = findViewById(R.id.button_close);
        buttonDot = findViewById(R.id.button_dot);
        buttonDel = findViewById(R.id.button_del);
        buttonAC = findViewById(R.id.button_ac);

    }

//    @SuppressLint("MissingInflatedId")
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        View.OnClickListener listener = v -> {
            formula.setText(formula.getText().toString() + ((Button)v).getText().toString());
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonMulti.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);
        buttonClose.setOnClickListener(listener);
        buttonOpen.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        buttonEquals.setOnClickListener(v -> {
            try {
                Expression expression = new ExpressionBuilder(formula.getText().toString()).build();
                double result = expression.evaluate();
                formula.setText(Double.toString(result));
            } catch (Exception e) {
                formula.setText("Ошибка");
            }
        });

        buttonAC.setOnClickListener(v -> {
            formula.setText("");
        });

        buttonDel.setOnClickListener(v -> {
            String text = formula.getText().toString();
            if (text.isEmpty()) return;
            formula.setText(text.substring(0, text.length() - 1));
        });
    }
}



