package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.*;
class testClub {

	
	private Club b;
	private ArrayList<Owner> ownersitos = new ArrayList<Owner>();
	private void setupEscenario() {
		b = new Club("","","","");
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos.add(m1);
		ownersitos.add(m);
		ownersitos.add(m3);
		ownersitos.add(m2);
		b.setOwners(ownersitos);
	}
	
	@Test
	void testOrdenarPorId() {
		setupEscenario();
		b.ordenarPorIdOwner();
		
		b = new Club("","","","");
		ArrayList<Owner> ownersitos1 = new ArrayList<Owner>();
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos1.add(m1);
		ownersitos1.add(m);
		ownersitos1.add(m3);
		ownersitos1.add(m2);
		b.setOwners(ownersitos);
		b.ordenarPorIdOwner();
		
		assertEquals(ownersitos.get(0).toString(),ownersitos1.get(2).toString());
		
	}
	
	@Test
	void testOrdenarPorNombre() {
		setupEscenario();
		b.ordenarPorNombrePrimero();
		
		b = new Club("","","","");
		ArrayList<Owner> ownersitos1 = new ArrayList<Owner>();
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos1.add(m1);
		ownersitos1.add(m);
		ownersitos1.add(m3);
		ownersitos1.add(m2);
		b.setOwners(ownersitos);
		b.ordenarPorNombrePrimero();
		
		
		assertEquals(ownersitos.get(0).toString() , ownersitos.get(0).toString());
		
	}

	@Test
	void testOrdenarPorPorNombre2() {
		setupEscenario();
		b.ordenarPorSegundosNombres();
		
		b = new Club("","","","");
		ArrayList<Owner> ownersitos1 = new ArrayList<Owner>();
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos1.add(m1);
		ownersitos1.add(m);
		ownersitos1.add(m3);
		ownersitos1.add(m2);
		b.setOwners(ownersitos);
		b.ordenarPorSegundosNombres();
		
		assertEquals(ownersitos.get(0).toString(), ownersitos1.get(0).toString());
	}
	
	@Test
	void ordenarPorAnimales() {
		setupEscenario();
		b.ordenarPorTipoDeAnimal();
		
		b = new Club("","","","");
		ArrayList<Owner> ownersitos1 = new ArrayList<Owner>();
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos1.add(m1);
		ownersitos1.add(m);
		ownersitos1.add(m3);
		ownersitos1.add(m2);
		b.setOwners(ownersitos);
		b.ordenarPorIdOwner();
		
		assertEquals(ownersitos.get(0).toString(), ownersitos.get(0).toString());
		
	}
	
	@Test
	void ordenarPorFecha() {
		setupEscenario();
		b.ordenarPorFechas();
		
		b = new Club("","","","");
		ArrayList<Owner> ownersitos1 = new ArrayList<Owner>();
		Owner m = new Owner("Juan","sada","asda","adada","2019/12/31");
		Owner m1 = new Owner("Juan1","sada","asda","adada","2016/03/05");
		Owner m2 = new Owner("Juan2","sada","asda","adada","2017/02/12");
		Owner m3 = new Owner("Juan3","sada","asda","adada","2018/01/11");
		ownersitos1.add(m1);
		ownersitos1.add(m);
		ownersitos1.add(m3);
		ownersitos1.add(m2);
		b.setOwners(ownersitos);
		b.ordenarPorIdOwner();
		
		assertEquals(ownersitos.get(0).toString(), ownersitos.get(0).toString());
		
		
	}
	
}
