package com.example.kurella.homeawaycodingchallenge.model;

import java.util.ArrayList;

public class DataPojo {
    private ArrayList<Events> events;

    private Meta meta;

    public ArrayList<Events> getEvents ()
    {
        return events;
    }

    public void setEvents (ArrayList<Events> events)
    {
        this.events = events;
    }

    public Meta getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta meta)
    {
        this.meta = meta;
    }
}
