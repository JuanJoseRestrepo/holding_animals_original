package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.*;

class Holding {
	
	private Holding hol;
	private ArrayList<Club> clubs;
	
	
	private void setupEscenario() {
		Club c = new Club("023131312","Coca Cola","2080/09/10","Lobo");
		Club d = new Club("222223321","IssacCompany","2030/04/16","Obo");
		Club e = new Club("444214132","NegroCompany","2014/08/01","Wick");
		Club t = new Club("332131313","Isabella_Holding","2004/09/12","Kanguro");
		Club y = new Club("112313132","KevinClub","2002/07/14","Vampiro");
		Club x = new Club("999854213","LegionLenovo","2000/09/13","Jhon Wick");
		Club u = new Club("203215645","RazerCompany","2019/12/03","Portil");
		Club i = new Club("632112351","JhonJairoS.A","2013/04/12","Buhoo");
		
		clubs.add(c);
		clubs.add(d);
		clubs.add(e);
		clubs.add(t);
		clubs.add(y);
		clubs.add(x);
		clubs.add(u);
		clubs.add(i);
		
	}
	
	
	
	@Test
	void test() {
		setupEscenario();
		
		
		
		
	}

}
