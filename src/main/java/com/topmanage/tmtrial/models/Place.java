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
@Document(collection = "Place")  
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place implements Serializable{
    private String id;

    private Location location;

    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", location = "+location+", name = "+name+"]";
    }
}