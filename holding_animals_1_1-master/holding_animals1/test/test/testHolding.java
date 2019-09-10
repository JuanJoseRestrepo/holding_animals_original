package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import model.Holding;
import model.Owner;
import model.Pet;
import model.Club;

import org.junit.jupiter.api.Test;

import exceptions.errorIdClubNotFound;

class testHolding {
	private Holding hol;
	private ArrayList<Club> clubsitos = new ArrayList<Club>();;
	
	
	private void setupEscenario() {
		hol = new Holding("asda");
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		
		clubsitos.add(c);
		clubsitos.add(d);
		clubsitos.add(e);
		clubsitos.add(t);
		clubsitos.add(y);
		clubsitos.add(x);
		clubsitos.add(u);
		clubsitos.add(i);
		
		hol.setClubs(clubsitos);
		
				
		}
	
	private void setupEscenario2() {
		hol = new Holding("asdad");
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		
		clubsitos.add(c);
		clubsitos.add(d);
		clubsitos.add(e);
		clubsitos.add(t);
		clubsitos.add(y);
		clubsitos.add(x);
		clubsitos.add(u);
		clubsitos.add(i);
		
		ArrayList<Owner> own = new ArrayList<Owner>();
		Owner o = new Owner("12313","1231321","123131","1231231","1231");
		Owner o1 = new Owner("123134","12313214","1231314","12312314","12314");
		own.add(o);
		own.add(o1);
		
		ArrayList<Pet> pets1 = new ArrayList<Pet>();
		Pet pet1 = new Pet("Perrito","Perrito","Perrito","Perrito","Perrito");
		Pet pet2 = new Pet("Perrito1","Perrito1","Perrito1","Perrito1","Perrito1");
		
		hol.setClubs(clubsitos);
		hol.getClubs().get(0).setOwners(own);
		hol.getClubs().get(0).getOwners().get(0).setPets(pets1);
	}
		
	@Test
	void ordenarClubsPorIdTest() {
		setupEscenario();
		hol.ordenarClubesPorId();
		hol = new Holding("asdaa");
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y);
		tmp.add(x);
		tmp.add(u);
		tmp.add(i);
		hol.setClubs(tmp);
		hol.ordenarClubesPorId();
		
		assertEquals(clubsitos.get((clubsitos.size()-1)).toString(), tmp.get((tmp.size()-1)).toString());
		
	}
	
	@Test
	void testIdTestClub() {
		setupEscenario();
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131311","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223324","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214134","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131314","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313134","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854214","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215644","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112354","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y);
		tmp.add(x);
		tmp.add(u);
		tmp.add(i);
		hol.setClubs(tmp);
		if(clubsitos == tmp) {
			fail("Esta malo puesto que deben ser diferentes");
		}
	}
	
	@Test
	void testOrdenarClubsPorNombre() {
		setupEscenario();
		hol.ordenarClubesPorNombre();
		
		hol = new Holding("asdaaa");
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y);
		tmp.add(x);
		tmp.add(u);
		tmp.add(i);
		hol.setClubs(tmp);
		hol.ordenarClubesPorNombre();
		
		
		assertEquals(clubsitos.get((clubsitos.size()-1)).toString(),tmp.get((tmp.size()-1)).toString());
	}
	
	@Test
	void testOrdenarFechas() {
		setupEscenario();
		hol.ordenarFechas();
		hol = new Holding("asdaaaa");
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y); 
		tmp.add(x);
		tmp.add(u);
		tmp.add(i); 
		hol.setClubs(tmp);
		hol.ordenarFechas();	 
		
		assertFalse(clubsitos.get((clubsitos.size()-1)).toString() == tmp.get((tmp.size()-1)).toString(),"No son iguales");
		
	}
	
	@Test
	void testOrdenateAnimals() {
		setupEscenario();
		hol.ordenateTypeOfAnimals();
		hol = new Holding("asdaaaa");
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y); 
		tmp.add(x);
		tmp.add(u);
		tmp.add(i); 
		hol.setClubs(tmp);
		hol.ordenateTypeOfAnimals();
		
		assertEquals(clubsitos.get((clubsitos.size()-1)).toString(),tmp.get((clubsitos.size()-1)).toString());
		
	} 
	
	@Test
	void testOrdenarPorNumeroDeDueños() {
		setupEscenario();
		hol.ordenarClubesPorNumeroDeDueños();
		hol = new Holding("asdaaaa");
		ArrayList<Club> tmp = new ArrayList<Club>();
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		tmp.add(c);
		tmp.add(d);
		tmp.add(e);
		tmp.add(t);
		tmp.add(y); 
		tmp.add(x);
		tmp.add(u);
		tmp.add(i); 
		hol.setClubs(tmp);
		hol.ordenarClubesPorNumeroDeDueños();
		
		assertEquals(clubsitos.get((clubsitos.size()-1)).toString(),tmp.get((clubsitos.size()-1)).toString());

	} 
	
	@Test
	void testBinarioForName() {
		setupEscenario();
		hol.ordenarClubesPorNombre();
		String msj = hol.searchBinariesForDate("KveinClub");
		assertEquals(clubsitos.get(4).getNameClub(), msj);
	}
	
	@Test
	void testBinaryForId() {
		setupEscenario();
		
		String msj = hol.searchBinariesForId("222223321");
		assertEquals(clubsitos.get(4).getIdClub(), msj);
	} 
	
	@Test
	void testTradicional() {
		setupEscenario();
		
		String msj = hol.searchBinariesForIdCase1("222223321");
		assertEquals(clubsitos.get(4).getIdClub(), msj);
	}
	
	@Test
	void testTradicional1() {
		setupEscenario();
		
	}
	

}
