package com.example.kurella.homeawaycodingchallenge.model;

import android.location.Location;

public class Venue {

    private Location location;

    private String state;

    private String score;

    private String[] links;

    private String url;

    private String city;

    private String extended_address;

    private String country;

    private String display_location;

    private String id;

    private String timezone;

    private String address;

    private String name;

    private String postal_code;

    private String slug;

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String[] getLinks ()
    {
        return links;
    }

    public void setLinks (String[] links)
    {
        this.links = links;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getExtended_address ()
    {
        return extended_address;
    }

    public void setExtended_address (String extended_address)
    {
        this.extended_address = extended_address;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getDisplay_location ()
    {
        return display_location;
    }

    public void setDisplay_location (String display_location)
    {
        this.display_location = display_location;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPostal_code ()
    {
        return postal_code;
    }

    public void setPostal_code (String postal_code)
    {
        this.postal_code = postal_code;
    }

    public String getSlug ()
    {
        return slug;
    }

    public void setSlug (String slug)
    {
        this.slug = slug;
    }

}
