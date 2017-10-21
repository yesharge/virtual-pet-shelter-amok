package VirtualPets;

public class Dog extends VirtualPet {

	public Dog(String name, String description, int happiness, int health) {
		super(name, description, happiness, health);
	}

	public Dog(String name, String description) {
		super(name, description);
	}

	public void walkDogs() {
		if (happiness <=75) {
			happiness += 25;
		}
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
		if (happiness >= 10) {
			happiness -= 10;
		}

	}
}
