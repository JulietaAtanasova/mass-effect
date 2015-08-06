package gameobjects.ships;

import gameobjects.locations.StarSystem;
import gameobjects.projectiles.Laser;
import interfaces.Projectile;

public class Dreadnought extends DefaultStarship {

	public Dreadnought(String name, int health, int shileds, int damage, double fuel, StarSystem location) {
		super(name, health, shileds, damage, fuel, location);
		this.setType(StarshipType.Dreadnought);
	}

	@Override
	public Projectile produceAttack() {
		this.setProjectilesFired(this.getProjectilesFired() + 1);
		return new Laser(this.getDamage() + (this.getShields() / 2));
	}

	@Override
	public void respondAttack(Projectile attack) {
		this.setShields(this.getShields() + 50);
		attack.hit(this);
		this.setShields(this.getShields() - 50);
	}

}
