package com.example.dendy.utsbarunemen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NovelActivity extends AppCompatActivity {

    protected Cursor cursor;
    MyDataHelper dbHelper;
    private TextView tvtitle,tvdescription,tvpenerbit, tvpenulis, tvrilis;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);

        dbHelper = new MyDataHelper(this);
        tvtitle = (TextView) findViewById(R.id.txtjudul);
        tvpenerbit = (TextView) findViewById(R.id.txtpenerbit);
        tvpenulis = (TextView) findViewById(R.id.txtpenulis);
        tvrilis = (TextView) findViewById(R.id.txtrilis);
        tvdescription = (TextView) findViewById(R.id.txtsinop);
        img = (ImageView) findViewById(R.id.nothumbnail);

        //Terima Data
//        Intent intent = getIntent();
//
//        String Judul = intent.getExtras().getString("Judul");
//        String Penerbit = intent.getExtras().getString("Penerbit");
//        String Penulis = intent.getExtras().getString("Penulis");
//        String Sinopsis = intent.getExtras().getString("Sinopsis");
//        String Tahunrilis = intent.getExtras().getString("Tahunrilis");
//        int image = intent.getExtras().getInt("Thumbnail");
//
//        //atur values
//
//        tvtitle.setText(Judul);
//        tvpenerbit.setText(Penerbit);
//        tvpenulis.setText(Penulis);
//        tvdescription.setText(Sinopsis);
//        tvrilis.setText(Tahunrilis);
//        img.setImageResource(image);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM buku WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'",null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            tvtitle.setText(cursor.getString(1));
            tvpenulis.setText(cursor.getString(3));
            tvpenerbit.setText(cursor.getString(2));
            tvrilis.setText(cursor.getString(4));
            tvdescription.setText(cursor.getString(5));
//            img.setImageResource(cursor.getInt(6));
        }
    }
}