package com.example.kurella.homeawaycodingchallenge.model;

public class Events {

    private String datetime_utc;

    private Venue venue;
    private String id;

    private String short_title;

    private Performers[] performers;

    private String title;
    public String getDatetime_utc ()
    {
        return datetime_utc;
    }
    public Venue getVenue ()
    {
        return venue;
    }
    public String getId ()
    {
        return id;
    }
    public String getShort_title ()
    {
        return short_title;
    }
    public Performers[] getPerformers ()
    {
        return performers;
    }

    public String getTitle ()
    {
        return title;
    }

}
