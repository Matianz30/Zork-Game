package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
    record Room(String description, String name, Map<String, Map<String, List<Action>>> verbs) { }
