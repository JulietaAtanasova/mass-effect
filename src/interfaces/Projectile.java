package interfaces;

public interface Projectile {
	int getDamage();

	void setDamage(int damage);

	void hit(Starship ship);
}
