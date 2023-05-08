package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME = "userName";
    private TextView textViewGreetings;
    private RadioGroup radioGroupDrinks;

    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;
    private TextView textViewAdditives;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;
    private Spinner spinnerCoffee;
    private Spinner spinnerTea;
    private Button buttonMakeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();

        String userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings);
        String result = String.format(greetings, userName);
        textViewGreetings.setText(result);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;
    }

    private void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        radioGroupDrinks  = findViewById(R.id.radioGroupDrinks);
        radioButtonTea  = findViewById(R.id.radioButtonTea);
        radioButtonCoffee  = findViewById(R.id.radioButtonCoffee);
        textViewAdditives  = findViewById(R.id.textViewAdditives);
        checkBoxSugar  = findViewById(R.id.checkBoxSugar);
        checkBoxMilk  = findViewById(R.id.checkBoxMilk);
        checkBoxLemon  = findViewById(R.id.checkBoxLemon);
        spinnerCoffee  = findViewById(R.id.spinnerCoffee);
        spinnerTea  = findViewById(R.id.spinnerTea);
        buttonMakeOrder  = findViewById(R.id.buttonMakeOrder);
    }
}