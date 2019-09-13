package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;

class testMascota {
	private Pet pet;
	
	private void setupEscenario() {
		pet = new Pet("123131","Jhon","Male","Perro","13/09/2019");
	}
	@Test
	void testMostrarNombre() {
		setupEscenario();
		Pet p2 = new Pet("123123","Jun","Female","Cat","14/09/1029");
		
		assertTrue(pet.compareTo(p2)<0,"menor");
	}
	
	@Test
	void testMostrarFechas() {
		setupEscenario();
		Pet p2 = new Pet("123123","Jun","Female","Cat","14/09/1029");
		
		assertTrue(pet.compareBornDayPet(p2)>0,"menor");
	}
	
	@Test
	void testMostrarId() {
		setupEscenario();
		Pet p2 = new Pet("123123","Jun","Female","Cat","14/09/1029");
		
		assertTrue(pet.compare(pet,p2)>0,"menor");
	}
	
	@Test
	void testMostrarGender() {
		setupEscenario();
		Pet p2 = new Pet("123123","Jun","Female","Cat","14/09/1029");
		
		assertTrue(pet.compareGender(pet,p2)>0,"menor");
	}
	
	@Test
	void testMostrarTipoDeAnimal() {
		setupEscenario();
		Pet p2 = new Pet("123123","Jun","Female","Cat","14/09/1029");
		
		assertTrue(pet.compareTypeOfPet(p2)>0,"menor");
	}

}
