package com.osama.suliman.coinz.view.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.osama.suliman.coinz.Api.ApiCilent;
import com.osama.suliman.coinz.Api.ApiInterface;
import com.osama.suliman.coinz.model.coin.BaseResponse;
import com.osama.suliman.coinz.model.coin.News;
import com.osama.suliman.coinz.model.news.LocalNews;
import com.osama.suliman.coinz.view.news.adapters.NewsAdapter;
import com.osama.suliman.coinz.R;
import com.osama.suliman.coinz.view.news.adapters.NewsAdapterCallback;
import com.osama.suliman.coinz.viewModel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;
    private RecyclerView linearRecyclerVieew;
    private View root;
    private ArrayList<News> news;
   private NewsAdapter newsAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
         root = inflater.inflate(R.layout.fragment_notifications, container, false);

//        ArrayList<LocalNews> newArrayList = new ArrayList<>();
//        newArrayList.add(new LocalNews(1,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(2,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(3,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(4,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(5,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(6,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//        newArrayList.add(new LocalNews(7,"انتعاش في قيمة العملات الرقمية الرئيسية تمثلت بارتفاع كل من البيتكوين والاثيريوم وكاردانو",+R.drawable.photo , "1/1/2021"));
//       handleRecycler(newArrayList);

        initRecycle();
        RegisterNews(6, 1);


        newsAdapter.setNewsAdapterCallback(new NewsAdapterCallback() {
            @Override
            public void onClickItem(int position, News news) {
                Intent intent = new Intent(getActivity() , NewsDetailsActivity.class);
                intent.putExtra("news_id",news.getPkIId());
                startActivity(intent);
            }
        });
//        newsAdapter.setNewsAdapterCallback(new NewsAdapterCallback() {
//            @Override
//            public void onClickItem(int position, LocalNews localNews) {
//            Intent intent = new Intent(getActivity() , NewsDetailsActivity.class);
//         //   intent.putExtra("news_id",localNews.getId());
//            startActivity(intent);
//            }
//        });

        return root;

    }
//    public void handleRecycler(List<LocalNews> localNews) {
//        linearRecyclerView = root.findViewById(R.id.recycler);
//        newsAdapter = new NewsAdapter(localNews);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        linearRecyclerView.setLayoutManager(linearLayoutManager);
//        linearRecyclerView.setAdapter(newsAdapter);
//        newsAdapter.notifyDataSetChanged();
 //   }

    private void initRecycle(){

        linearRecyclerVieew = root.findViewById(R.id.linearRecyclerVieew);
        newsAdapter = new NewsAdapter(new ArrayList<>());
        linearRecyclerVieew.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        linearRecyclerVieew.setAdapter(newsAdapter);

    }

    private void RegisterNews(Integer i_page_count, Integer i_page_number){
        ApiInterface apiInterface= ApiCilent.getClient().create(ApiInterface.class);
        Call<BaseResponse> newsItemCall = apiInterface.baseResponseNews(i_page_count,i_page_number);
        newsItemCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                newsAdapter.setData(response.body().getNewsList());
                newsAdapter.notifyDataSetChanged();
               // Log.d("DDDDDD", response.body().toString());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
            Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}