package com.juanmgomezguzman.resume.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String myname;
    private String myemail;
    private String myphone;
    private String mylocation;
    private String mylinkedin;
    private String mygithub;
    private String mywebsite;

     // Getters and Setters
     public String getName(){
        return myname;
     }
     public void setName(String name){
        this.myname=name;
     }

     public String getEmail(){
        return myemail;
     }
     public void setEmail(String email){
        this.myemail = email;
     }

     public String getPhone(){
        return myphone;
     }
     public void setPhone(String phone){
        this.myphone = phone;
     }

     public String getLocation(){
        return mylocation;
     }
     public void setLocation(String location){
        this.mylocation = location;
     }

     public String getLinkedIn(){
        return mylinkedin;
     }
     public void setLinkedIn(String linkedin){
        this.mylinkedin = linkedin;
     }

     public String getGithub(){
        return mygithub;
     }
     public void setGitHub(String github){
        this.mygithub = github;
     }

     public String getWebsite(){
        return mywebsite;
     }
     public void setWebsite(String website){
        this.mywebsite = website;
     }
    
}
