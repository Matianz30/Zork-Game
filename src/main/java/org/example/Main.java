package org.example;

import java.io.IOException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        Game game = StoryReader.readType();
        StoryTeller storyteller = new StoryTeller(game);
        storyteller.play();
    }
}
