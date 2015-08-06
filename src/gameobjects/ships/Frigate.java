package gameobjects.ships;

import gameobjects.locations.StarSystem;
import gameobjects.projectiles.ShieldReaver;
import interfaces.Projectile;

public class Frigate extends DefaultStarship {
	private int firedProjectiles = 0;
	
	protected static final int INITIAL_HEALTH = 60;
	protected static final int INITIAL_SHIELDS = 50;
	protected static final int INITIAL_DAMAGE = 30;
	protected static final double INITIAL_FUEL = 220;
	protected static final StarshipType STARSHIP_TYPE = StarshipType.Frigate;
	
	public Frigate(String name, StarSystem location) {
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
		this.firedProjectiles++;
		return new ShieldReaver(this.getDamage());
	}

	@Override
	public void respondAttack(Projectile attack) {
		super.respondAttack(attack);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		if (this.getHealth() != 0) {
			sb.append(String.format("\n-Projectiles fired: %d", this.firedProjectiles));
		}
		return sb.toString();
	}

}
