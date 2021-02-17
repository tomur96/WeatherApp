package com.fsecure.weatherapp.controllers;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WeatherController {

    private Response response;
    private String cityName;
    String unit;
    private String apiKey = "295d343c4d336b7f2227bd03d4d9a27a";
    private OkHttpClient client;

    public JSONObject getWeather(){
        client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("http://api.openweathermap.org/data/2.5/weather?q="+getCityName()+"&units="+getUnit()+"&appid=295d343c4d336b7f2227bd03d4d9a27a")
            .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }
    //reading JSON from openweather
    public JSONArray returnWeatherArray() throws JSONException {
        JSONArray weatherArray = getWeather().getJSONArray("weather");
        return weatherArray;
    }
    public JSONArray returnWind() throws JSONException {
        JSONArray wind = getWeather().getJSONArray("wind");
        return wind;
    }

    public JSONArray returnMain() throws JSONException {
        JSONArray main = getWeather().getJSONArray("main");
        return main;
    }
    public JSONArray returnSys() throws JSONException {
        JSONArray sys = getWeather().getJSONArray("sys");
        return sys;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

