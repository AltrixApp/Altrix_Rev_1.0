package com.davidgmail.wasiat.altrix_rev_10;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

/**
 * Created by wasiatdavid on 3/25/15.
 */
public class InfoPenyakit extends Activity{
    TextView title, content;
    Button close;
    private SQLiteDatabase db = null;
    private Cursor altrixCursor = null;
    private DBAltrix db_altrix_helper;
    private String nama;
    private String query;
    private String isiQuery;
   // AdapterView.OnItemClickListener isi;
 //   Intent tampilkanIsi;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_penyakit);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        close = (Button) findViewById(R.id.close);

        Intent intent=getIntent();
        nama = intent.getStringExtra("nama");

        db_altrix_helper = new DBAltrix(this);
        try {
            db_altrix_helper.openDataBase();
            db = db_altrix_helper.getReadableDatabase();
        }catch(SQLException sqle){
            throw sqle;
        }
        query= "SELECT Isi FROM INFO_PENYAKIT where Nama LIKE '%"+ nama +"%'";
        altrixCursor= db.rawQuery(query,null);

//        altrixCursor= db.rawQuery(query,null);
        title.setText(nama);
        if(altrixCursor!= null && altrixCursor.moveToFirst())
        {
            isiQuery = altrixCursor.getString(0);
        }
       // String isi = altrixCursor.getString(1);
        content.setText(isiQuery);
        altrixCursor.close();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                InfoPenyakit.this.finish();
            }
        });

    }
    @Override
    public void onStart(){
        db_altrix_helper.openDataBase();
        super.onStart();
      //  content.setText(query..toString());

    }
    /*
    private void getIntentParameter() {

        Uri data = this.getIntent().getData();
        if (data!=null) {
            text = data.getQueryParameter("text");
        } else {
            DICT = this.getIntent().getExtras().getInt("DICT", 1);
            text = this.getIntent().getExtras().getString("TEXT");
        }
    }
    */


}
