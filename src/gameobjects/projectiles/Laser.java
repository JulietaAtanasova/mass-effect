package gameobjects.projectiles;

import interfaces.Starship;

public class Laser extends DefaultProjectile {

	public Laser(int damage) {
		super(damage);
	}

	@Override
	public void hit(Starship ship) {
		int shieldsDamage = ship.getShields() - this.getDamage();
		if (shieldsDamage <= 0) {
			ship.setShields(0);
			if ((ship.getHealth() + shieldsDamage) <= 0) {
				ship.setHealth(0);
				return;
			}
			ship.setHealth(ship.getHealth() + shieldsDamage);
			return;
		}
		ship.setShields(shieldsDamage);
	}

}
