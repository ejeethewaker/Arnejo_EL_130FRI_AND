package com.example.calculator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculator.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Integer num1, num2;
    private TextView t1;
    private TextInputEditText e1, e2;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        setContentView(R.layout.activity_main);
        e1 = (TextInputEditText) findViewById(R.id.FirstNumberTextInput);
        // defining the edit text 2 to e2
        e2 = (TextInputEditText) findViewById(R.id.SecondNumberTextInput);

        calc = (Button) findViewById(R.id.calculateButton);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public boolean getNumbers() {

        //checkAndClear();
        // defining the edit text 1 to e1
        e1 = (TextInputEditText) findViewById(R.id.FirstNumberTextInput);

        // defining the edit text 2 to e2
        e2 = (TextInputEditText) findViewById(R.id.SecondNumberTextInput);

        // defining the text view to t1
        t1 = (TextView) findViewById(R.id.resultTextView3);

        // taking input from text box 1
        String s1 = e1.getText().toString();

        // taking input from text box 2
        String s2 = e2.getText().toString();




        if(s1.equals("Please enter value 1") && s2.equals(null))
        {
            String result = "Please enter value 2";
            e2.setText(result);
            return false;
        }
        if(s1.equals(null) && s2.equals("Please enter value 2"))
        {
            String result = "Please enter value 1";
            e1.setText(result);
            return false;
        }
        if(s1.equals("Please enter value 1") || s2.equals("Please enter value 2"))
        {
            return false;
        }

        if((!s1.equals(null) && s2.equals(null))|| (!s1.equals("") && s2.equals("")) ){

            String result = "Please enter value 2";

            e2.setText(result);
            return false;
        }
        if((s1.equals(null) && !s2.equals(null))|| (s1.equals("") && !s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1";
            e1.setText(result);
            return false;
        }
        if((s1.equals(null) && s2.equals(null))|| (s1.equals("") && s2.equals("")) ){
            //checkAndClear();
            String result1 = "Please enter value 1";
            e1.setText(result1);
            String result2 = "Please enter value 2";
            e2.setText(result2);
            return false;
        }

        else {
            // converting string to int.
            num1 = Integer.parseInt(s1);

            // converting string to int.
            num2 = Integer.parseInt(s2);


        }

        return true;
    }

    public void doSum(View v) {

        // get the input numbers
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Error Please enter Required Values");
        }

    }

    // a public method to perform subtraction
    public void doSub(View v) {
        //checkAndClear();
        // get the input numbers
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Error Please enter Required Values");
        }
    }

    // a public method to perform multiplication
    public void doMul(View v) {
        //checkAndClear();
        // get the input numbers
        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
        else
        {
            t1.setText("Error Please enter Required Values");
        }
    }

    // a public method to perform Division
    public void doDiv(View v) {
        //checkAndClear();
        // get the input numbers
        if (getNumbers()) {

            // displaying the text in text view assigned as t1
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
        else
        {
            t1.setText("Error Please enter Required Values");
        }
    }

    public void doCal(View v){

    }
}