package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Holding implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Club> clubs;
	private String archives;
	public Holding(String archives) {
		this.archives = archives;
		clubs = loadFileMocaForClub();
		onlyOneTimeLoadOwners();
		onlyOneTimeLoadPets();
		
	
	}
	
	
	public ArrayList<Club> getClubs() {
		return clubs;
	}


	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}


	public void onlyOneTimeLoadOwners() {
		
		for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getOwners().isEmpty()) {
			loadOwner();
			loadPets();
		}
	}
		
		
	}
	
	public void onlyOneTimeLoadPets() {
		
		for(int i = 0; i < clubs.size();i++) {
			for(Owner own: clubs.get(i).getOwners()) {
				if(own.getPets().isEmpty()) {
					loadPet();
			}
	}	
}
		
}

	
	public void findClubWithClubAndOwnerAndPet(String idClubs,String idClien,String idPet,String petName, String gender,String typeOfPet,String bornPetDay){
		boolean t = false;
		try {
		for(int i = 0; i < clubs.size();i++) {
			if(idClubs.equals(clubs.get(i).getIdClub())) {
				clubs.get(i).searchForTheOwner(idClubs,idPet, petName, gender, typeOfPet, bornPetDay);
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No valido el id");
		}
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
}

	
	public void findClubForOwner(String idClub, String idOwner,String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		boolean t = false;
		try {
		for (int i = 0; i < clubs.size(); i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				clubs.get(i).addOwners(idOwner,ownerNames,ownerSecondNames,typeOfAnimalsPrefer,bornDay);
				 t = true;
				clubs.get(i).serializableOwner();
				}
			}
		
		if(t == false) {
				throw new errorIdClubNotFound("No valido el id");
		}
		}catch(errorIdClubNotFound e) {
			e.getCause();
		}
	}
	
	public void registerClubInTheSystem(String idClub,String nameClub,String creationDate,String typeOfAnimals) {
		
		clubs.add(new Club(idClub,nameClub,creationDate,typeOfAnimals));
	
}
		
	public void saveClub() {
		File fl = new File(archives);
		
		try {
			FileWriter fw = new FileWriter(fl.getAbsoluteFile());
			BufferedWriter bfw = new BufferedWriter(fw);
			
			for(int i = 0; i < clubs.size();i++) {
	
				bfw.write(clubs.get(i).getIdClub() + "," + clubs.get(i).getNameClub()
				+ "," + clubs.get(i).getCreationDate() + "," + clubs.get(i).getTypeOfAnimals());
				bfw.newLine();	
			}
			bfw.close();
			
			
		}catch(IOException e) {
			System.out.println("Problema de esritura en el archivo");
		}
		
		
	}
	 
	public void delatedClubWithNumber(String id) {
		
		boolean t = false;
		 
		try {
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(id)) {
				clubs.remove(clubs.get(i));
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No valido el id");
		}
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
}
	
	
	public void delatedClubWithName(String name) {
		
		boolean t = false;
		try {
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getNameClub().equals(name)) {
				clubs.remove(clubs.get(i));
				t = true;
			}	
		}
		
		if(t == false) {
				throw new errorNameNotFound("No valido el id");
		}
		
	}catch(errorNameNotFound e) {
		e.getCause();
	}
}
	
	public void delatedWithClubOwner(String idClubsi, String nombreOwner,String apellidoParaco) {
		
		boolean t = false;
		
		try {
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				clubs.get(i).delatedOwner(nombreOwner,apellidoParaco);
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No valido el id");
		}
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
}
	
	public void delatedWithClubOwnerNumber(String idClubsi, String idOwner) {
		boolean t = false;
		try {
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				clubs.get(i).delatedOwnerNumber(idOwner);
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No valido el id");
		}
		
		}catch(errorIdClubNotFound e) {
			e.getCause();
		}
	}
	
	public void delatedWithClubWithPet(String idClubsi, String idOwner,String namePet) {
		boolean t = false;
		try {
		for(int i = 0; i < clubs.size();i++) {
			if(clubs.get(i).getIdClub().equals(idClubsi)) {
				clubs.get(i).delatedPetWithName(idOwner, namePet);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdClubNotFound("No valido el id");
		}
		
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
		 
}
	
	public void delatedWithClubWithPetid(String idClubsi,String idOwner,String idPet) {
		boolean t = false;
		try {
			for(int j = 0; j < clubs.size();j++) {
				if(clubs.get(j).getIdClub().equals(idClubsi)) {
					clubs.get(j).delatedPetWithIdPet(idOwner, idPet);
				}
			}
			if(t == false) {
				throw new errorNameNotFound("No se encontro el name");
			}
			
		}catch(errorNameNotFound e){
			e.getCause();
		}
		
		
	}
	
	public ArrayList<Club> loadFileMocaForClub() {
		
		ArrayList<Club> clubsitos = new ArrayList<Club>();
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		
		String a;
		while((a =br.readLine()) != null){
			String[] b = a.split(",");
			clubsitos.add(new Club(b[0], b[1], b[2], b[3]));
		}
		br.close();
		
		}catch(IOException e) {
			e.getCause();
		}
		
		return clubsitos;
		
	}
	
		
	public String toString() {
		String msj = "";
		
		return msj;
	}
		
	
	
	public void ordenarClubesPorId() {
		
		
		for(int i = 1; i < clubs.size();i++) {
			
			for(int j = i; j > 0 && clubs.get(j-1).compareTo(clubs.get(j)) > 0; j--) {
				Club temp = clubs.get(j);
				clubs.set(j,clubs.get(j-1));
				clubs.set(j-1,temp);
			} 
				
		} 
		
	}
	
	public void ordenarClubesPorNombre() {
		
		for (int i = 0; i < clubs.size(); i++) {
			Club menor = clubs.get(i);
			int posicion = i;
			
			for(int j = i + 1; j < clubs.size();j++) {
				
				if(clubs.get(j).compare(menor,clubs.get(j)) < 0) {
					
					menor = clubs.get(j);
					posicion = j;
					
				}
				
				
			}
			
			Club temp = clubs.get(i);
			clubs.set(i,menor);
			clubs.set(posicion,temp);
			
		}
		
		
	}
	
	public String mostrarInfoOrdenado() {
		String msj = "";
		
		for(int i = 0; i < clubs.size();i++) {
			msj+= "\n " + clubs.get(i).toString();
		}
		
		return msj;
	}
	
	public void ordenarFechas() {
		
		for(int i = 0; i < clubs.size();i++) {
			
			for(int j = 0; j < clubs.size()-1;j++) {
				if(clubs.get(j).compareOrdenarPorFecha(clubs.get(j+1)) > 0) {
					Club temp = clubs.get(j);
					clubs.set(j, clubs.get(j+1));
					clubs.set(j+1, temp);	
				}
			}
			
		}
		
	}
	

public void loadOwner(){
	
	File fl = new File("Ownersitos.csv");
	
	try {
	FileReader fi = new FileReader("Ownersitos.csv");
	BufferedReader br = new BufferedReader(fi);
	for(int i = 0; i < clubs.size();i++) {
		int j = 0;
		String msj = br.readLine();
		while((msj) != null && j < 10) {
			String[] b = msj.split(",");
			clubs.get(i).addOwners(b[0],b[1],b[2],b[3],b[4]);
			j++;
			msj = br.readLine();
		}
		
} 

	br.close();
	fi.close();
	} catch (FileNotFoundException e) {
		e.getCause();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public void loadPet(){

	File fl = new File("Pets.csv");
	
	try {
	FileReader fi = new FileReader(fl.getAbsoluteFile());
	BufferedReader br = new BufferedReader(fi);
	String msj;
	for(Club clubsitos:clubs) {
		for(Owner owner: clubsitos.getOwners()) {
			int j = 0;
			while((msj = br.readLine())!= null && j < 4) {
				String[] b = msj.split(",");
				owner.addAnimals(b[0],b[1],b[2],b[3],b[4]);
				j++; 
				msj = br.readLine();
			}	
	}

	}
	br.close();
	fi.close();
	} catch (FileNotFoundException e) {
		
		e.getCause();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}
		

public void ordenateTypeOfAnimals() {
	for(int i = 0; i < clubs.size();i++) {
		for(int j = 0; j < clubs.size()-1-i;j++){
			if(clubs.get(j).compareTypeOfAnimals(clubs.get(j+1))> 0) {
				Club temp = clubs.get(j);
				clubs.set(j,clubs.get(j+1));
				clubs.set(j+1,temp);
			}	
		}	
	}	
}

public void getMethodsSortWithTypeOfAnimals() {
	
	for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ordenarPorTipoDeAnimal();
	}
	
}

public void getMethodsSortWithCode() {
	
	for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ordenarPorIdOwner();
		}
}
	
public void getMethodsSortWithSecondNames() {
	
	for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ordenarPorSegundosNombres();
		}
}

public void getMethodsSortWithName() {
	for (int i = 0; i < clubs.size(); i++) {
		
			clubs.get(i).ordenarPorNombrePrimero();
	}
}

public void getMethodsSortWithDates() {
	for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).ordenarPorFechas();

	}
}

public Date formatTheDateOfThis(String dateOfThis) {
	Date inicialDate = null;
	SimpleDateFormat dateOfThis1 = new SimpleDateFormat("yyyy/mm/dd");
	
	try {
		inicialDate = dateOfThis1.parse(dateOfThis);
	}catch(ParseException e) {
		e.getCause();
	}
	
	
	return inicialDate;
} 

public String mostrarInfo() {
	String msj = " ";
	for(int i = 0; i < clubs.size();i++) {
			msj += " " +clubs.get(i).mostrarInfoOrdenado();
		}
	
	return msj;
}

public void ordenarClubesPorNumeroDeDueños() {
	
	for(int i = 1; i < clubs.size();i++) {
		for(int j = i; j > 0 && clubs.get(j-1).compararPorTamaño(clubs.get(j-1),clubs.get(j)) > 0; j--) {
			Club temp = clubs.get(j);
			clubs.set(j,clubs.get(j-1));
			clubs.set(j-1,temp);
		}
			
	} 
}
	
public String mostrarInfoOrdenado3() {
	String msj = "";
	
	for(int j = 0; j < clubs.size();j++) {
		msj += clubs.get(j).mostrarInformacion();
	}
	return msj;
}

public void ordenarPorNombrePets() {
	
	for(int j = 0; j < clubs.size();j++) {
		clubs.get(j).getMethodsPetsName();
	}
}

public void ordenarPorDates() {
	
	for(int i = 0; i < clubs.size();i++) {
		clubs.get(i).getMethodsDatesPets();
	}
	
}

public void ordenarPorGender() {
	for(int i = 0; i < clubs.size();i++) {
		clubs.get(i).getMethodsGender();
	}
	
}

public void ordenarPorPetsId() {
	for(int i = 0; i < clubs.size();i++) {
		clubs.get(i).getMethodsPetsId();
	}
}

public void ordenarTipoDeMascota() {
	for(int i = 0; i < clubs.size();i++) {
		clubs.get(i).getMethodsPreferAnimal();
	}
}
		
}//Final
	

	

