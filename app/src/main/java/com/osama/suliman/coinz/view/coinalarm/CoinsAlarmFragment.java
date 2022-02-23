package com.osama.suliman.coinz.view.coinalarm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.osama.suliman.coinz.Api.ApiCilent;
import com.osama.suliman.coinz.Api.ApiInterface;
import com.osama.suliman.coinz.model.coin.BaseResponse;
import com.osama.suliman.coinz.model.coin.Coin;
import com.osama.suliman.coinz.model.coin.CurrenciesItem;
import com.osama.suliman.coinz.view.coinprice.CoinsListAdapter;
import com.osama.suliman.coinz.R;
import com.osama.suliman.coinz.viewModel.CoinAlarmViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsAlarmFragment extends Fragment {

    private CoinAlarmViewModel coinAlarmViewModel;
    private Context context ;
    private RecyclerView recyclerView ;
    private CoinsListAdapter coinsListAdapter ;
    private Coin coin ;
    private ArrayList<Coin>coinAlarmList ;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        coinAlarmViewModel = new ViewModelProvider(this).get(CoinAlarmViewModel.class);
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);
    //    recyclerView = root.findViewById(R.id.alarm_recyclerView);

        setupDataOnSpinner();

//        coinAlarmList = new ArrayList<>();
//        coinAlarmList.add(new Coin( " لايت كوين  Litecoin", R.drawable.btc, "10,544.69"));
//        coinAlarmList.add(new Coin( " ريبل  Ripple", R.drawable.btc, "10,544.69"));

//        handleAlarmAdapter(coinAlarmList);
        coinAlarmViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });



        initRecycleFavourites();
      //  RegisterFavourits(6,1);

        return root;

    }


    public void handleAlarmAdapter(List<CurrenciesItem> currenciesItems) {
        recyclerView = root.findViewById(R.id.alarm_recyclerView);
        CoinsListAdapter coinsListAdapter = new CoinsListAdapter(getContext(), currenciesItems, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(coinsListAdapter);
        coinsListAdapter.notifyDataSetChanged();
    }
    private void initRecycleFavourites(){

        recyclerView = root.findViewById(R.id.alarm_recyclerView);
        coinsListAdapter = new CoinsListAdapter(getContext(), new ArrayList<>(), 2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(coinsListAdapter);

    }



    // this method for get data on drop down text view Material design
    public void setupDataOnSpinner() {
        AutoCompleteTextView autoCompleteTextView = root.findViewById(R.id.autoComplete);
        String[] coins = getResources().getStringArray(R.array.coins);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), R.layout.drop_down_item, coins);
        autoCompleteTextView.setText(coins[0]);
        autoCompleteTextView.setAdapter(arrayAdapter);

        AutoCompleteTextView autoCompleteLogicOperation = root.findViewById(R.id.autoComplete2);
        String [] logic = getResources().getStringArray(R.array.logic);
        ArrayAdapter logicArrayAdapter = new ArrayAdapter(requireContext() , R.layout.drop_down_item , logic);
        autoCompleteLogicOperation.setText(logic[0]);
        autoCompleteLogicOperation.setAdapter(logicArrayAdapter);
    }

//    private void RegisterFavourits(Integer i_page_count , Integer i_page_number){
//        ApiInterface apiInterface= ApiCilent.getClient().create(ApiInterface.class);
//        Call<BaseResponse> addfavouritscall = apiInterface.FavouritsList(i_page_count,i_page_number);
//        addfavouritscall.enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//                coinsListAdapter.setDataCondition(response.body().getCondition());
//                coinsListAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}