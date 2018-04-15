package com.example.kurella.homeawaycodingchallenge.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kurella.homeawaycodingchallenge.R;
import com.example.kurella.homeawaycodingchallenge.model.RvItemPojo;
import com.squareup.picasso.Picasso;

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

    RvItemPojo rvItemPojo;
    Boolean favReturnVal = false;

    private static final String TAG = "ItemDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        rvItemPojo = intent.getParcelableExtra("pass");

        getSupportActionBar().setTitle(rvItemPojo.getShortTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title.setText(rvItemPojo.getTitle());
        location.setText(rvItemPojo.getLocation());
        date.setText(rvItemPojo.getDate());
        favIcon.setVisibility(View.INVISIBLE);
        Picasso.get()
                .load(rvItemPojo.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .transform(new CircleTransform())
                .into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_detail, menu);//Menu Resource, Menu
        MenuItem item = menu.getItem(0);
        if (rvItemPojo.getIsFav())
            item.setIcon(R.drawable.ic_favorite_black_24dp);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.fav_button){
            rvItemPojo.setFav(!rvItemPojo.getIsFav());
            if (rvItemPojo.getIsFav()){
                item.setIcon(R.drawable.ic_favorite_black_24dp);
                saveToSharedPref(rvItemPojo.getId());
            } else{
                item.setIcon(R.drawable.ic_favorite_border_black_24dp);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveToSharedPref(String id) {
        SharedPreferences sp = getSharedPreferences("fav id", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("fav id", id);
        editor.apply();
        Log.e(TAG, "saveToSharedPref: Saved" );
    }
}
