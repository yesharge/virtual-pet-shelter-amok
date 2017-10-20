package VirtualPets;

public class OrganicDog extends Dog implements OrganicMethods {
	protected int hunger;
	protected int waste;

	public OrganicDog(String name, String description, int happiness, int health, int hunger, int waste) {
		super(name, description, happiness, health);
		this.hunger = hunger;
		this.waste = waste;
	}

	public OrganicDog(String name, String description) {
		super(name, description);
		this.hunger = random.nextInt(100) + 1;
		this.waste = random.nextInt(100) + 1;
	}

	@Override
	public void feedMe() {
		if (hunger <= 50) {
			hunger += 50;
		}
	}

	public void cleanCage() {
		waste = 0;
	}

	public int getHunger() {
		return hunger;
	}

	public int getWaste() {
		return waste;
	}

}