package com.grishko188.carouselrecyclerview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.grishko188.carouselrecyclerview.adapter.FriendsAdapter;
import com.grishko188.carouselrecyclerview.model.Friend;
import com.grishko188.carouselrecyclerview.model.FriendsParser;
import com.grishko188.carouselrecyclerview.utils.AssetHelper;
import com.grishko188.carouselrecyclerview.utils.ConvertUtil;
import com.grishko188.library.CarouselRecyclerView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CarouselRecyclerView mRecyclerView;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (CarouselRecyclerView) findViewById(R.id.carousel);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        mRecyclerView.setChildViewHeight((int) ConvertUtil.px2dp(this, 230));
        mRecyclerView.setClickListener(new CarouselRecyclerView.ClickListener() {
            @Override
            public void onClick(CarouselRecyclerView.ViewHolder viewHolder) {
                Toast.makeText(MainActivity.this, "Click at" + viewHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTopEmptyRegionClick() {

            }
        });

        new AsyncTask<Void, Void, List<Friend>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mRecyclerView.setVisibility(View.GONE);
                mProgress.setVisibility(View.VISIBLE);
            }

            @Override
            protected List<Friend> doInBackground(Void... voids) {
                try {
                    String friendJson = AssetHelper.readFromFile(MainActivity.this, "mockdata/mock_friends_list.json");
                    return new FriendsParser().parseJSON(friendJson);
                } catch (Throwable t) {
                    Log.e("Error", t.toString());
                }
                return Collections.emptyList();
            }

            @Override
            protected void onPostExecute(List<Friend> friends) {
                super.onPostExecute(friends);
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgress.setVisibility(View.GONE);
                mRecyclerView.setAdapter(new FriendsAdapter(MainActivity.this, friends));
            }
        }.execute();
    }
}
