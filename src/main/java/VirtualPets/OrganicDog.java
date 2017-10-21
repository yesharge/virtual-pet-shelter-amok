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
	@Override
	public void walkDogs() {
		if (happiness <= 75) {
			happiness += 25;
		}
		if ( waste>=15) {
			waste-=15;
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
	@Override
	public void tick() {
		selfCare = random.nextInt(15) + 1;

		if (selfCare == 5) {
			System.out.println("Good news! Someone adopted all of the pets in the shelter!");
			System.exit(0);
		}
		if (health >= 10) {
			health -= 10;
		}
		if (happiness>= 10) {
			happiness -= 10;
		}
		if (waste<=90) {
			waste+=10;
		}

	}
	@Override
	public String toString() {
		return super.toString() + this.hunger + "\t|" + this.waste;
	}

}