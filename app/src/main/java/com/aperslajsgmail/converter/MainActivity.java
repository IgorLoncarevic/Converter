package com.aperslajsgmail.converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Context context = this;

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


        //Toast.makeText(getApplicationContext(), "Click the picture for other converters", Toast.LENGTH_LONG).show();



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

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                //NavUtils.navigateUpFromSameTask(this); //ovo bi trebalo da me vraca sa about na main :z
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }


    //ova dva nacina citanja fajla iz aseta
    /*
    1.
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("about.txt")));
    } catch (IOException e) {
        //
        e.printStackTrace();
    }

    2.
    AssetFileDescriptor descriptor = getAssets().openFd("about.txt");
    FileReader reader = new FileReader(descriptor.getFileDescriptor());
    */





    public void kgOnClick(View v){
        startActivity(new Intent(getApplicationContext(), KilogramsActivity.class));
    }

    public void inchOnClick(View v){
        startActivity(new Intent(getApplicationContext(), InchesActivity.class));
    }

    public void milesOnClick(View v){
        startActivity(new Intent(getApplicationContext(), MilesActivity.class));
    }

    public void timeOnClick(View v){
        startActivity(new Intent(getApplicationContext(), TimeActivity.class));
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
    //ogranici maksimalnu unetu vrednost (npr ako je broj preko 1m nek ga ne povecava) CHECKED
    //aplikacija pukne kad ukucas prvo tacku CHECKED
    //promeni sliku puta, ima pozadinu :z CHECKED
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
    //kod tate ne staje u ekran i fale slike
    //mozda da tekstove promenis sa sp na dp, da se ne bi menjalo u odnosu na tastaturu
    //dodaj stringove, da ne budu hardkodovana imena
    //kad otvoris app pise version 1.0, vidi kako se to menja
    //vidi kako da promenis naslove aktivitija, posto se vide kad otvoris app
    //izbrisi iz ove metode sve sto ne treba i izbrisi slike koje ne koristis
    //promeni sliku aplikacije
    //PROMENI MOJ MEJL
    //dodaj wilks score i slicne zajebancije ali to kao u my profile, ne u brzu konverziju

}
