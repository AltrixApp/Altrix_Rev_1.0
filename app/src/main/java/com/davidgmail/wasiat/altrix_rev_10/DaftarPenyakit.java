package com.davidgmail.wasiat.altrix_rev_10;

/**
 * Created by wasiatdavid on 3/26/15.
 */
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

import android.app.ListActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.widget.EditText;


public class DaftarPenyakit extends ListActivity{
  //  ListView result;
    ArrayList<String> list_result = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView result;
    private SQLiteDatabase db = null;
    private Cursor altrixCursor = null;
    private DBAltrix db_altrix_helper;
    AdapterView.OnItemClickListener isi;
//    Intent tampilkanIsi;
 //   private int DICT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_penyakit);


        /* Open Database File */
        db_altrix_helper = new DBAltrix(this);
        try {
            db_altrix_helper.openDataBase();
            db = db_altrix_helper.getReadableDatabase();
        }catch(SQLException sqle){
            throw sqle;
        }
        String query;
        query = "SELECT Nama FROM INFO_PENYAKIT";

        altrixCursor= db.rawQuery(query,null);

        altrixCursor.moveToFirst();
        while(!altrixCursor.isAfterLast())
        {
            list_result.add(altrixCursor.getString(0));
            altrixCursor.moveToNext();
        }
        altrixCursor.close();

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_result);
        setListAdapter(adapter);

        result= (ListView) findViewById(android.R.id.list);
        isi= new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = result.getItemAtPosition(position).toString();
                Intent intent = new Intent(getApplicationContext(),InfoPenyakit.class);
                intent.putExtra("nama",nama);
                startActivity(intent);

            }
        };

        result.setOnItemClickListener(isi);
     //   result.setFocusable(false);
       // this.initUI();

    }
/*
    protected void translate(String text) {
        tampilkanIsi = new Intent().setClass(this, InfoPenyakit.class);
        tampilkanIsi.putExtra("TEXT",text);
        startActivity(tampilkanIsi);
    }
*/
    @Override
    public void onStart(){
        db_altrix_helper.openDataBase();
        super.onStart();
      //  getSetting();
    }

    @Override
    public void onResume(){
        super.onResume();
      //  getSetting();
    }

    protected void initUI()
    {
        /*
        DICT = this.getIntent().getExtras().getInt("DICT", 1);
        result = (ListView) findViewById(android.R.id.list);
         /* Create List Adapter */



        /*
        if (altrixCursor.moveToFirst()) {
            list_result.add(altrixCursor.getString(0));
            while(!altrixCursor.isLast()) {
                altrixCursor.moveToNext();
                list_result.add(altrixCursor.getString(0));
            }
        } else {
            //list_result.add(not_found);
        }

           Defines List-Item Click Listener
        translator = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = result.getItemAtPosition(position).toString();
                translate(text);
            }
        };
        result.setOnItemClickListener(translator);
        result.setFocusable(false);
        */
    }
/*
    protected void translate(String text) {
        translate_dialog = new Intent().setClass(this, InfoPenyakit.class);
        translate_dialog.putExtra("DICT", DICT);
        translate_dialog.putExtra("TEXT", text);
        startActivity(translate_dialog);
    }
*/
}


  /*
        list1 = (ListView)findViewById(R.id.listPenyakit);
        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, daftar));
        list1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    if (position == 0){
                        i = new Intent(DaftarPenyakit.this, InfoPenyakit.class);}
                    else if(position == 1){
                        i = new Intent(DaftarPenyakit.this, InfoPenyakit.class);}
                    else{}
                    startActivity(i);
            }

        });}
    /*
    public void onBackPressed(){
        finish();
        System.exit(0);
    }
    */
