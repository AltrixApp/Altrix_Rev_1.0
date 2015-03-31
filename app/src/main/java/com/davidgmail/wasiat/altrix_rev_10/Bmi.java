package com.davidgmail.wasiat.altrix_rev_10;

/**
 * Created by wasiatdavid on 3/30/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;

public class Bmi  extends Activity {

    private EditText tinggi;
    private EditText berat;
    private Button hitung;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        tinggi = (EditText) findViewById(R.id.tinggi);
        berat = (EditText) findViewById(R.id.berat);
        hitung = (Button) findViewById(R.id.hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tinggiBadan = Double.parseDouble(tinggi.getText().toString());
                double beratbadan = Double.parseDouble(berat.getText().toString());
                double hasil = beratbadan/(tinggiBadan*tinggiBadan);
                TextView hasilView = (TextView) findViewById(R.id.hasil);

                if(hasil < 18.5)
                {
                    hasilView.setText("waduh berat badan kamu masuk kedalam kategori underweight, kamu perlu meningkatkan olahraga dan makan makanan padat kalori dari jenis complex karbohidrat :)");
                }
                else if((hasil >= 18.5) && (hasil < 23))
                {
                    hasilView.setText("berat badan kamu ideal, sangat bagus :)");
                }
                else if((hasil>=23) && ( hasil < 25))
                {
                    hasilView.setText("berat badan kamu ideal, tetapi kamu sudah masuk kategori warning. Jaga pola makan dan perbanyak olahraga ya :)");
                }
                else if((hasil >= 25) && (hasil < 30))
                {
                    hasilView.setText("kondisi berat badan kamu sudah memasuki batas obesitas, mulai program diet ya :)");
                }
                else
                {
                    hasilView.setText("waduh kamu udah masuk kategori obesitas nih. ayo segera mulai program diet atau kamu akan mudah terserang penyakit :)");
                }
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

}
