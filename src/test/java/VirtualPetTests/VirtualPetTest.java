package VirtualPetTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VirtualPets.OrganicCat;
import VirtualPets.OrganicDog;
import VirtualPets.RoboticCat;
import VirtualPets.RoboticDog;
import VirtualPets.VirtualPetShelter;

public class VirtualPetTest {
	@Test
	public void testIfOrganicDogWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicDog(null, null, 0, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}

	@Test
	public void testIfOrganicCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat(null, null, 0, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}

	@Test
	public void testIfOrganicCatandOrganicDogWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat(null, null, 0, 0, 0, 0));
		underTest.addHomelessPet(new OrganicDog("1", null, 0, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(2, check);
	}

	@Test
	public void testIfRoboticCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new RoboticCat(null, null, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}

	@Test
	public void testIfRoboticCatandOrganicCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new RoboticCat(null, null, 0, 0, 0));
		underTest.addHomelessPet(new OrganicCat("1", null, 0, 0, 0, 0));
		int check = underTest.getSize();
		assertEquals(2, check);
	}

	@Test
	public void testIfRoboticCatWasOiled() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new RoboticCat("1", null, 0, 0, 0));
		underTest.oilAllRoboticPets();
		RoboticCat getPet = (RoboticCat) underTest.getAspecificPet("1");
		int check = getPet.getOilLevel();
		assertEquals(check, 80);

	}

	@Test
	public void testIfAllOrganicPetsAreFed() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat("1", null, 0, 0, 0, 0));
		underTest.addHomelessPet(new OrganicDog("2", null, 0, 0, 0, 0));
		underTest.feedAllPets();
		OrganicCat getPet = (OrganicCat) underTest.getAspecificPet("1");
		int check = getPet.getHunger();
		OrganicDog getPet2 = (OrganicDog) underTest.getAspecificPet("2");
		int check2 = getPet2.getHunger();
		assertEquals(check, 50);
		assertEquals(check2, 50);
	}

	@Test
	public void testIfAllCagesEmptiesForOrganicDogs() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicDog("1", null, 0, 0, 0, 10));
		underTest.addHomelessPet(new OrganicDog("2", null, 0, 0, 0, 20));
		underTest.cleanAllDogCages();
		OrganicDog getPet = (OrganicDog) underTest.getAspecificPet("1");
		int check = getPet.getWaste();
		getPet = (OrganicDog) underTest.getAspecificPet("2");
		int check2 = getPet.getWaste();
		assertEquals(check, 0);
		assertEquals(check2, 0);
	}

	@Test
	public void testIfLitterBoxWasteIsFromAllOrganicCats() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat("1", null, 0, 0, 0, 10));
		underTest.addHomelessPet(new OrganicCat("2", null, 0, 0, 0, 10));
		underTest.fillLitterBox();
		int check = underTest.getLitterBox();
		assertEquals(check, 10);
	}

	@Test
	public void testIfLitterBoxWasteEmpties() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat("1", null, 0, 0, 0, 10));
		underTest.addHomelessPet(new OrganicCat("2", null, 0, 0, 0, 10));
		underTest.fillLitterBox();
		underTest.cleanLitterBox();
		int check = underTest.getLitterBox();
		assertEquals(check, 0);
	}

	@Test
	public void testIfHealthAndHappinessLevelOfOrganicCatsDecreasesDueToLitterBox() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicCat("1", null, 10, 10, 0, 80));
		underTest.fillLitterBox();
		underTest.reduceHealthAndHappinessLevelOfOrganicCats();
		OrganicCat getPet = (OrganicCat) underTest.getAspecificPet("1");
		int check = getPet.getHappiness();
		int check2 = getPet.getHealth();
		assertEquals(check, 0);
		assertEquals(check2, 0);
	}

	@Test
	public void testIfAllDogsAreWalked() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicDog("1", null, 10, 10, 0, 80));
		underTest.addHomelessPet(new RoboticDog("2", null, 10, 10, 10));
		underTest.walkAllDogs();
		OrganicDog getPet = (OrganicDog) underTest.getAspecificPet("1");
		RoboticDog getPet2 = (RoboticDog) underTest.getAspecificPet("2");
		int check = getPet.getHappiness();
		int check2 = getPet2.getHappiness();
		assertEquals(check, 35);
		assertEquals(check2, 35);
	}

	@Test
	public void testIfOrganicDogWalkedWillDecreaseWasteLevels() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addHomelessPet(new OrganicDog("1", null, 10, 10, 0, 80));
		underTest.walkAllDogs();
		OrganicDog getPet = (OrganicDog) underTest.getAspecificPet("1");
		int check = getPet.getWaste();
		assertEquals(check, 65);
	}
}
