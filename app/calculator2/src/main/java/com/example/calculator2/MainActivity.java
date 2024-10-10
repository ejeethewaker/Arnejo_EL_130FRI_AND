package com.example.calculator2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText e1, e2;
    private TextInputEditText t1;
    private Integer num1, num2;
    private String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button plus = findViewById(R.id.plusButton);
        Button minus = findViewById(R.id.minusButton);
        Button multiply = findViewById(R.id.multiplyButton);
        Button divide = findViewById(R.id.divideButton);



        e1 = (TextInputEditText) findViewById(R.id.firstNumberEditText);
        // defining the edit text 2 to e2
        e2 = (TextInputEditText) findViewById(R.id.secondNumberEditText);

        t1 = (TextInputEditText) findViewById(R.id.answerEditText);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = Objects.requireNonNull(e1.getText()).toString();
                s2 = Objects.requireNonNull(e2.getText()).toString();
                num1 = Integer.parseInt(s1);
                num2 = Integer.parseInt(s2);
                int sum = num1 + num2;
                t1.setText(Integer.toString(sum));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = Objects.requireNonNull(e1.getText()).toString();
                s2 = Objects.requireNonNull(e2.getText()).toString();
                num1 = Integer.parseInt(s1);
                num2 = Integer.parseInt(s2);
                int sum = num1 - num2;
                t1.setText(Integer.toString(sum));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = Objects.requireNonNull(e1.getText()).toString();
                s2 = Objects.requireNonNull(e2.getText()).toString();
                num1 = Integer.parseInt(s1);
                num2 = Integer.parseInt(s2);
                int sum = num1 * num2;
                t1.setText(Integer.toString(sum));
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = Objects.requireNonNull(e1.getText()).toString();
                s2 = Objects.requireNonNull(e2.getText()).toString();
                num1 = Integer.parseInt(s1);
                num2 = Integer.parseInt(s2);
                double sum = num1 / (num2 * 1.0);
                t1.setText(Double.toString(sum));
            }
        });
    }


}