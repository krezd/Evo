package com.example.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty("name")
    private String city;
    private Sys sys;
    private Main main;

    @Data
    public static class Sys {
        @JsonProperty("country")
        private String country;
    }

    @Data
    public static class Main {
        @JsonProperty("temp")
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
        @JsonProperty("temp_min")
        private double tempMin;
        @JsonProperty("temp_max")
        private double tempMax;
        @JsonProperty("pressure")
        private double pressure;
        @JsonProperty("humidity")
        private double humidity;
        @JsonProperty("sea_level")
        private double seaLevel;
        @JsonProperty("grnd_level")
        private double grndLevel;


    }
}
