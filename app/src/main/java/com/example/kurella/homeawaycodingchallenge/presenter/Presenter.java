package com.example.kurella.homeawaycodingchallenge.presenter;

import android.util.Log;

import com.example.kurella.homeawaycodingchallenge.contractor.Contractor;


import com.example.kurella.homeawaycodingchallenge.model.Model;
import com.example.kurella.homeawaycodingchallenge.model.RvItemPojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presenter implements Contractor.Presenter{

    private static final String TAG = "Presenter";

    Contractor.View view;
    Contractor.Model model;
    static Presenter presenter;
    public Presenter(Contractor.View view) {
        this.view = view;
        model = new Model(this);
    }

    @Override
    public void searchFor(String textSearch) {
        model.searchFor(textSearch);
    }

    @Override
    public List<RvItemPojo> getRvItems() {
        return model.getRvItems();
    }

    @Override
    public void buildRv() {
     view.buildRv();
    }

    @Override
    public void saveToSharedPref(String ids) {

    }

    @Override
    public void getFromSharedPref() {
        ArrayList<String> ids;
        String idStr = view.getFromSharedPref();
        if (idStr != null){
            ids = new ArrayList<String>(Arrays.asList(idStr.split(",")));
        }else
            ids = new ArrayList<>();
        model.setFavIds(ids);
    }

    @Override
    public void getIdFromSP() {
        model.addTOFavList(view.getSavedId());
        Log.e(TAG, "presenter got it " );
    }
}
