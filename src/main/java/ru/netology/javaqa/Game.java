package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public byte round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotFoundException("Игрок " + playerName1 + " не найден");
        } else if (findByName(playerName2) == null) {
            throw new NotFoundException("Игрок " + playerName2 + " не найден");
        }

        byte result;
        int playerStrength1 = findStrengthByName(playerName1);
        int playerStrength2 = findStrengthByName(playerName2);
        if (playerStrength1 > playerStrength2) {
            result = 1;
        } else if (playerStrength1 < playerStrength2) {
            result = 2;
        } else {
            result = 0;
        }
        return result;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }
        }
        return null;
    }

    public int findStrengthByName(String name) {
        return findByName(name).getStrength();
    }
}
