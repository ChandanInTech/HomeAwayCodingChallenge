package com.example.kurella.homeawaycodingchallenge.contractor;

import com.example.kurella.homeawaycodingchallenge.model.RvItemPojo;

import java.util.ArrayList;
import java.util.List;

public interface Contractor {
    interface View{

        List<RvItemPojo> getRvItems();
        void buildRv();
        void saveToSharedPref(String ids);
        String getFromSharedPref();
        String getSavedId();

    }

    interface Presenter{
        void searchFor(String textSearch);
        List<RvItemPojo> getRvItems();
        void buildRv();
        void saveToSharedPref(String ids);
        void getFromSharedPref();

        void getIdFromSP();
        //static Presenter getPresenter(Contractor.View view);
    }

    interface Model{
        void buildRetrofit(String textSearch);
        void searchFor(String textSearch);
        List<RvItemPojo> getRvItems();
        void setFavIds(ArrayList<String> ids);
        ArrayList<String> getFavItemsId();
        void addTOFavList(String id);
        void removeFomFavList(String id);

    }
}
