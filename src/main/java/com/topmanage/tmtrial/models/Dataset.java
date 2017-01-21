/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topmanage.tmtrial.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author andresgsalavert
 */
@SuppressWarnings("serial")
@Document(collection = "Datasets")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dataset<D> implements Serializable{
    
    @Id
    private String id;
    
    private Date date;
    
    private String type;
    
    private String pattern;
    
    private D data;
    
    public Dataset(){
        this.date = new Date();
        this.type = "";
        this.pattern = "";
    }

    /**
     * @return the date
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the data
     */
    public D getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(D data) {
        this.data = data;
    }

    /**
     * @return the searchPattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param searchPattern the searchPattern to set
     */
    public void setPattern(String searchPattern) {
        this.pattern = searchPattern;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
