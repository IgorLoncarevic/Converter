package com.aperslajsgmail.converter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
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
    */

    //2.20462262
    //0.45359237

    private void displayLbs(double number) {
        EditText lbs = (EditText) findViewById(R.id.lbsEdit);
        double vrednost = Math.round(number * 2.20462262 * 100d)/100d;
        lbs.setText("" + vrednost);
    }

    private void displayKg(double number) {
        EditText kg = (EditText) findViewById(R.id.kgEdit);
        double vrednost = Math.round(number * 0.45359237 * 100d) / 100d;
        kg.setText("" + vrednost);

    }

    public void prikazi(View view) {
        double a = 200;

        displayLbs(a);
        displayKg(a);

    }

    //vidi kako da iskoristis vrednost iz prvog EditTekst-a za a
    //Ukloni dugme
    //izbaci negativne brojeve i takva sranja
    //napravi novi tred da izbegnes The application may be doing too much work on its main thread.

}
