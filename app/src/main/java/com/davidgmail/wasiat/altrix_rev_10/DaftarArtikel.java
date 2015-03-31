package com.davidgmail.wasiat.altrix_rev_10;

/**
 * Created by wasiatdavid on 3/30/15.
 */

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import java.util.ArrayList;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DaftarArtikel extends ListActivity {
    ArrayList<String> list_result = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView result;
    private SQLiteDatabase db = null;
    private Cursor altrixCursor = null;
    private DBAltrix db_altrix_helper;
    AdapterView.OnItemClickListener isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_artikel);


        /* Open Database File */
        db_altrix_helper = new DBAltrix(this);
        try {
            db_altrix_helper.openDataBase();
            db = db_altrix_helper.getReadableDatabase();
        }catch(SQLException sqle){
            throw sqle;
        }
        String query;
        query = "SELECT Nama FROM ARTIKEL_KESEHATAN";

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
                Intent intent = new Intent(getApplicationContext(),Artikel.class);
                intent.putExtra("nama",nama);
                startActivity(intent);

            }
        };

        result.setOnItemClickListener(isi);
    }

    @Override
    public void onStart(){
        db_altrix_helper.openDataBase();
        super.onStart();
        //  getSetting();
    }

}
