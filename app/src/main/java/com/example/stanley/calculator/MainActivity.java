package com.example.stanley.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stanley.calculator.controller.CalculatorController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CalculatorController controller;
    Button button_add;
    Button button_subtract;
    Button button_multiply;
    Button button_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        controller = new CalculatorController();

        button_add = findViewById(R.id.btn_add);
        button_add.setOnClickListener(this);
        button_subtract = findViewById(R.id.btn_subtract);
        button_subtract.setOnClickListener(this);
        button_multiply = findViewById(R.id.btn_multiply);
        button_multiply.setOnClickListener(this);
        button_divide = findViewById(R.id.btn_divide);
        button_divide.setOnClickListener(this);
    }

    private void showResult(String result) {
        TextView viewCalculation = findViewById(R.id.textViewCalculation);
        viewCalculation.setText(result);
    }

    @Override
    public void onClick(View view) {
        EditText firstText = findViewById(R.id.editTextFirst);
        EditText secondText = findViewById(R.id.editTextSecond);
        String result;

        if (controller.isValidInput(firstText.getText().toString(), secondText.getText().toString())) {
            switch (view.getId()) {
                case R.id.btn_add:
                    result = controller.calculate(firstText.getText().toString(),
                            secondText.getText().toString(), '+');
                    showResult(result);
                    System.out.println("Plus " + result);
                    break;
                case R.id.btn_subtract:
                    result = controller.calculate(firstText.getText().toString(),
                            secondText.getText().toString(), '-');
                    showResult(result);
                    System.out.println("Minus " + result);
                    break;
                case R.id.btn_multiply:
                    result = controller.calculate(firstText.getText().toString(),
                            secondText.getText().toString(), '*');
                    showResult(result);
                    System.out.println("Multi " + result);
                    break;
                case R.id.btn_divide:
                    result = controller.calculate(firstText.getText().toString(),
                            secondText.getText().toString(), '/');
                    showResult(result);
                    System.out.println("Division " + result);
                    break;
                default:
                    break;
            }
        }
    }
}
