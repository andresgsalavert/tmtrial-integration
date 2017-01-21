/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topmanage.tmtrial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andresgsalavert
 */

@SuppressWarnings("serial")
@Document(collection = "Paging")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {
    
    private String next;

    private Cursors cursors;

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public Cursors getCursors ()
    {
        return cursors;
    }

    public void setCursors (Cursors cursors)
    {
        this.cursors = cursors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [next = "+next+", cursors = "+cursors+"]";
    }
    
}
