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
@Document(collection = "Cursors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cursors implements Serializable{
    
    private String after;

    private String before;

    public String getAfter ()
    {
        return after;
    }

    public void setAfter (String after)
    {
        this.after = after;
    }

    public String getBefore ()
    {
        return before;
    }

    public void setBefore (String before)
    {
        this.before = before;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [after = "+after+", before = "+before+"]";
    }
    
}
