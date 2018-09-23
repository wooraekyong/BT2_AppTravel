package com.wooraekyong.bt2;

public class Place {

    private String placeName;

    //image name
    private String imgPlaceName;
    private int population;

    public Place(String placeName,String imgPlaceName,int population){
        this.placeName = placeName;
        this.imgPlaceName = imgPlaceName;
        this.population = population;
    }

    public  int getPopulation(){
        return population;
    }

    public void setPopulation(int population){
        this.population = population;
    }
    public String getPlaceName(){
        return placeName;
    }

    public void setPlaceName(String placeName){
        this.placeName = placeName;
    }

    public String getImgPlaceName(){
        return imgPlaceName;
    }
    public void setImgPlaceName(String imgPlaceName){
        this.imgPlaceName = imgPlaceName;
    }

    @Override
    public String toString() {
        return this.placeName+" (Population: "+ this.population+")";

    }
}
