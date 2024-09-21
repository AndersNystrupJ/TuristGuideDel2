package com.example.turistguidedel2.model;


public enum Tags {
    UNDERHOLDNING("Underholdning"),
    BAR("Bar"),
    SEVÆRDIGHED("Seværdighed"),
    RESTAURANT("Restaurant"),
    KØBENHAVN("København");

   //måske skal der laves en ny klasse

    private String displayTag;

    Tags(String displayTag){
        this.displayTag = displayTag;
    }
    public String getDisplayTag(){
        return displayTag;
    }
}


