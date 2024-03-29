package Game.Location;

import Game.Player;

public abstract class Location {
    private String name;
    private Player player;

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;

    }

    public abstract boolean onLocation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
