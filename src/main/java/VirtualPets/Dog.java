package VirtualPets;

public class Dog extends VirtualPet{

	
	public Dog(String name, String description, int happiness, int health) {
	super(name,description,happiness,health);
	}
	public Dog(String name, String description) {
		super(name,description);
	}
	
	public void walkDogs() {
		if (happiness >= 25) {
			happiness+=25;
		}
		}
	
}
