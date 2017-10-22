package VirtualPets;

public class RoboticCat extends VirtualPet implements RoboticMethods {
	protected int oilLevel;

	public RoboticCat(String name, String description, int happiness, int health, int oilLevel) {
		super(name, description, happiness, health);
		this.oilLevel = oilLevel;

	}

	public RoboticCat(String name, String description) {
		super(name, description);
		oilLevel = random.nextInt(100) + 1;
	}

	@Override
	public void oilPets() {
		if (oilLevel <= 20) {
			oilLevel += 80;
		}
		if (health <= 50) {
			health += 50;
		}
	}

	public int getOilLevel() {
		return oilLevel;
	}

	@Override
	public void tick() {
		selfCare = random.nextInt(50) + 1;

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
		if (oilLevel >= 10) {
			oilLevel -= 10;
		}
	}

	@Override
	public String toString() {
		return super.toString() + this.oilLevel;
	}
}
