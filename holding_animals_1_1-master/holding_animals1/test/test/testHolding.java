package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import model.Holding;
import model.Club;

import org.junit.jupiter.api.Test;

class testHolding {
	private Holding hol;
	private ArrayList<Club> clubsitos = new ArrayList<Club>();;
	
	
	private void setupEscenario() {
		
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
		
		for(int z = 1; z < clubsitos.size();z++) {
			
			for(int j = z; j > 0 && clubsitos.get(j-1).compareTo(clubsitos.get(j)) > 0; j--) {
				Club temp = clubsitos.get(j);
				clubsitos.set(j,clubsitos.get(j-1));
				clubsitos.set(j-1,temp);
			}
				
		}
	}
	
	private void setUpEscenario1() {
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
		
	}
	
	
	
	@Test
	void test() {
		setupEscenario();
		 
		assertEquals("Coca Cola",clubsitos.get(0).getNameClub());
	
	}


}
