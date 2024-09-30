package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class StoryReader {

    public static Game readType() throws IOException {
        return new ObjectMapper(new YAMLFactory()).
                readValue(
                        new File("tutorial.yaml"),
                        Game.class
                );
    }
    }

