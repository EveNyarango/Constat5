//package com.example.mycovidsample.ui;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.mycovidsample.Constants;
//import com.example.mycovidsample.R;
//import com.example.mycovidsample.adapter.FirebaseCovidViewHolder;
//import com.example.mycovidsample.models.CountriesResponse;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class SavedCountryActivity<RecyclerView> extends AppCompatActivity {
//
//    private DatabaseReference mCountryReference;
//    private FirebaseRecyclerAdapter<CountriesResponse, FirebaseCovidViewHolder> mFirebaseAdapter;
//    @BindView(R.id.recyclerView)
//    RecyclerView mRecyclerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_country);
//        ButterKnife.bind(this);
////        mCountryReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS);
//        setUpFirebaseAdapter();
//    }
//    private void setUpFirebaseAdapter(){
//        FirebaseRecyclerOptions<CountriesResponse> options =
//                new FirebaseRecyclerOptions.Builder<CountriesResponse>()
//                        .setQuery(mCountryReference, CountriesResponse.class)
//                        .build();
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<CountriesResponse, FirebaseCovidViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull FirebaseCovidViewHolder firebaseCovidViewHolder, int position, @NonNull CountriesResponse countriesResponse) {
//                firebaseCovidViewHolder.bind(countriesResponse);
//            }
//            @NonNull
//            @Override
//            public FirebaseCovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
//                return new FirebaseCovidViewHolder(view);
//            }
//        };
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//}