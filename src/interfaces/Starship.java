package interfaces;

import gameobjects.locations.StarSystem;

public interface Starship extends Enhanceable {

	String getName();

	void setName(String name);

	int getHealth();

	void setHealth(int health);

	int getShields();

	void setShields(int shields);

	int getDamage();

	void setDamage(int damage);

	double getFuel();

	void setFuel(double fuel);

	StarSystem getLocation();

	void setLocation(StarSystem location);

	Projectile produceAttack();

	void respondAttack(Projectile attack);
}
