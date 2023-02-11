package logic;

public class UnitCard {
	//Fields
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;
	
	//Constructors
	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
	}
	
	//Methods
	public void setName(String name) {
		this.name = (name.isBlank()||name==null) ? "Creature" : name;
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = bloodCost < 0 ? 0 : bloodCost;
	}

	public void setPower(int power) {
		this.power = power < 0 ? 0 : power;
	}

	public void setHealth(int health) {
		this.health = health < 1 ? 1 : health;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	
	public boolean equals(UnitCard other) {
		return this.name.equals(other.name);
	}
	
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
	
	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}

	public String getFlavorText() {
		return flavorText;
	}
}
