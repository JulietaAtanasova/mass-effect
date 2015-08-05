package gameobjects.projectiles;

import interfaces.Projectile;
import interfaces.Starship;

public class ShieldReaver implements Projectile {
	private int damage;

	public ShieldReaver(int damage) {
		this.damage = damage;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

	@Override
	public void setDamage(int damage) {
		this.damage = damage;
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
