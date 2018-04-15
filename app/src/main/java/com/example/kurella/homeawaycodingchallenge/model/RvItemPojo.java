package com.example.kurella.homeawaycodingchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RvItemPojo implements Parcelable {
    String title;
    String location;
    String date;
    String id;
    boolean isFav = false;
    String imageUrl;
    String shortTitle;

    public RvItemPojo(String title, String location, String date, String id, String imageUrl, String shortTitle, boolean isFav) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.id = id;
        this.imageUrl = imageUrl;
        this.shortTitle = shortTitle;
        this.isFav = isFav;
    }

    protected RvItemPojo(Parcel in) {
        title = in.readString();
        location = in.readString();
        date = in.readString();
        id = in.readString();
        isFav = in.readByte() != 0;
        imageUrl = in.readString();
        shortTitle = in.readString();
    }

    public static final Creator<RvItemPojo> CREATOR = new Creator<RvItemPojo>() {
        @Override
        public RvItemPojo createFromParcel(Parcel in) {
            return new RvItemPojo(in);
        }

        @Override
        public RvItemPojo[] newArray(int size) {
            return new RvItemPojo[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public boolean getIsFav() {
        return isFav;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(location);
        parcel.writeString(date);
        parcel.writeString(id);
        parcel.writeByte((byte) (isFav ? 1 : 0));
        parcel.writeString(imageUrl);
        parcel.writeString(shortTitle);
    }
}
