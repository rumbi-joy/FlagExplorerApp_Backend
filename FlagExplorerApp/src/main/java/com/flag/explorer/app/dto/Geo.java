package com.flag.explorer.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Geo(
     int lat,
    @JsonProperty("long") 
     int mylong) {}
