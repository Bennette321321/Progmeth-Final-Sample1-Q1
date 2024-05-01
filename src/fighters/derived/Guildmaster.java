package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Attackable, Guardable {
    public Guildmaster(int maxHealth, int speed, int power, int defense, int location) {
        super("Guildmaster", "G", maxHealth, speed, location, false);
        setDefense(defense);
        setPower(power);
        setRange(1);
    }

    @Override
    public int attack(Unit e) {
        if (sameTeam(e)) return -1;
        if (!BattleUtils.validRange(getRange(), getLocation(), e.getLocation())) return -1;
        return BattleUtils.calculateDamage(getPower(), e);
    }

    public boolean move(int spaces) {
        return super.move(-1);
    }

    @Override
    public void guard() {

    }
}
