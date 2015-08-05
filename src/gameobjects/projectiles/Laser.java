package gameobjects.projectiles;

import interfaces.Projectile;
import interfaces.Starship;

public class Laser implements Projectile {
	private int damage;
	
	public Laser(int damage) {
		this.setDamage(damage);
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
		int shieldsDamage = ship.getShields() - this.getDamage();
		if(shieldsDamage <= 0){
			ship.setShields(0);
			if((ship.getHealth() + shieldsDamage) <= 0){
				ship.setHealth(0);
				return;
			}
			ship.setHealth(ship.getHealth() + shieldsDamage);
			return;
		}
		ship.setShields(shieldsDamage);
	}

}
