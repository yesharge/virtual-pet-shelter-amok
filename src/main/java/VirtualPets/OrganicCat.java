package VirtualPets;

public class OrganicCat extends VirtualPet implements OrganicMethods {
	protected int hunger;
	protected int waste;

	public OrganicCat(String name, String description, int happiness, int health, int hunger, int waste) {
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

	public int getHunger() {
		return hunger;
	}

	public int getWaste() {
		return waste;
	}

	@Override
	public void tick() {
		selfCare = random.nextInt(50) + 1;

		if (selfCare == 5) {
			System.out.println("Good news! Someone adopted all of the pets in the shelter!");
			System.exit(0);
		}
		if (happiness >= 10) {
			happiness -= 10;
		}
		if (waste <= 90) {
			waste += 10;
		}
	}

	public void reduceWaste() {
		if (waste >= 35) {
			waste -= 35;
		}
		if (health <= 55) {
			health += 45;
		}
	}

	@Override
	public String toString() {
		return super.toString() + this.hunger + "\t|" + this.waste;
	}

}
