package com.topmanage.tmtrial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;


@SuppressWarnings("serial")
@Document(collection = "Users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable {

    private User[] data;

    private Paging paging;

    public User[] getData ()
    {
        return data;
    }

    public void setData (User[] data)
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
