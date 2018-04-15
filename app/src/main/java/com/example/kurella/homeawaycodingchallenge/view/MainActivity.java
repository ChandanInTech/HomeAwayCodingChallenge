package com.example.kurella.homeawaycodingchallenge.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;

import com.example.kurella.homeawaycodingchallenge.R;
import com.example.kurella.homeawaycodingchallenge.contractor.Contractor;
import com.example.kurella.homeawaycodingchallenge.model.RvItemPojo;
import com.example.kurella.homeawaycodingchallenge.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Contractor.View {

    @BindView(R.id.serach_bar)
    SearchView search;
    @BindView(R.id.rv)
    RecyclerView rv;

    private static final String TAG = "MainActivity";
    Contractor.Presenter presenter;
    List<RvItemPojo> rvData;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
        presenter.getFromSharedPref();

        search.setQueryHint("Texas Rang");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setIconified(false);
            }
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                presenter.searchFor(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                presenter.searchFor(s);
                return false;
            }
        });
    }

    @Override
    public void buildRv() {
        rvData = getRvItems();

        rv.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rvAdapter = new MyAdapter(rvData, this);

        rv.setAdapter(rvAdapter);
    }

    @Override
    public void saveToSharedPref(String ids){
        SharedPreferences sp = getSharedPreferences("savedItems", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("saved rvItemPojo id",ids);
        editor.apply();
    }

    public String getSavedId(){
        SharedPreferences sp = getSharedPreferences("fav id", MODE_PRIVATE);
        return sp.getString("fav id", null);
    }

    @Override
    public String getFromSharedPref(){
        SharedPreferences sp = getSharedPreferences("savedItems", MODE_PRIVATE);
        return sp.getString("saved rvItemPojo id", null);
    }

    @Override
    public List<RvItemPojo> getRvItems() {
        return presenter.getRvItems();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getIdFromSP();
    }
}
