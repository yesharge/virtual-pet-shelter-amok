package VirtualPets;

import java.util.Random;

public class VirtualPet {
	// Instance Variables

	protected int happiness;
	protected int boredom;
	protected int tiredness;
	protected int selfCare;
	protected String name;
	protected String description;
	protected int health;

	Random random = new Random();

	// Constructor

	public VirtualPet(String name, String description, int happiness, int health) {
		this.description = description;
		this.happiness = happiness;
		this.name = name;
		this.health = health;

	}
	// overloading; more than one constructor

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		happiness = random.nextInt(100) + 1;
		health = random.nextInt(100) + 1;
		boredom = random.nextInt(100) + 1;
	}

	public String getName() {
		return name;
	}

	public void playWithMe() {
		if (happiness <= 55) {
			happiness+= 45;
		}
	}

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

	}

	public int getHappiness() {
		return happiness;
	}

	public int getHealth() {
		return health;
	}

	public void playWithPetDisplay() {
		System.out.println(name + "\t|" + description);
	}

	@Override
	public String toString() {
		return "" + this.name + "\t|" + this.happiness + "\t|" + this.health+"\t|";
	}

}
