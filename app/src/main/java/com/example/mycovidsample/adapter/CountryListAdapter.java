package com.example.mycovidsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycovidsample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CasesViewHolder> {

    private List<CovidCases> mCases;
    private Context mContext;

    public CountryListAdapter(Context mContext, List<CovidCases> mCases){
        this.mContext = mContext;
        this.mCases = mCases;
    }

    @NonNull
    @Override
    public CountryListAdapter.CasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        CasesViewHolder viewHolder = new CasesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.CasesViewHolder holder, int position) {
        holder.bindAll(mCases.get(position));
    }

    @Override
    public int getItemCount() {
        return mCases.size();
    }

    public class CasesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.countryNameTextView)
        TextView mCountryNameTextView;
        @BindView(R.id.confirmedTextView) TextView mConfirmedTextView;
        @BindView(R.id.recoveredTextView) TextView mRecoveredTextView;
        @BindView(R.id.deathsTextView) TextView mDeathTextView;
        private Context mContext;

        public CasesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindAll(CovidCases covidCases) {
            mCountryNameTextView.setText(covidCases.getAll().getCountry());
            mConfirmedTextView.setText(String.valueOf(covidCases.getAll().getConfirmed()));
            mRecoveredTextView.setText(String.valueOf(covidCases.getAll().getRecovered()));
            mDeathTextView.setText(String.valueOf(covidCases.getAll().getDeaths()));
        }

    }
}
