
package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (character.getName() == null
                || character.getName().trim().isEmpty()) {
            return false;
        }

        for (Character existing : characters) {
            if (existing.equals(character)) {
                return false;
            }
        }

        characters.add(character);
        return true;
    }

    public boolean removeCharacter(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return characters.removeIf(
                character -> character.getName().equalsIgnoreCase(name));
    }

    public Character getCharacterByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public int getCharacterCount() {
        return characters.size();
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }
}
