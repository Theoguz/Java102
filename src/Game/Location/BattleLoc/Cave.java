package Game.Location.BattleLoc;

import Game.Location.BattleLoc.BattleLoc;
import Game.Location.Obstacle.Zombie;
import Game.Player;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 7);
    }
}
