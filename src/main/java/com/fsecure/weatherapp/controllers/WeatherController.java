package com.fsecure.weatherapp.controllers;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
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
