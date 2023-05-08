package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    private String drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();
        setupUserName();
        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonTea.getId()) {
                    onUserChooseTea();
                } else if (checkedId == radioButtonCoffee.getId()) {
                    onUserChooseCoffee();
                }
            }
        });
        radioButtonTea.setChecked(true);
    }

    private void onUserChooseTea() {
        drink = getString(R.string.tea);
        String additivesLabel = getString(R.string.additives, drink);
        textViewAdditives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
    }
    private void onUserChooseCoffee() {
        drink = getString(R.string.coffee);
        String additivesLabel = getString(R.string.additives, drink);
        textViewAdditives.setText(additivesLabel);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;
    }

    private void setupUserName() {
        String userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings, userName);
        textViewGreetings.setText(greetings);
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