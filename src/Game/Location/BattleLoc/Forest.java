package Game.Location.BattleLoc;

import Game.Location.BattleLoc.BattleLoc;
import Game.Location.Obstacle.Vampire;
import Game.Player;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Water", 10);
    }
}
