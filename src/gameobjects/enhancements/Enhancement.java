package gameobjects.enhancements;

public class Enhancement {
	private String name;
	private int shieldBonus;
	private int damageBonus;
	private double fuelBonus;

	public Enhancement(String name, int shieldBonus, int damageBonus, double fuelBonus) {
		this.setName(name);
		this.setShieldBonus(shieldBonus);
		this.setDamageBonus(damageBonus);
		this.setFuelBonus(fuelBonus);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getShieldBonus() {
		return shieldBonus;
	}

	private void setShieldBonus(int shieldBonus) {
		this.shieldBonus = shieldBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	private void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	public double getFuelBonus() {
		return fuelBonus;
	}

	private void setFuelBonus(double fuelBonus) {
		this.fuelBonus = fuelBonus;
	}

}
