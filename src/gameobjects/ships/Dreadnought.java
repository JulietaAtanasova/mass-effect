package gameobjects.ships;

import gameobjects.locations.StarSystem;
import gameobjects.projectiles.Laser;
import interfaces.Projectile;

public class Dreadnought extends DefaultStarship {

	protected static final int INITIAL_HEALTH = 200;
	protected static final int INITIAL_SHIELDS = 300;
	protected static final int INITIAL_DAMAGE = 150;
	protected static final double INITIAL_FUEL = 700;
	protected static final StarshipType STARSHIP_TYPE = StarshipType.Dreadnought;

	public Dreadnought(String name, StarSystem location) {
		super(name, location);
		this.setHealth(INITIAL_HEALTH);
		this.setShields(INITIAL_SHIELDS);
		this.setDamage(INITIAL_DAMAGE);
		this.setFuel(INITIAL_FUEL);
		this.setType(STARSHIP_TYPE);
		this.setType(STARSHIP_TYPE);
	}

	@Override
	public Projectile produceAttack() {
		return new Laser(this.getDamage() + (this.getShields() / 2));
	}

	@Override
	public void respondAttack(Projectile attack) {
		this.setShields(this.getShields() + 50);
		attack.hit(this);
		this.setShields(this.getShields() - 50);
	}

}
