package Game.Location.BattleLoc;

import Game.Location.BattleLoc.NormalLoc;
import Game.Player;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz. Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());


    return true;
    }
}
