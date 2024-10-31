package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
 public record Game(String startRoom, String description, Map<String, Room> rooms, Map<String, Verb> verbs) { }
