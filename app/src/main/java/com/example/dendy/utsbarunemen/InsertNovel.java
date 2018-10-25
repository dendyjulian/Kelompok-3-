package com.example.dendy.utsbarunemen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertNovel extends AppCompatActivity {

    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1, btn2;
    EditText pecel1,pecel2,pecel3,pecel4,pecel5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_novel);

        dbHelper = new MyDataHelper(this);
        pecel1 = (EditText) findViewById(R.id.EditText2);
        pecel2 = (EditText) findViewById(R.id.EditText3);
        pecel3 = (EditText) findViewById(R.id.EditText4);
        pecel4 = (EditText) findViewById(R.id.EditText5);
        pecel5 = (EditText) findViewById(R.id.EditText6);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO buku(judul ,penulis ,penerbit ,tahunrilis ,sinopsis) values('" +
                        pecel1.getText().toString() + "','" +
                        pecel2.getText().toString() + "','" +
                        pecel3.getText().toString() + "','" +
                        pecel4.getText().toString() + "','" +
                        pecel5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil Menambahkan", Toast.LENGTH_LONG).show();
                TampilActivity.layarutama.DataFresh();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
