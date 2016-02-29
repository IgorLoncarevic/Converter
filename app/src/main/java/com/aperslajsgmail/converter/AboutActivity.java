package com.aperslajsgmail.converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class AboutActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //NavUtils.navigateUpFromSameTask(this);
        //ovo bi trebalo da kreira dugme za vracanje na main
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        //Deo koda koji cita tekst iz tekstualnog fajla i ispisuje u TextView
        //public void ispisiProba(View v) {  <- ako hocu da mi sve ovo bude u f-ji,
        // pa da ga pozivam kad treba

        TextView proba = (TextView) findViewById(R.id.textViewAbout);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("about.txt")));
            StringBuilder bla = new StringBuilder(); //ovo je bio StringBuffer, ali izgleda moze i ovako
            String line;

            while ((line = br.readLine()) != null)   {
                bla.append(line + "\n");
            }

            proba.setText(bla.toString());

            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    //overrajdovao sam back metodu. Mislim da je ovo grub nacin (i preskacem koji Activity
    //je tata kom, ali bar radi za sad :z
    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        return;
    }


}
