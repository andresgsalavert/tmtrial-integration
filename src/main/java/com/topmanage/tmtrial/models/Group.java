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
@Document(collection = "Group")
@JsonRootName("Data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group implements Serializable{
    
    private String id;

    private String name;

    private String privacy;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPrivacy ()
    {
        return privacy;
    }

    public void setPrivacy (String privacy)
    {
        this.privacy = privacy;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+", privacy = "+privacy+"]";
    }
    
}
