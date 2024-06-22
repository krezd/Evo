package com.example.location.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @JsonProperty("lat")
    private double lat;
    @NonNull
    @JsonProperty("lon")
    private double lon;

}
