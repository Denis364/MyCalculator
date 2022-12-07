package com.github.denis364.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button calculate = findViewById(R.id.calc);

        calculate.setOnClickListener(v -> calculateAnswer());
    }

    @SuppressLint("SetTextI18n")
    private void calculateAnswer() {

        EditText numberOne = findViewById(R.id.editTextNumberDecimal);
        EditText numberTwo = findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = findViewById(R.id.add);
        RadioButton sub = findViewById(R.id.subtract);
        RadioButton multiple = findViewById(R.id.multiple);
        RadioButton divide = findViewById(R.id.divide);

        TextView answer = findViewById(R.id.result);

        float numberone = 0;
        float numbertwo = 0;
        String num1 = numberOne.getText().toString();
        String num2 = numberTwo.getText().toString();

        if (!num1.equals("")) {
            numberone = Integer.parseInt(numberOne.getText().toString());
        }
        if (!num2.equals("")) {
            numbertwo = Integer.parseInt(numberTwo.getText().toString());
        }
        float solution = 0;
        if (add.isChecked()) {
            solution = numberone + numbertwo;
        }
        if (sub.isChecked()) {
            solution = numberone - numbertwo;
        }
        if (multiple.isChecked()) {
            solution = numberone * numbertwo;
        }
        if (divide.isChecked()) {
            if (numbertwo == 0) {
                Toast.makeText(this, "Number Two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numberone / numbertwo;
        }
        answer.setText("The answer is " + solution);
    }
}