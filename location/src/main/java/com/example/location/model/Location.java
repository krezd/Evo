package com.example.location.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private int id;
    @JsonProperty("name")
    private String location;
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;

}
