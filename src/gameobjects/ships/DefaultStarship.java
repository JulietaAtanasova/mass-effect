package gameobjects.ships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import gameobjects.enhancements.Enhancement;
import gameobjects.locations.StarSystem;
import gameobjects.projectiles.Laser;
import gameobjects.projectiles.PenetrationShell;
import gameobjects.projectiles.ShieldReaver;
import interfaces.Projectile;
import interfaces.Starship;

public class DefaultStarship implements Starship {
	private String name;
	private int health;
	private int shields;
	private int damage;
	private double fuel;
	private StarSystem location;
	private HashSet<Enhancement> enhancements;
	private StarshipType type;
	private int projectilesFired;

	public DefaultStarship(StarshipType type, String name, int health, int shileds, int damage, double fuel,
			StarSystem location) {
		this.setType(type);
		this.setName(name);;
		this.setHealth(health);;
		this.setShields(shileds);
		this.setDamage(damage);
		this.setFuel(fuel);
		this.setLocation(location);
		this.setProjectilesFired(0);
		this.setEnhancements(new HashSet<Enhancement>());
	}

	public StarshipType getType(){
		return this.type;
	}
	
	private void setType(StarshipType type){
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
		this.health = health;
	}

	@Override
	public int getShields() {
		return this.shields;
	}

	@Override
	public void setShields(int shields) {
		this.shields = shields;
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
	
	public int getProjectilesFired() {
		return this.projectilesFired;
	}
	

	private void setProjectilesFired(int projectilesFired) {
		this.projectilesFired = projectilesFired;
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
	public Projectile produceAttack() {
		this.setProjectilesFired(this.getProjectilesFired() + 1);
		switch (this.getType()) {
		case Frigate:
			return new ShieldReaver(this.getDamage());
		case Cruiser:
			return new PenetrationShell(this.getDamage());
		case Dreadnought:
			return new Laser(this.getDamage() + (this.getShields() / 2));
		default:
			return null;
		}
	}

	@Override
	public void respondAttack(Projectile attack) {
		attack.hit(this);
	}

	@Override
	public List<Enhancement> getEnhancements() {
		List<Enhancement> list = new ArrayList<>(this.enhancements);
		return list;
	}

	private void setEnhancements(HashSet<Enhancement> enhancements) {
		this.enhancements = enhancements;
	}
	
	@Override
	public void addEnhancement(Enhancement enhancement) {
		this.enhancements.add(enhancement);
	}

}
