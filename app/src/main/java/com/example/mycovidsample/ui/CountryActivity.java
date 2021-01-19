package com.example.mycovidsample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mycovidsample.R;
import com.example.mycovidsample.adapter.CountryListAdapter;
import com.example.mycovidsample.network.CovidApi;
import com.example.mycovidsample.network.CovidClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {

    @BindView(R.id.covidRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private CovidCases mCases;
    private List<CovidCases> mCasesList = new ArrayList<CovidCases>();
    private CountryListAdapter mAdapter;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");

        CovidApi client = CovidClient.getClient();
        Call<CovidCases> call  = client.getCases(country);

        call.enqueue(new Callback<CovidCases>() {
            @Override
            public void onResponse(Call<CovidCases> call, Response<CovidCases> response) {
                if (response.isSuccessful()){
                    All all = response.body().getAll();
                    mCases = new CovidCases(all);
                    mCasesList.add(mCases);
                    mAdapter = new CountryListAdapter(CountryActivity.this,mCasesList);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CountryActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showCountry();
                } else {
                    showUnsucessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<CovidCases> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();

//                Log.d(TAG, "on the on failure method", t);
            }
        });

    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsucessfulMessage() {
        mErrorTextView.setText("Something went wrong. Kindly input relevant field");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCountry() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}