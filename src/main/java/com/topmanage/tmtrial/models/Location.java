/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topmanage.tmtrial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andresgsalavert
 */
@SuppressWarnings("serial")
@Document(collection = "Location")  
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable{
    private String longitude;

    private String latitude;

    private String country;

    private String city;

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [longitude = "+longitude+", latitude = "+latitude+", country = "+country+", city = "+city+"]";
    }
}
