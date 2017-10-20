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
	}

	public int getOilLevel() {
		return oilLevel;
	}

}
