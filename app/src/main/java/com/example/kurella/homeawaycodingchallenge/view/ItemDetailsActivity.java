package com.example.kurella.homeawaycodingchallenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kurella.homeawaycodingchallenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.tv_location)
    TextView location;
    @BindView(R.id.tv_time)
    TextView date;
    @BindView(R.id.imageView2)
    ImageView favIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
