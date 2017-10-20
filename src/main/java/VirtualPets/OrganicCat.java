package VirtualPets;

public class OrganicCat extends VirtualPet implements OrganicMethods {
	protected int hunger;
	protected int waste;

	public OrganicCat(String name, String description, int happiness, int health,  int hunger,
			int waste) {
		super(name, description, happiness, health);
		this.hunger = hunger;
		this.waste = waste;
	}

	public OrganicCat(String name, String description) {
		super(name, description);
		this.hunger = random.nextInt(100) + 1;
		this.waste = random.nextInt(10) + 1;
	}

	@Override
	public void feedMe() {
		if (hunger <= 50) {
			hunger += 50;
		}
	}

	public void tick() {
		hunger += 10;

	}

	public int getHunger() {
		return hunger;
	}

	public int getWaste() {
		return waste;
	}

}
