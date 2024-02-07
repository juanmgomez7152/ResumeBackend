package com.juanmgomezguzman.resume.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String content;

    // Getters and Setters
    public Integer getID(){
        return id;
    }
    public void setID(int identificacion){
        this.id = identificacion;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String UpdatedContent){
        this.content = UpdatedContent;
    }
}
