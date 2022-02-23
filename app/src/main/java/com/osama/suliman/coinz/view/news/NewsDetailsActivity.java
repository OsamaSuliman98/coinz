package com.osama.suliman.coinz.view.news;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.osama.suliman.coinz.R;
import com.osama.suliman.coinz.view.base.BaseActivity;


public class NewsDetailsActivity extends BaseActivity {


   private TextView backTextView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        backTextView = findViewById(R.id.backTextView);


        backTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             onBackPressed();
            }
        });

        // لاستقبال الدتاتا من الريسايكلر
//        Intent intent = new Intent();
////        LocalNews news = (LocalNews) intent.getExtras().getSerializable("new");
//        getApplicationContext().startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}