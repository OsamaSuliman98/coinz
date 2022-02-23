package com.osama.suliman.coinz.view.coinprice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.osama.suliman.coinz.Api.ApiCilent;
import com.osama.suliman.coinz.Api.ApiInterface;

import com.osama.suliman.coinz.model.coin.BaseResponse;
import com.osama.suliman.coinz.model.coin.Coin;
import com.osama.suliman.coinz.R;
import com.osama.suliman.coinz.model.coin.CurrenciesItem;
import com.osama.suliman.coinz.viewModel.CoinPriceViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsPricesFragment extends Fragment {

    private CoinPriceViewModel coinPriceViewModel;
    private RecyclerView gridRecyclerView;
    private RecyclerView linearRecyclerView;
    private CoinsListAdapter coinsListAdapter;
    private CoinsListAdapter coins2ListAdapter;
    private ArrayList<Coin> gridCoins;
    private List<CurrenciesItem> currenciesItems;
    private ArrayList<Coin> linearCoins;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        coinPriceViewModel =
                new ViewModelProvider(this).get(CoinPriceViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


//        coinPriceViewModel.mText.observe(getViewLifecycleOwner(), s -> {
//            s
//        });

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//            }
//        });
//        return root;


//        gridCoins = new ArrayList<CurrenciesItem>();
//        gridCoins.add(new Coin("bitcoin", R.drawable.btc, "10,544.69" , R.drawable.second_rectangle_splash));
//        gridCoins.add(new Coin("bitcoin", R.drawable.btc, "10,544.69" , R.drawable.first_rectangle_splash));
//        gridCoins.add(new Coin("bitcoin", R.drawable.btc, "10,544.69",R.drawable.fourth_rectangle_splash));
//        gridCoins.add(new Coin("bitcoin", R.drawable.btc, "10,544.69",R.drawable.third_rectangle_splash));


//        linearCoins = new ArrayList<>();
//        linearCoins.add(new Coin(1, " لايت كوين  Litecoin", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(2, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(3, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(4, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(5, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(6, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));
//        linearCoins.add(new Coin(7, " ريبل  Ripple", R.drawable.btc, "10,544.69", "5.50%"));

//        handleGridAdapter(gridCoins);
//        handleLinearAdapter(linearCoins);

//



//     linearRecyclerView.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//             Bundle result =new Bundle();
//             result.putBundle("CurrenciesItems",currenciesItems);
////             Intent intent = new Intent(getContext(), AddCoins.class);
////             intent.putExtra("KEY",request_code);
//         }
//     });

        initRecycleGrid();
        registerCurrencies(1, 6);
        initRecycleLinear();
        registerList();


        return root;
    }


//    public void handleGridAdapter(List<CurrenciesItem> currenciesItems) {
//
//        gridRecyclerView = root.findViewById(R.id.recyclerViewGrid);
//        CoinsListAdapter coinsListAdapter = new CoinsListAdapter(getContext(), currenciesItems, 0);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
//        gridRecyclerView.setLayoutManager(gridLayoutManager);
//        gridRecyclerView.setAdapter(coinsListAdapter);
//        coinsListAdapter.notifyDataSetChanged();
//    }

//    public void handleLinearAdapter(List<CurrenciesItem> currenciesItems) {
//        linearRecyclerView = root.findViewById(R.id.linear_recyclerView);
//        CoinsListAdapter coinsListAdapter1 = new CoinsListAdapter(getContext(), currenciesItems, 1);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        linearRecyclerView.setLayoutManager(linearLayoutManager);
//        linearRecyclerView.setAdapter(coinsListAdapter1);
//        coinsListAdapter1.notifyDataSetChanged();
//    }

    private void initRecycleGrid() {

        gridRecyclerView = root.findViewById(R.id.recyclerViewGrid);
        coins2ListAdapter = new CoinsListAdapter(getContext(), new ArrayList<>(), 0);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        gridRecyclerView.setAdapter(coins2ListAdapter);

    }

    private void initRecycleLinear() {

        linearRecyclerView = root.findViewById(R.id.linear_recyclerView);
        coinsListAdapter = new CoinsListAdapter(getContext(), new ArrayList<>(), 1);
        linearRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        linearRecyclerView.setAdapter(coinsListAdapter);


    }


    private void registerCurrencies(Integer i_page_number, Integer i_page_count) {
        ApiInterface apiInterface = ApiCilent.getClient().create(ApiInterface.class);
        Call<BaseResponse> currenciesItemCall = apiInterface.baseResponseCurrencies(i_page_count, i_page_number);
        currenciesItemCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                coins2ListAdapter.setData(response.body().getCurrencies());
                coins2ListAdapter.notifyDataSetChanged();
                // Log.d("DDDDDD", response.body().toString());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void registerList() {
        Log.d("test API", "start request");
        ApiInterface apiInterface = ApiCilent.getClient().create(ApiInterface.class);
        Call<BaseResponse> currenciesItemCall = apiInterface.ConditionList();
        currenciesItemCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d("test API", "on response request");
                Toast.makeText(getContext(), "response : " + response.body().getCondition().isEmpty(), Toast.LENGTH_SHORT).show();

                Log.d("test API", "on response request " + response.body().getCondition().isEmpty() );
                coinsListAdapter.setData(response.body().getCurrencies());
                coinsListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d("test API", "on Failure request");

                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}