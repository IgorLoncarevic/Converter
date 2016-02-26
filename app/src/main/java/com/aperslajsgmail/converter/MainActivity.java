package com.aperslajsgmail.converter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

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
                if(/*u.getText().toString() == null ||*/ u.getText().toString().trim().equals("")) {
                    lbs.setText("");
                    kg.setText("");
                }else if(u.getText().toString().length() > 6){
                    //double b = 1000000;
                    //displayLbs(b);
                    //displayKg(b);

                    toast.setText("Number is too long!");
                    toast.show();

                    lbs.setText("error");
                    kg.setText("error");

                }else{
                    try {
                        double b = Double.parseDouble(u.getText().toString());
                        displayLbs(b);
                        displayKg(b);
                    }
                    catch (NumberFormatException e){
                        //Toast.makeText(MainActivity.this,"Please Enter a valid double value",Toast.LENGTH_SHORT).show();
                    }


                    //if(u.getText().charAt(0) == '.'){
                        //b = Double.parseDouble("0" + u.getText().toString());
                        //KOPIRANO S NETA: str= str.replaceAll("\\.", "");
                        //b = Double.parseDouble(u.getText().toString().replace("\\.","0."));
                    //}

                }

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

    /*
    //funkcija koja je sluzila za dugme kog vise nema

    public void prikazi(View view) {
        EditText uneti = (EditText) findViewById(R.id.unetiEdit);

        double b = Double.parseDouble(uneti.getText().toString());

        displayLbs(b);
        displayKg(b);
    }
    */


    /*
    private static EditText uneti;

    TopSectionListener activityComander;

    public interface TopSectionListener{
        public void createMeme(String a);
    }

    public void buttonClicked(View view){
        activityComander.createMeme(uneti.getText().toString());
    }
    */

    //napravi da radi na unos   CHECKED
    //napravi exception ili sta vec ako se ne unese vrednost CHECKED
    //Ukloni dugme CHECKED
    //izbaci negativne brojeve i takva sranja VEC JE OVAKVO
    //ogranici koliko uneti broj moze da bude dugacak CHECKED
    //napravi novi tred da izbegnes The application may be doing too much work on its main thread. NE TREBA?
    //Nista sto menja interfejs se ne stavlja u tred!!! ZBOG OVOGA
    //dodaj slicicu ZA VELICINU TASTATURE
    //promeni double u float?
    //vidi kako da smanjis velicinu aplikacije, vec ima preko 6mb. Jedno od resenja: promeniti verziju androida na kasniju.
    //http://tools.android.com/tech-docs/new-build-system/resource-shrinking
    //vidi kako da namestis ikonicu
    //procenat ekrana koji zauzima tastatura
    //kreni da zapisujes sve ovo sto trazis u word file sa linkovima i sve
    //napravi da se menjaju ekrani u settings, da ima jedan cm u inci itd
    //ako konkretizujes importe, mozda se smanji velicina aplikacije
    //ogranici maksimalnu unetu vrednost (npr ako je broj preko 1m nek ga ne povecava)
    //ali vidi da to ne proverava svaki put
    //kod tate ne staje u ekran i fale slike
    //aplikacija pukne kad ukucas prvo tacku


}
