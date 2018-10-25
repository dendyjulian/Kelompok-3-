package com.example.dendy.utsbarunemen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNovel extends AppCompatActivity {

    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1, btn2;
    EditText kamu1, kamu3, kamu4, kamu5, kamu6;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_novel);

        dbHelper = new MyDataHelper(this);
        kamu1 = (EditText) findViewById(R.id.EditText2);
        kamu3 = (EditText) findViewById(R.id.EditText3);
        kamu4 = (EditText) findViewById(R.id.EditText4);
        kamu5 = (EditText) findViewById(R.id.EditText5);
        kamu6 = (EditText) findViewById(R.id.EditText6);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM buku WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'",null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            id =cursor.getString(0);
            kamu1.setText(cursor.getString(1));
            kamu3.setText(cursor.getString(2));
            kamu4.setText(cursor.getString(3));
            kamu5.setText(cursor.getString(4));
            kamu6.setText(cursor.getString(5));
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE buku SET judul = '"+ kamu1.getText().toString()+"', " +
                        "penulis = '" + kamu3.getText().toString() + "', " +
                        "penerbit = '" + kamu4.getText().toString() + "', " +
                        "tahunrilis = '" + kamu5.getText().toString() + "', " +
                        "sinopsis = '" + kamu6.getText().toString() + "' WHERE id ="+Integer.parseInt(id)+"");
                Toast.makeText(getApplicationContext(), "Berhasil Update", Toast.LENGTH_LONG).show();
                TampilActivity.layarutama.DataFresh();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
