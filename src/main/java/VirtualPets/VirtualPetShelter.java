package VirtualPets;

import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.HashMap;

public class VirtualPetShelter {
	Scanner input = new Scanner(System.in);
	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	private int shelterLitterBox = 0;
	private int count = 0;

	public Collection<VirtualPet> getPets() {
		return pets.values();
	}

	public void addHomelessPet(VirtualPet pet) {
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

	public void randomMessages() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicDog) {
				if (((OrganicDog) pet).getWaste() > 90) {
					System.out.println("You have at least one dog whose cage needs cleaning.");
					break;
				}
			}

		}
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof RoboticCat) {
				if (((RoboticCat) pet).getOilLevel() < 20) {
					System.out.println("You have at least one Robotic Pet whose oil is getting low.");
					break;
				}
			} else if (pet instanceof RoboticDog) {
				if (((RoboticDog) pet).getOilLevel() < 20) {
					System.out.println("You have at least one Robotic Pet whose oil is getting low.");
					break;
				}
			}
		}
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicCat) {
				if (((OrganicCat) pet).getHunger() < 40) {
					System.out.println("You have at least one Organic Pet who is hungry.");
					break;
				}
			} else if (pet instanceof OrganicDog) {
				if (((OrganicDog) pet).getHunger() < 40) {
					System.out.println("You have at least one Organic Pet who is hungry.");
					break;
				}
			}
		}
		if ((shelterLitterBox / count) >= 50 && (shelterLitterBox / count) < 75) {
			System.out.println("Your litter box is at least half full.");
		} else if ((shelterLitterBox / count) >= 75 && (shelterLitterBox / count) <= 85) {
			System.out.println("Your litter box is at least 75% full.");
		} else if ((shelterLitterBox / count) > 85) {
			System.out.println("Your litter box is full. Please clean it.");
		}
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
		System.out.println();
		System.out.println("This is the status of your Organic pets:");
		System.out.println("Name\t|Happy\t|health\t|Hunger\t|Waste");
		System.out.println("-------\t-------\t-------\t-------\t-------");
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicMethods) {
				System.out.println(pet);
			}
		}
		System.out.println();
		System.out.println("This is the status of your Robotic pets:");
		System.out.println("Name\t|Happy\t|health\t|Oil Level");
		System.out.println("-------\t-------\t-------\t----------");
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof RoboticMethods) {
				System.out.println(pet);
			}
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
				count++;
			}
		}
	}

	public void cleanLitterBox() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof OrganicCat) {
				((OrganicCat) pet).reduceWaste();
			}
		}
		shelterLitterBox = 0;
	}

	public int getLitterBox() {

		if (count > 0) {
			return shelterLitterBox / count;
		}
		return 0;
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
		System.out.println("Smells a lot better!");
	}

	public void walkAllDogs() {
		for (VirtualPet pet : pets.values()) {
			if (pet instanceof Dog) {
				((Dog) pet).walkDogs();
			}
		}
	}

}
