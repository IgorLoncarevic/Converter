package com.aperslajsgmail.converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KilogramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilograms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Toast
        //Toast.makeText(getApplicationContext(), "Number is too big.", Toast.LENGTH_SHORT).show();
        Context contextToast = getApplicationContext();
        CharSequence txtToast = "Number is to big!";
        int durationToast = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(contextToast, txtToast, durationToast);
        toast.setGravity(Gravity.CENTER, 0, 0);


        //ovo van klase stavi ljaljane
        final EditText u = (EditText) findViewById(R.id.unetiEdit);
        final EditText lbs = (EditText) findViewById(R.id.lbsEdit);
        final EditText kg = (EditText) findViewById(R.id.kgEdit);

        u.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {
                // set new value now
                //l.setText(u.getText().toString()); //ovo bi prepisivalo samo tekst

                //ovaj if mi sluzi da kad obrisem tekst, ne pukne aplikacija
                if (/*u.getText().toString() == null ||*/ u.getText().toString().trim().equals("")) {
                    lbs.setText("");
                    kg.setText("");
                } else if (u.getText().toString().length() > 6) {
                    //double b = 1000000;
                    //displayLbs(b);
                    //displayKg(b);

                    toast.setText("Number is too long!");
                    toast.show();

                    lbs.setText("error");
                    kg.setText("error");

                } else {
                    try {
                        double b = Double.parseDouble(u.getText().toString());
                        displayLbs(b);
                        displayKg(b);
                    } catch (NumberFormatException e) {
                    }

                }
            }
        });

    }

    //2.20462262
    //0.45359237

    private void displayLbs(double number) {
        EditText lbs = (EditText) findViewById(R.id.lbsEdit);
        double racun = number * 2.20462262;
        double vrednost;
        if(number > 1) {
            vrednost = Math.round(racun * 100d) / 100d;
        }else if(number >= 0){
            vrednost = Math.round(racun * 100000d) / 100000d;
        }else{
            lbs.setText("error");
            return;
        }

        lbs.setText("" + vrednost);
    }

    private void displayKg(double number) {
        EditText kg = (EditText) findViewById(R.id.kgEdit);
        double racun = number * 0.45359237;
        double vrednost;
        if(number > 1) {
            vrednost = Math.round(racun* 100d)/100d;
        }else if(number >= 0){
            vrednost = Math.round(racun * 100000d) / 100000d;
        }else{
            kg.setText("error");
            return;
        }

        kg.setText("" + vrednost);
    }

    public void slikaOnClick(View v){
        startActivity(new Intent(getApplicationContext(), InchesActivity.class));
    }


    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        return;
    }


}
