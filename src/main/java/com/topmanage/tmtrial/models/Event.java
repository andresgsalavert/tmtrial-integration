/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topmanage.tmtrial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andresgsalavert
 */
    
@SuppressWarnings("serial")
@Document(collection = "Event")  
@JsonRootName("Data") 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Serializable
{
    private String id;

    private String end_time;

    private String description;

    private String name;

    private String start_time;

    private Place place;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (String end_time)
    {
        this.end_time = end_time;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public Place getPlace ()
    {
        return place;
    }

    public void setPlace (Place place)
    {
        this.place = place;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", end_time = "+end_time+", description = "+description+", name = "+name+", start_time = "+start_time+", place = "+place+"]";
    }
}
			
			
