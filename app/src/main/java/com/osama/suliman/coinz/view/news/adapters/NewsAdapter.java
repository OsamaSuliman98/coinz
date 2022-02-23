package com.osama.suliman.coinz.view.news.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.facebook.drawee.view.SimpleDraweeView;
import com.osama.suliman.coinz.model.coin.News;
import com.osama.suliman.coinz.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private NewsAdapterCallback newsAdapterCallback ;
    private List<News> mItems;



    public void setNewsAdapterCallback(NewsAdapterCallback newsAdapterCallback) {
        this.newsAdapterCallback = newsAdapterCallback;
    }
    public void setData(List<News> news){this.mItems= news;}

    public NewsAdapter(List<News> items) {
        mItems = items;
    }


    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new NewsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.bind(mItems.get(position));
        holder.itemView.setOnClickListener(view -> {
            if (newsAdapterCallback!=null){

                //send data to another activity
                Intent intent = new Intent();
                intent.putExtra("new",mItems.get(position).getPkIId());
                //intent.putExtra("new", mItems.get(position));

               //for api when have id
                intent.putExtra("id", mItems.get(position).getSDescription());


            newsAdapterCallback.onClickItem(position, mItems.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView newImage ;
        private TextView newTitle ;
        private TextView newDate ;
        private SimpleDraweeView my_image_view;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            newImage = itemView.findViewById(R.id.new_imageView);
            my_image_view = itemView.findViewById(R.id.my_image_view);
            newTitle = itemView.findViewById(R.id.new_title_txt);
            newDate = itemView.findViewById(R.id.new_date_txt);


        }


        public void bind(News item) {
            my_image_view.setImageURI(item.getSImage());
            newTitle.setText(String.valueOf(item.getSTitle()));
            newDate.setText(String.valueOf(item.getSDescription()));
        }
    }

}
