package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String currentName) {
        return roster.removeIf(e -> e.getName().equals(currentName));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> result = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                result.add(player);
            }
        }
        roster.removeIf(e -> e.getClazz().equals(clazz));

        Player[] finalResult = new Player[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Players in the guild: %s:", this.name)).append(System.lineSeparator());
        for (Player player : roster) {
            result.append(player.toString()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
