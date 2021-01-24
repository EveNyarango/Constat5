package com.example.mycovidsample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycovidsample.Constants;
import com.example.mycovidsample.R;
import com.example.mycovidsample.models.CountriesResponse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FirebaseCovidViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;


    public FirebaseCovidViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }



    public void bind(CountriesResponse countriesResponse) {

        TextView nameTextView = (TextView) mView.findViewById(R.id.tvCountryName);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.action_search);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.tvCountryName);




    }

    @Override
    public void onClick(View view) {
        final ArrayList<CountriesResponse> countriesResponses = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {


    }

}
