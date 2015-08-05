package gameobjects.ships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import gameobjects.enhancements.Enhancement;
import gameobjects.locations.StarSystem;
import gameobjects.projectiles.Laser;
import gameobjects.projectiles.PenetrationShell;
import gameobjects.projectiles.ShieldReaver;
import interfaces.Projectile;
import interfaces.Starship;

public abstract class DefaultStarship implements Starship {
	private String name;
	private int health;
	private int shields;
	private int damage;
	private double fuel;
	private StarSystem location;
	private HashSet<Enhancement> enhancements;
	private StarshipType type;
	private int projectilesFired;

	public DefaultStarship(String name, int health, int shileds, int damage, double fuel,
			StarSystem location) {
		this.setName(name);
		this.setHealth(health);
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
	
	protected void setType(StarshipType type){
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
	

	protected void setProjectilesFired(int projectilesFired) {
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
		return null;
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

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("--%s - %s\n", this.getName(), this.getType()));
		if(this.getHealth() == 0){
			sb.append("(Destroyed)");
			return sb.toString();
		}
		
		sb.append(String.format("-Location: %s\n", this.getLocation().getName()));
		sb.append(String.format("-Health: %s\n", this.getHealth()));
		sb.append(String.format("-Shields: %s\n", this.getShields()));
		sb.append(String.format("-Damage: %s\n", this.getDamage()));
		sb.append(String.format("-Fuel: %s\n", this.getFuel()));
		sb.append(String.format("-Enhancements: %s", getEnhancementStatus(this)));
		return sb.toString();
	}

	private String getEnhancementStatus(DefaultStarship ship){
		String enhancements = "N/A";

		if (ship.getEnhancements().size() > 0) {
			List<String> enhancementsNames = ship.getEnhancements().stream().map(e -> e.getName())
					.collect(Collectors.toList());
			Collections.reverse(enhancementsNames);
			enhancements = String.join(", ", enhancementsNames);
		}
		return enhancements;
	}
}
