package gameobjects.ships;

import gameobjects.locations.StarSystem;
import gameobjects.projectiles.PenetrationShell;
import interfaces.Projectile;

public class Cruiser extends DefaultStarship {

	protected static final int INITIAL_HEALTH = 100;
	protected static final int INITIAL_SHIELDS = 100;
	protected static final int INITIAL_DAMAGE = 50;
	protected static final double INITIAL_FUEL = 300;
	protected static final StarshipType STARSHIP_TYPE = StarshipType.Cruiser;
	
	public Cruiser(String name, StarSystem location) {
		super(name, location);
		this.setHealth(INITIAL_HEALTH);
		this.setShields(INITIAL_SHIELDS);
		this.setDamage(INITIAL_DAMAGE);
		this.setFuel(INITIAL_FUEL);
		this.setType(STARSHIP_TYPE);
	}

	@Override
	public Projectile produceAttack() {
		return new PenetrationShell(this.getDamage());
	}

	@Override
	public void respondAttack(Projectile attack) {
		super.respondAttack(attack);
	}

}
