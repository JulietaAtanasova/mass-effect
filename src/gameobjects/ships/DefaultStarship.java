package gameobjects.ships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import gameobjects.enhancements.Enhancement;
import gameobjects.locations.StarSystem;
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

	public DefaultStarship(StarshipType type, String name, int health, int shileds, int damage, double fuel,
			StarSystem location) {
		this.setType(type);
		this.setName(name);;
		this.setHealth(health);;
		this.setShields(shileds);
		this.setDamage(damage);
		this.setFuel(fuel);
		this.setLocation(location);
		this.enhancements = new HashSet<Enhancement>();
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
		return null;
	}

	@Override
	public void respondAttack(Projectile attack) {
	}

	@Override
	public List<Enhancement> getEnhancements() {
		List<Enhancement> list = new ArrayList<>(this.enhancements);
		return list;
	}

	@Override
	public void addEnhancement(Enhancement enhancement) {
		this.enhancements.add(enhancement);
	}

}
