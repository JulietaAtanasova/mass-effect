package gameobjects.projectiles;

import interfaces.Starship;

public class ShieldReaver extends DefaultProjectile {

	public ShieldReaver(int damage) {
		super(damage);
	}

	@Override
	public void hit(Starship ship) {
		if ((ship.getHealth() - this.getDamage()) <= 0) {
			ship.setHealth(0);
		} else {
			ship.setHealth(ship.getHealth() - this.getDamage());
		}

		if ((ship.getShields() - this.getDamage() * 2) <= 0) {
			ship.setShields(0);
		} else {
			ship.setShields(ship.getShields() - this.getDamage() * 2);
		}
	}

}
