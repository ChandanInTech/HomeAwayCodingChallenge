package com.example.kurella.homeawaycodingchallenge.model;

import android.util.Log;

import com.example.kurella.homeawaycodingchallenge.contractor.Contractor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements Contractor.Model {
    Contractor.Presenter presenter;
    static Model model = null;
    SimpleDateFormat requiredDF = new SimpleDateFormat("EEE, d MMM yyyy hh:mm aaa");
    SimpleDateFormat givenDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public Model(Contractor.Presenter presenter) {
        this.presenter = presenter;
    }
    public Model() {
    }

    private static final String TAG = "Model";

    List<RvItemPojo> rvData = new ArrayList<>();
    ArrayList<String> favItemsId = new ArrayList<>();

    @Override
    public void buildRetrofit(final String textSearch){
        String searchQ = (textSearch).replace(' ', '+');
        Log.e(TAG, "" + searchQ );
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SeatGeekRetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SeatGeekRetrofitApi api = retrofit.create(SeatGeekRetrofitApi.class);

        Call<DataPojo> call = api.getLocations(SeatGeekRetrofitApi.client_id,searchQ);

        call.enqueue(new Callback<DataPojo>() {
            @Override
            public void onResponse(Call<DataPojo> call, Response<DataPojo> response) {
                Log.e(TAG, "onResponse: " + response.toString() );
                DataPojo locations = response.body();
                List<Events> results = response.body().getEvents();

                //Clearing and updating rvData
                rvData.clear();

                for (Events event: results){
                    boolean isFav = false;
                    for (String s: favItemsId){
                        if (s == event.getId()){
                            isFav = true;
                        }
                    }

                    Date t = new Date();
                    try {
                        t = givenDF.parse(event.getDatetime_utc());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    rvData.add(new RvItemPojo(event.getTitle(),
                            event.getVenue().getDisplay_location(),
//                            event.getDatetime_utc(),
                            requiredDF.format(t),
                            event.getId(),
                            event.getPerformers()[0].getImage(),
                            event.getShort_title(),
                            isFav));

                }
                //Log.e(TAG, "rvData Size " + rvData.size() );

                presenter.buildRv();
            }

            @Override
            public void onFailure(Call<DataPojo> call, Throwable t) {
            }
        });
    }

    @Override
    public void searchFor(String textSearch) {
        buildRetrofit(textSearch);
    }

    @Override
    public List<RvItemPojo> getRvItems() {
        return rvData;
    }

    @Override
    public void setFavIds(ArrayList<String> ids){
        favItemsId = ids;
    }

    @Override
    public ArrayList<String> getFavItemsId(){
        return favItemsId;
    }

    public void addTOFavList(String id){
        favItemsId.add(id);
    }

    @Override
    public void removeFomFavList(String id) {
        favItemsId.remove(id);
    }


}
