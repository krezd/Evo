package com.example.location.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;
}
