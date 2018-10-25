package com.example.dendy.utsbarunemen;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Novel> mData;

    public RecyclerViewAdapter(Context mContext, List<Novel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, final int position){

        holder.tv_novel_title.setText(mData.get(position).getJudul());
//        holder.novel_img_thumbnail.setImageResource(mData.get(position).getThumbnail());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(mContext,NovelActivity.class);
//
//                //lempar data ke gadget activity
//                intent.putExtra("Title",mData.get(position).getTitle());
//                intent.putExtra("Category",mData.get(position).getCategory());
//                intent.putExtra("Description",mData.get(position).getDescription());
//                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
//                //start activity
//                mContext.startActivity(intent);
//            }
//        });
    }

    public int getItemCount(){
        return mData.size();
    }

    public  static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView tv_novel_title;
        TextView tv_penulis;
        TextView tv_penerbit;
        TextView tv_tahunrilis;
        TextView tv_sinopsis;
//        ImageView novel_img_thumbnail;
        CardView cardView;

        public  MyViewHolder(View itemView) {
            super(itemView);
            tv_novel_title = (TextView) itemView.findViewById(R.id.title_novel) ;
//            novel_img_thumbnail = (ImageView) itemView.findViewById(R.id.img_novel) ;
            cardView = (CardView) itemView.findViewById(R.id.card_id) ;
        }
    }
}
