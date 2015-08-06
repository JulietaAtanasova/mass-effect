package gameobjects.ships;

import gameobjects.locations.StarSystem;
import gameobjects.projectiles.PenetrationShell;
import interfaces.Projectile;

public class Cruiser extends DefaultStarship {

	public Cruiser(String name, int health, int shileds, int damage, double fuel,
			StarSystem location) {
		super(name, health, shileds, damage, fuel, location);
		this.setType(StarshipType.Cruiser);
	}

	@Override
	public Projectile produceAttack() {
		this.setProjectilesFired(this.getProjectilesFired() + 1);
		return new PenetrationShell(this.getDamage());
	}

	@Override
	public void respondAttack(Projectile attack) {
		super.respondAttack(attack);
	}

}
