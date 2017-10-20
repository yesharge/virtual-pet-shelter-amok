package VirtualPetTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VirtualPets.OrganicCat;
import VirtualPets.OrganicDog;
import VirtualPets.OrganicMethods;
import VirtualPets.RoboticCat;
import VirtualPets.RoboticMethods;
import VirtualPets.VirtualPet;
import VirtualPets.VirtualPetShelter;

public class VirtualPetTest {
	@Test
	public void testIfOrganicDogWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicDog(new OrganicDog(null,null,0,0,0,0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}
	@Test
	public void testIfOrganicCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat(null,null,0,0,0,0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}
	@Test
	public void testIfOrganicCatandOrganicDogWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat(null,null,0,0,0,0));
		underTest.addOrganicDog(new OrganicDog("1",null,0,0,0,0));
		int check = underTest.getSize();
		assertEquals(2, check);
	}
	@Test
	public void testIfRoboticCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addRoboticCat(new RoboticCat(null,null,0,0,0));
		int check = underTest.getSize();
		assertEquals(1, check);
	}
	@Test
	public void testIfRoboticCatandOrganicCatWasAdded() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addRoboticCat(new RoboticCat(null,null,0,0,0));
		underTest.addOrganicCat(new OrganicCat("1",null,0,0,0,0));
		int check = underTest.getSize();
		assertEquals(2, check);
	}
	@Test
	public void testIfRoboticCatWasOiled() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addRoboticCat(new RoboticCat("1",null,0,0,0));
		underTest.oilAllRoboticPets();
		RoboticCat getPet = (RoboticCat) underTest.getAspecificPet("1");
		int check = getPet.getOilLevel();
		assertEquals(check,80);
		
		}
	@Test
	public void testIfAllOrganicPetsAreFed() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat("1",null,0,0,0,0));
		underTest.addOrganicDog(new OrganicDog("2",null,0,0,0,0));
		underTest.feedAllPets();
		OrganicCat getPet = (OrganicCat) underTest.getAspecificPet("1");
		int check = getPet.getHunger();
		OrganicDog getPet2 = (OrganicDog) underTest.getAspecificPet("2");
		int check2 = getPet2.getHunger();
		assertEquals(check,50);
		assertEquals(check2,50);
		
		}
	@Test
	public void testIfOrganicDogCagesAreCleaned() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicDog(new OrganicDog("1",null,0,0,0,75));
		underTest.cleanAllDogCages();
		OrganicDog getPet = (OrganicDog) underTest.getAspecificPet("1");
		int check = getPet.getWaste();
		assertEquals(check,0);
		}
	@Test
	public void testIfLitterBoxWasteIsFromAllOrganicCats() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat("1",null,0,0,0,10));
		underTest.addOrganicCat(new OrganicCat("2",null,0,0,0,10));
		underTest.fillLitterBox();
		int check = underTest.getLitterBox();
		assertEquals(check,20);
		}
	@Test
	public void testIfLitterBoxWasteEmpties() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat("1",null,0,0,0,10));
		underTest.addOrganicCat(new OrganicCat("2",null,0,0,0,10));
		underTest.fillLitterBox();
		underTest.cleanLitterBox();
		int check = underTest.getLitterBox();
		assertEquals(check,0);
		}
	@Test
	public void testIfHealthAndHappinessLevelOfOrganicCatsDecreasesDueToLitterBox() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addOrganicCat(new OrganicCat("1",null,10,10,0,80));
		underTest.fillLitterBox();
		underTest.reduceHealthAndHappinessLevelOfOrganicCats();
		OrganicCat getPet = (OrganicCat) underTest.getAspecificPet("1");
		int check = getPet.getHappiness();
		int check2 = getPet.getHealth();
		assertEquals(check,0);
		assertEquals(check2,0);
		}
	
	
}
	


