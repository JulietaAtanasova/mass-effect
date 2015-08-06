package gameobjects.ships;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gameobjects.enhancements.Enhancement;
import gameobjects.locations.StarSystem;
import interfaces.Projectile;
import interfaces.Starship;

public abstract class DefaultStarship implements Starship {
	private String name;
	private int health;
	private int shields;
	private int damage;
	private double fuel;
	private StarSystem location;
	private List<Enhancement> enhancements;
	private StarshipType type;
	
	protected static final int INITIAL_HEALTH = 0;
	protected static final int INITIAL_SHIELDS = 0;
	protected static final int INITIAL_DAMAGE = 0;
	protected static final double INITIAL_FUEL = 0;
	
	public DefaultStarship(String name, StarSystem location) {
		this.setName(name);
		this.setLocation(location);
		this.setHealth(INITIAL_HEALTH);
		this.setShields(INITIAL_SHIELDS);
		this.setDamage(INITIAL_DAMAGE);
		this.setFuel(INITIAL_FUEL);
		this.setEnhancements(new ArrayList<Enhancement>());
	}

	public StarshipType getType() {
		return this.type;
	}

	protected void setType(StarshipType type) {
		this.type = type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(int health) {
		int newHealthValue = Math.max(health, 0);
		this.health = newHealthValue;
	}

	@Override
	public int getShields() {
		return this.shields;
	}

	@Override
	public void setShields(int shields) {
		int newShieldsValue = Math.max(shields, 0);
		this.shields = newShieldsValue;
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
	public double getFuel() {
		return this.fuel;
	}

	@Override
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	@Override
	public StarSystem getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(StarSystem location) {
		this.location = location;
	}

	@Override
	public abstract Projectile produceAttack();

	@Override
	public void respondAttack(Projectile attack) {
		attack.hit(this);
	}

	@Override
	public List<Enhancement> getEnhancements() {
		return this.enhancements;
	}

	private void setEnhancements(List<Enhancement> list) {
		this.enhancements = list;
	}

	@Override
	public void addEnhancement(Enhancement enhancement) {
		this.setShields(this.getShields() + enhancement.getShieldBonus());
		this.setDamage(this.getDamage() + enhancement.getDamageBonus());
		this.setFuel(this.getFuel() + enhancement.getFuelBonus());
		this.enhancements.add(enhancement);
	}

	public boolean isIntact() {
		if (this.getHealth() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("--%s - %s\n", this.getName(), this.getType()));
		if (this.getHealth() == 0) {
			sb.append("(Destroyed)");
			return sb.toString();
		}

		sb.append(String.format("-Location: %s\n", this.getLocation().getName()));
		sb.append(String.format("-Health: %s\n", this.getHealth()));
		sb.append(String.format("-Shields: %s\n", this.getShields()));
		sb.append(String.format("-Damage: %s\n", this.getDamage()));
		sb.append(String.format("-Fuel: %s\n", this.getFuel()));

		String enhancements = "N/A";
		if (this.getEnhancements().size() > 0) {
			enhancements = String.join(", ",
					this.getEnhancements().stream().map(e -> e.getName()).collect(Collectors.toList()));
		}

		sb.append(String.format("-Enhancements: %s", enhancements));
		return sb.toString();
	}

}
