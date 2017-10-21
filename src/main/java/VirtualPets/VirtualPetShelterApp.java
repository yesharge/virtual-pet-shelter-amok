package VirtualPets;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetShelterApp {
	static Scanner input = new Scanner(System.in);
	static VirtualPetShelter homelessPets = new VirtualPetShelter();
	static String userInput;

	public static void main(String[] args) {

		Random random = new Random();
		String menuInput = null;
		String continueAdmit = null;
		String removePet = null;

		VirtualPet pet1 = new OrganicCat("Cindy", "Always loses her collar", random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet2 = new OrganicDog("Aurora", "Loves to sleep", random.nextInt(100) + 1, random.nextInt(100) + 1,
				random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet3 = new RoboticCat("Jasmine", "Collar has diamond, but no information. Found in an ally",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);
		VirtualPet pet4 = new RoboticDog("Tiana", "Notorious for rummaging through restaurant kitchens",
				random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1);

		homelessPets.addHomelessPet(pet1);
		homelessPets.addHomelessPet(pet2);
		homelessPets.addHomelessPet(pet3);
		homelessPets.addHomelessPet(pet4);

		System.out.println("Thank you for volunteering at Yesharge's Virtual Pet Shelter");
		homelessPets.displayPetTitle();

		do {
			System.out.println();
			System.out.println("What would you like to do?:");
			System.out.println(
					"1.\tFeed the all organic pets\n2.\tPlay with a pet\n3.\tOil all robotic pets\n4.\tWalk all dogs\n5.\tAdmit a pet\n6.\tAdopt a pet\n7.\tDisplay the Pet Status\n8.\tClean the litter Box\n9.\tClean all dog cages\n10.\tQuit");
			menuInput = input.nextLine();

			if (menuInput.equals("1")) {
				homelessPets.feedAllPets();
				homelessPets.displayPetTitle();
				homelessPets.tick();
			} else if (menuInput.equals("2")) {
				homelessPets.displayPetNameAndDescriptions();
				System.out.println("Enter the name of the pet you would like to play with.");
				String playWithPet = input.nextLine();
				playWithPet = checkIfPetExists(playWithPet);
				homelessPets.playWithASpecificPet(playWithPet);
				System.out.println("You are playing with " + playWithPet);
				homelessPets.tick();

			} else if (menuInput.equals("3")) {
				homelessPets.oilAllRoboticPets();
				homelessPets.tick();
			} else if (menuInput.equals("4")) {
				homelessPets.walkAllDogs();
				homelessPets.tick();
			} else if (menuInput.equals("5")) {
				do {
					System.out.println("Enter the name of the pet you would like to admit:(7 Characters or less)");
					String newPetName = input.nextLine();
					while (newPetName.length() > 7) {
						System.out.println("Name is too long. Please enter a shorter name.");
						newPetName = input.nextLine();
					}
					System.out.println("Enter a description for the pet.");
					String petDescription = input.nextLine();
					System.out.println("What type of pet is this?\nEnter 1 for Organic Cat\nEnter 2 for Organic Dog"
							+ "\nEnter 3 for Robotioc Cat\nEnter 4 for Robotic Dog");
					String addPet = input.nextLine();
					if (addPet.equals("1")) {
						homelessPets.addHomelessPet(new OrganicCat(newPetName, petDescription));
					} else if (addPet.equals("2")) {
						homelessPets.addHomelessPet(new OrganicDog(newPetName, petDescription));
					} else if (addPet.equals("3")) {
						homelessPets.addHomelessPet(new RoboticCat(newPetName, petDescription));
					} else {
						homelessPets.addHomelessPet(new RoboticDog(newPetName, petDescription));
					}

					System.out.println("Would you like to admit another animal? (y/n)");
					continueAdmit = input.nextLine();
				} while (continueAdmit.equals("y"));
				homelessPets.displayPetTitle();
				homelessPets.tick();
			} else if (menuInput.equals("6")) {
				homelessPets.displayPetNameAndDescriptions();
				do {
					System.out.println("Enter the name of the pet you would like to adopt?");
					removePet = input.nextLine();
					removePet = checkIfPetExists(removePet);
					homelessPets.adoptAPet(removePet);
					System.out.println("Would you like to adopt another pet? (y/n)");
					removePet = input.nextLine();
				} while (removePet.equals("y"));
				System.out.println("Thank you for adopting a pet.");
				homelessPets.tick();
			} else if (menuInput.equals("7")) {
				homelessPets.displayPetTitle();
				homelessPets.tick();
			} else if (menuInput.equals("8")) {
				homelessPets.cleanLitterBox();
				homelessPets.tick();
			} else if (menuInput.equals("9")) {
				homelessPets.cleanAllDogCages();
				homelessPets.tick();
			}
		} while (!menuInput.equals("10"));
		input.close();
		System.exit(0);

	}

	public static String checkIfPetExists(String user) {
		user = userInput;
		while (!homelessPets.checkIfAPetexists(userInput)) {
			System.out.println("I'm sorry that pet does not exist. Re enter the pet name:");
			userInput = input.nextLine();
		}
		return userInput;
	}
}
