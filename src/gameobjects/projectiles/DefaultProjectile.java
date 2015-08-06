package gameobjects.projectiles;

import interfaces.Projectile;
import interfaces.Starship;

public abstract class DefaultProjectile implements Projectile {
	protected int damage;

	protected DefaultProjectile(int damage) {
		this.damage = damage;
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
	public abstract void hit(Starship ship);

}
