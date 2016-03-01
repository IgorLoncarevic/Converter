package com.aperslajsgmail.converter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miles);

        Context contextToast = getApplicationContext();
        CharSequence txtToast = "Number is to big!";
        int durationToast = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(contextToast, txtToast, durationToast);
        toast.setGravity(Gravity.CENTER, 0, 0);



        //ovo van klase stavi ljaljane
        final EditText u2 = (EditText) findViewById(R.id.unetiEdit);
        final EditText inch = (EditText) findViewById(R.id.milesEdit);
        final EditText cm = (EditText) findViewById(R.id.kmEdit);

        u2.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {
                if (/*u.getText().toString() == null ||*/ u2.getText().toString().trim().equals("")) {
                    inch.setText("");
                    cm.setText("");
                } else if (u2.getText().toString().length() > 6) {
                    toast.setText("Number is too long!");
                    toast.show();

                    inch.setText("error");
                    cm.setText("error");
                } else {
                    try {
                        double b = Double.parseDouble(u2.getText().toString());
                        displayMiles(b);
                        displayKm(b);
                    } catch (NumberFormatException e) {

                    }

                }

            }

        });

    }

    private void displayMiles(double number) {
        EditText inch = (EditText) findViewById(R.id.milesEdit);
        double racun = number * 0.621371192;
        double vrednost;
        if(number > 1) {
            vrednost = Math.round(racun * 1000d) / 1000d;
        }else if(number >= 0){
            vrednost = Math.round(racun * 100000d) / 100000d;
        }else{
            inch.setText("error");
            return;
        }

        inch.setText("" + vrednost);
    }

    private void displayKm(double number) {
        EditText cm = (EditText) findViewById(R.id.kmEdit);
        double racun = number * 1.609344;
        double vrednost;
        if(number > 1) {
            vrednost = Math.round(racun* 1000d)/1000d;
        }else if(number >= 0){
            vrednost = Math.round(racun * 100000d) / 100000d;
        }else{
            cm.setText("error");
            return;
        }

        cm.setText("" + vrednost);
    }

    public void slikaOnClick(View v){
        startActivity(new Intent(getApplicationContext(), TimeActivity.class));
    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        return;
    }




}
