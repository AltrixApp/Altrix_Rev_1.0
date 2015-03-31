package com.davidgmail.wasiat.altrix_rev_10;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View daftarInfoPenyakit = findViewById(R.id.infoPenyakitButton);
        daftarInfoPenyakit.setOnClickListener((OnClickListener) this);

        View daftarArtikel = findViewById(R.id.artikelButton);
        daftarArtikel.setOnClickListener((OnClickListener) this);

        View bmi = findViewById(R.id.bmiButton);
        bmi.setOnClickListener((OnClickListener) this);

        View rumahSakit = findViewById(R.id.rumahSakitButton);
        rumahSakit.setOnClickListener((OnClickListener) this);
/*
        ImageButton infoPenyakit = (ImageButton) findViewById(R.id.infoPenyakitButton);
        infoPenyakit.setOnClickListener(new OnClickListener(){
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), InfoPenyakit.class);
                startActivity(i);
            }
        });

        View berita = findViewById(R.id.beritaButton);
        berita.setOnClickListener((OnClickListener) this);

        View rumahSakit = findViewById(R.id.rumahSakitButton);
        rumahSakit.setOnClickListener((OnClickListener) this);

        View alarm = findViewById(R.id.alarmButton);
        alarm.setOnClickListener((OnClickListener) this);

        View aboutUs = findViewById(R.id.aboutUsButton);
        aboutUs.setOnClickListener((OnClickListener) this);

        View bmi= findViewById(R.id.bmiButton);
        bmi.setOnClickListener((OnClickListener) this);
*/


    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.infoPenyakitButton:
                Intent fiturInfoPenyakit= new Intent(this, DaftarPenyakit.class);
                startActivity(fiturInfoPenyakit);
                break;

            case R.id.artikelButton:
                Intent fiturArtikel= new Intent(this, DaftarArtikel.class);
                startActivity(fiturArtikel);
                break;

            case R.id.bmiButton:
                Intent fiturBmi= new Intent(this, Bmi.class);
                startActivity(fiturBmi);

            case R.id.rumahSakitButton:
                Intent fiturRS=new Intent(this, DaftarRS.class);
                startActivity(fiturRS);


/*
            case R.id.beritaButton:
                Intent fiturInfoPenyakit= new Intent(this, InfoPenyakit.class);
                startActivity(fiturInfoPenyakit);

            case R.id.rumahSakitButton:
                Intent fiturInfoPenyakit= new Intent(this, InfoPenyakit.class);
                startActivity(fiturInfoPenyakit);

            case R.id.alarmButton:
                Intent fiturInfoPenyakit= new Intent(this, InfoPenyakit.class);
                startActivity(fiturInfoPenyakit);

            case R.id.aboutUsButton:
                Intent fiturInfoPenyakit= new Intent(this, InfoPenyakit.class);
                startActivity(fiturInfoPenyakit);


*/

        }

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
}
