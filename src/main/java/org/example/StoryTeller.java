package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StoryTeller {
    private Game game;
    private Room currentRoom;
    private Set<String> states = new HashSet<>();

    public StoryTeller(Game game) {
        this.game = game;
        this.currentRoom = game.rooms().get(game.startRoom());
    }

    public void play() {
        Console.print(game.description());
        while (true) {
            Console.print(currentRoom.description());
            String input = Console.readString();
            if (input.equals("end")) {
                break;
            }
            processCommand(input);
        }
    }

    private void processCommand(String input) {
        String[] parts = input.split(" ", 2);
        String verb = resolveVerb(parts[0]);
        String object = parts.length > 1 ? parts[1] : "";

        if (currentRoom.verbs().containsKey(verb)) {
            Map<String, List<Action>> actions = currentRoom.verbs().get(verb);
            if (actions.containsKey(object)) {
                performAction(actions.get(object));
            }
        }
    }

    private String resolveVerb(String inputVerb) {
        for (Map.Entry<String, Verb> entry : game.verbs().entrySet()) {
            Verb verb = entry.getValue();
            if (verb.synonyms.contains(inputVerb)) {
                return entry.getKey();
            }
        }
        return inputVerb;
    }

    private void performAction(List<Action> actions) {
        for (Action action : actions) {
            executeAction(action);
        }
    }

    private void executeAction(Action action) {
        if (action.room() != null) {
            currentRoom = game.rooms().get(action.room());
        }
        if (action.message() != null) {
            Console.print(action.message());
        }
        if (action.addState() != null) {
            states.add(action.addState());
        }
    }

}

