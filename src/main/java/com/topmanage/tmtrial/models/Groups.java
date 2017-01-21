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
@Document(collection = "Groups")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Groups implements Serializable{
    
    private Group[] data;

    private Paging paging;

    public Group[] getData ()
    {
        return data;
    }

    public void setData (Group[] data)
    {
        this.data = data;
    }

    public Paging getPaging ()
    {
        return paging;
    }

    public void setPaging (Paging paging)
    {
        this.paging = paging;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", paging = "+paging+"]";
    }
    
}
