package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import model.*;

class testOwner {
	private Owner own;
	private ArrayList<Pet> petsitos = new ArrayList<Pet>();
	
	private void setupEscenario() {
		own = new Owner("","","","","");
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos.add(p3);
		petsitos.add(p1);
		petsitos.add(p2);
		petsitos.add(p4);
		own.setPets(petsitos);
	}
	
	@Test
	void testOrdenarPorNombrePet() {
		setupEscenario();
		own.ordenarPorNombres();
		
		own = new Owner("","","","","");
		ArrayList<Pet> petsitos1 = new ArrayList<Pet>();
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos1.add(p3);
		petsitos1.add(p1);
		petsitos1.add(p2);
		petsitos1.add(p4);
		own.setPets(petsitos1);
		own.ordenarPorNombres();
		
		assertEquals(petsitos.get(0).toString(),petsitos1.get(0).toString());
		
	}

	@Test
	void testOrdenarPorId() {
		setupEscenario();
		own.ordenarPorIdPet();
		
		own = new Owner("","","","","");
		ArrayList<Pet> petsitos1 = new ArrayList<Pet>();
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos1.add(p3);
		petsitos1.add(p1);
		petsitos1.add(p2);
		petsitos1.add(p4);
		own.setPets(petsitos1);
		own.ordenarPorIdPet();
		
		assertEquals(petsitos.get(0).toString(),petsitos1.get(0).toString());
	}
	
	@Test 
	void testOrdenarPorGenero() {
		setupEscenario();
		own.ordenarPorGenero();
		
		own = new Owner("","","","","");
		ArrayList<Pet> petsitos1 = new ArrayList<Pet>();
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos1.add(p3);
		petsitos1.add(p1);
		petsitos1.add(p2);
		petsitos1.add(p4);
		own.setPets(petsitos1);
		own.ordenarPorGenero();
		
		assertEquals(petsitos.get(0).toString(),petsitos1.get(0).toString());
	}
	
	@Test
	void testOrdenarPorTipoDeAnimal() {
		setupEscenario();
		own.ordenarPorTipoDeAnimalElPet();
		
		own = new Owner("","","","","");
		ArrayList<Pet> petsitos1 = new ArrayList<Pet>();
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos1.add(p3);
		petsitos1.add(p1);
		petsitos1.add(p2);
		petsitos1.add(p4);
		own.setPets(petsitos1);
		own.ordenarPorTipoDeAnimalElPet();
		
		assertEquals(petsitos.get(0).toString(),petsitos1.get(0).toString());
	}
	
	@Test
	void testOrdenarPorFechas() {
		setupEscenario();
		own.ordenarPorFecha();
		
		own = new Owner("","","","","");
		ArrayList<Pet> petsitos1 = new ArrayList<Pet>();
		Pet p1 = new Pet("341231","Kangaro","Male","Male","9/11/2007");
		Pet p2 = new Pet("342231","Kangaro1","Female","Male","7/04/2013");
		Pet p3 = new Pet("343231","Kangaro2","Male","Male","4/09/20015");
		Pet p4 = new Pet("344231","Kangaro3","Female","","3/12/20019");
		petsitos1.add(p3);
		petsitos1.add(p1);
		petsitos1.add(p2);
		petsitos1.add(p4);
		own.setPets(petsitos1);
		own.ordenarPorFecha();
		
		assertEquals(petsitos.get(0).toString(),petsitos1.get(0).toString());
	}
	
	
}
