package com.example.dendy.utsbarunemen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.ArrayList;

public class TampilActivity extends AppCompatActivity {

    public static TampilActivity layarutama;

    public RecyclerView mRecycleView;
    MyDataHelper dataHelper;
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView.Adapter mAdapter;
    List<Novel> lstNovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        dataHelper = new MyDataHelper(this);

        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(TampilActivity.this, InsertNovel.class);
                startActivity(myintent);
            }
        });
        layarutama = this;
        novelList();

        lstNovel = new ArrayList<>();

        mRecycleView = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstNovel);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycleView.setAdapter(myAdapter);
//        myrv.setAdapter(myAdapter);

        DataFresh();
        mRecycleView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecycleView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, final int position) {
                final CharSequence[] dialogitem = {"Lihat Novel", "Update Novel", "Hapus Novel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(TampilActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch(item){
                            case 0 :
                                Intent intent0 = new Intent(getApplicationContext(), NovelActivity.class);
                                intent0.putExtra("judul", lstNovel.get(position).getJudul());
                                startActivity(intent0);
                                break;
                            case 1 :
                                Intent intent1 = new Intent(getApplicationContext(), UpdateNovel.class);
                                intent1.putExtra("judul", lstNovel.get(position).getJudul());
                                startActivity(intent1);
                                break;
                            case 2 :
                                SQLiteDatabase db = dataHelper.getWritableDatabase();
                                db.execSQL("DELETE FROM buku WHERE id = '" + lstNovel.get(position).getID() + "'");
                                DataFresh();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
        }));
    }

    public List<Novel> novelList() {
        SQLiteDatabase db = dataHelper.getReadableDatabase();
        List<Novel> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM buku", null);

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                Novel n = new Novel(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5));
//                        cursor.getInt(6));
                list.add(n);
            }
        }
        return list;
    }

    public void DataFresh(){
        this.lstNovel = new ArrayList<>();
        lstNovel.addAll(novelList());
        mRecycleView = findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstNovel);
        mRecycleView.setAdapter(myAdapter);
    }

    public void button_onClick(View view) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(this.getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

}

