package com.example.kurella.homeawaycodingchallenge.model;

public class Meta {

    private String total;

    private String per_page;

    //private null geolocation;

    private String page;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getPer_page ()
    {
        return per_page;
    }

    public void setPer_page (String per_page)
    {
        this.per_page = per_page;
    }

//    public null getGeolocation ()
//    {
//        return geolocation;
//    }
//
//    public void setGeolocation (null geolocation)
//    {
//        this.geolocation = geolocation;
//    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

}
