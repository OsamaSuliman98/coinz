package com.osama.suliman.coinz.view.coinprice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.osama.suliman.coinz.R;
import com.osama.suliman.coinz.model.coin.Coin;
import com.osama.suliman.coinz.model.coin.Condition;
import com.osama.suliman.coinz.model.coin.CurrenciesItem;

import java.util.ArrayList;
import java.util.List;

public class CoinsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private int isGRID = 0;
    private List<CurrenciesItem> mItems = new ArrayList<>();
    private List<Condition> mmItems= new ArrayList<>();
    private Context mContext;
    int row;


    public CoinsListAdapter(Context context, List<CurrenciesItem> items, int isGRID) {
        this.isGRID = isGRID;
        this.mItems = items;
        this.mContext = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (isGRID == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.coin_card, parent, false);
//            Toast.makeText(mContext, "grid Item", Toast.LENGTH_SHORT).show();
            return new GridIconViewHolder(view);
        } else if (isGRID == 1) {
            view = LayoutInflater.from(mContext).inflate(R.layout.coin_card_linear, parent, false);
//            Toast.makeText(mContext, "linear item", Toast.LENGTH_SHORT).show();
            return new LinearIconViewHolder(view);
        } else if (isGRID == 2) {
            view = LayoutInflater.from(mContext).inflate(R.layout.alarm_card, parent, false);
            return new AlarmCardViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (isGRID == 0) {
            if (holder instanceof GridIconViewHolder) {
                GridIconViewHolder gridIconViewHolder = (GridIconViewHolder) holder;
                gridIconViewHolder.bind((Condition) mmItems.get(position));

            }
        } else if (isGRID == 1) {
            if (holder instanceof LinearIconViewHolder) {
                LinearIconViewHolder linearIconViewHolder = (LinearIconViewHolder) holder;
                linearIconViewHolder.bind((CurrenciesItem) mItems.get(position));

            }
//
        } else if (isGRID == 2) {
            if (holder instanceof AlarmCardViewHolder) {
                AlarmCardViewHolder alarmCardViewHolder = (AlarmCardViewHolder) holder;
                alarmCardViewHolder.bind((CurrenciesItem) mItems.get(position));
            }

        }
    }

    @Override
    public int getItemCount() {
        return mItems.isEmpty() ? mmItems.size() : mItems.size();
    }

    public void setDataCondition(List<Condition> conditions) {
        this.mmItems = conditions;
    }

    public void setData(List<CurrenciesItem> currencies) {
        this.mItems = currencies;
    }

    public class GridIconViewHolder extends RecyclerView.ViewHolder {
        private ImageView coinImageView;
        private TextView coinNameTextView;
        private SimpleDraweeView my_image_view;
        private ConstraintLayout constraintLayout;
        private TextView coinPriceTextView;

        public GridIconViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.card_container);
            coinImageView = itemView.findViewById(R.id.coinImageView);
            my_image_view = itemView.findViewById(R.id.my_image_view);
            coinNameTextView = itemView.findViewById(R.id.coinNameTextView);
            coinPriceTextView = itemView.findViewById(R.id.coinPriceTextView);
        }

        public void bind(Condition item) {
            my_image_view.setImageURI(item.getsIcon());
            coinNameTextView.setText(String.valueOf(item.getsName()));
            coinPriceTextView.setText(String.valueOf(item.getdValue()));
        }
    }

    public class LinearIconViewHolder extends RecyclerView.ViewHolder {

        private TextView idTextView;
        private TextView coinNameTextView;
        private SimpleDraweeView coinImageView;
        private TextView coinPriceTextView;
        private AppCompatTextView coinTradeTxt;
        private ImageView imageView;

        public LinearIconViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.coinId);
            coinImageView = itemView.findViewById(R.id.coin_imageView);
            coinNameTextView = itemView.findViewById(R.id.coin_name_txt);
            coinPriceTextView = itemView.findViewById(R.id.coin_price_txt);
            coinTradeTxt = itemView.findViewById(R.id.coin_trade_txt);
            imageView = itemView.findViewById(R.id.arrow);
        }

        public void bind(CurrenciesItem item) {
            idTextView.setText(String.valueOf(item.getPkIId()));
            coinImageView.setImageURI(item.getSIcon());
            coinNameTextView.setText(String.valueOf(item.getSName()));
            coinPriceTextView.setText(String.valueOf(item.getDValue()));
            coinTradeTxt.setText(String.valueOf(item.getDTrading()));

            if (mItems.get(3) == item) {
                coinTradeTxt.setTextColor(mContext.getResources().getColor(R.color.red));
                imageView.setImageResource(R.drawable.arrow_down);
            }

        }

    }

    public class AlarmCardViewHolder extends RecyclerView.ViewHolder {

        private ImageView coinImageView;
        private TextView coinNameTextView;
        private TextView coinPriceTextView;
        private TextView logicOperation;
        private TextView textView10;
        private SimpleDraweeView my_image_view;

        public AlarmCardViewHolder(@NonNull View itemView) {
            super(itemView);
            my_image_view = itemView.findViewById(R.id.my_image_view);
            coinNameTextView = itemView.findViewById(R.id.alarm_coin_name);
            coinPriceTextView = itemView.findViewById(R.id.alarm_coin_price);
            logicOperation = itemView.findViewById(R.id.textView8);
            textView10 = itemView.findViewById(R.id.textView10);
        }

        public void bind(CurrenciesItem currenciesItem) {
            my_image_view.setImageURI(currenciesItem.getSIcon());
            coinNameTextView.setText(String.valueOf(currenciesItem.getSName()));
            coinPriceTextView.setText(String.valueOf(currenciesItem.getDValue()));


            if (mItems.get(1) == currenciesItem) {
                coinPriceTextView.setTextColor(mContext.getResources().getColor(R.color.red));
                logicOperation.setText(R.string.smaller_than);
                logicOperation.setTextColor(mContext.getResources().getColor(R.color.red));
                textView10.setTextColor(mContext.getResources().getColor(R.color.red));


            }
        }
    }

}
