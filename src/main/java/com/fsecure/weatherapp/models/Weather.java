package com.fsecure.weatherapp.models;

import java.io.Serializable;



public class Weather implements Serializable {

    private String weatherDescription;


    public Weather weather(){
        return new Weather();
    }

    public Weather(){
        super();
    }
    public Weather(Weather weather){}
}
