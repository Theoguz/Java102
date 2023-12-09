package Game.Location.BattleLoc;
import Game.Location.Location;
import Game.Player;

public class NormalLoc extends Location {

    public NormalLoc(Player player, String name) {
        super(player, "Normal Loc" );
    }

    @Override
    public boolean onLocation() {
        return true;
    }

}
