package com.example.turistguidedel2.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    private String name;
    private String description;
    private String city;
    private List<Tags> tags;

    public TouristAttraction(){
    }

    public TouristAttraction(String name, String description, String city, List<Tags> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public List<Tags> getTags(){
        return tags;
    }


    public String getName() {
        return name;
    }
    public void setTags(List<Tags> tags){
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCity() {
        return city;
    }

    public void setLokation(String city) {
        this.city = city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
