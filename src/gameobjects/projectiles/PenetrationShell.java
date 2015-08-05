package gameobjects.projectiles;

import interfaces.Starship;

public class PenetrationShell extends DefaultProjectile {

	public PenetrationShell(int damage) {
		super(damage);
	}

	@Override
	public void hit(Starship ship) {
		if ((ship.getHealth() - this.getDamage()) <= 0) {
			ship.setHealth(0);
			return;
		}
		ship.setHealth(ship.getHealth() - this.getDamage());
	}

}
