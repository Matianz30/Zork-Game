package org.example;

import java.io.IOException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        Game game = StoryReader.readType();
        System.out.println(game.description());
        String room = game.startRoom();


        boolean end = false;
        while (!end) {
            var currentRoom = game.rooms().get(room);
            System.out.println(currentRoom);
            Console console = new Console();
            String userInput = console.readString();

            String userInputTrim = userInput.trim();

            String[] words = userInputTrim.split("\\s+");

            for (String word : words) {
                System.out.println(word);
            }

            if(Objects.equals(userInput, "end")) {
                end = true;
            }
            System.out.println(userInput);
        }
    }
}