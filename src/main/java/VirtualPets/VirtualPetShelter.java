package VirtualPets;

import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;

public class VirtualPetShelter {
	Scanner input = new Scanner(System.in);
	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int shelterLitterBox = 0;

	public Collection<VirtualPet> getPets() {
		return pets.values();
	}

	public void addOrganicDog(OrganicDog pet) {
		pets.put(pet.getName(), pet);
	}

	public void addOrganicCat(OrganicCat pet) {
		pets.put(pet.getName(), pet);
	}

	public void addRoboticCat(RoboticCat pet) {
		pets.put(pet.getName(), pet);
	}

	public void addRoboticDog(RoboticDog pet) {
		pets.put(pet.getName(), pet);
	}

	public VirtualPet getAspecificPet(String name) {
		return pets.get(name);

	}

	public boolean checkIfAPetexists(String name) {
		if (!pets.containsKey(name)) {
			return false;
		}
		return true;
	}

	public void adoptAPet(String name) {
		pets.remove(name);
	}

	public void feedAllPets() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicMethods) {
				((OrganicMethods) pet).feedMe();
			}
		}
	}

	public void oilAllRoboticPets() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof RoboticMethods)
				((RoboticMethods) pet).oilPets();
		}
	}

	public void playWithASpecificPet(String name) {
		for (VirtualPet pet : pets.values()) {
			if (pets.containsKey(name)) {
				pet.playWithMe();
			}
		}
	}

	public void displayPetTitle() {
		System.out.println("This is the status of your pets:");
		System.out.println("Name\t|Hunger\t|Bored\t|Thirst\t|Tiredness");
		System.out.println("-------\t-------\t-------\t-------\t-----------");
		for (VirtualPet pet : pets.values()) {
			System.out.println(pet);
		}

	}

	public void displayPetNameAndDescriptions() {
		System.out.println("Name\t|Description");
		System.out.println("-------\t-----------");
		for (VirtualPet pet : pets.values()) {
			pet.playWithPetDisplay();
		}
	}

	public void tick() {
		for (VirtualPet pet : pets.values()) {
			pet.tick();
		}
	}

	public int getSize() {
		return pets.size();
	}

	public void fillLitterBox() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicCat) {
				shelterLitterBox += ((OrganicCat) pet).getWaste();
			}
		}

	}

	public void cleanLitterBox() {
		shelterLitterBox = 0;
	}

	public int getLitterBox() {
		return shelterLitterBox;
	}

	public void reduceHealthAndHappinessLevelOfOrganicCats() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicCat) {
				if (shelterLitterBox > 70) {
					if (pet.happiness >= 10) {
						pet.happiness -= 10;
					}
					if (pet.health >= 10) {
						pet.health -= 10;
					}
				}
			}
		}
	}

	public void cleanAllDogCages() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicDog) {
				((OrganicDog) pet).cleanCage();
			}
		}
	}
}
