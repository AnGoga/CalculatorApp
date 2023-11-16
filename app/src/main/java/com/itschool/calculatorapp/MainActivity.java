package com.itschool.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itschool.calculatorapp.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener listener = v -> {
            binding.formula.setText(binding.formula.getText().toString() + ((Button)v).getText().toString());
        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonMinus.setOnClickListener(listener);
        binding.buttonMulti.setOnClickListener(listener);
        binding.buttonPlus.setOnClickListener(listener);
        binding.buttonDiv.setOnClickListener(listener);
        binding.buttonClose.setOnClickListener(listener);
        binding.buttonOpen.setOnClickListener(listener);
        binding.buttonDot.setOnClickListener(listener);

        binding.buttonEquals.setOnClickListener(v -> {
            try {
                Expression expression = new ExpressionBuilder(binding.formula.getText().toString()).build();
                double result = expression.evaluate();
                binding.formula.setText(Double.toString(result));
            } catch (Exception e) {
                binding.formula.setText("Ошибка");
            }
        });

        binding.buttonAc.setOnClickListener(v -> {
            binding.formula.setText("");
        });

        binding.buttonDel.setOnClickListener(v -> {
            String text = binding.formula.getText().toString();
            if (text.isEmpty()) return;
            binding.formula.setText(text.substring(0, text.length() - 1));
        });
    }
}



