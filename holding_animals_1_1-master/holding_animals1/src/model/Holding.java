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

import exceptions.errorIdClubNotFound;
import exceptions.errorIdOwner;
import exceptions.errorNameNotFound;


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
		
		System.out.println("---------PRIMERO----------");
		for(Club clubsitos:clubs) {
			System.out.println("------------------------");
			System.out.println(clubsitos.toString());
			System.out.println("------------------------");
			for(Owner owner: clubsitos.getOwners()) {
				System.out.println("////////////////////////////");
				System.out.println(owner.toString());
				System.out.println("////////////////////////////");
				for(Pet pet: owner.getPets()) {
					System.out.println("*************************");
					System.out.println(pet.toString());
					System.out.println("*************************");
				}
			}
		}
		System.out.println("---------FINAL----------");
		
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
			loadPet();
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
	saveClub();
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
		saveClub();
	}catch(errorNameNotFound e) {
		e.getCause();
	}
	saveClub();	
}
	
	public void delatedWithClubOwner(String idClubsi, String nombreOwner,String apellidoParaco) {
		
		boolean t = false;
		
		try {
		for(int i = 0; i < clubs.size() && !t;i++) {
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
		for(int i = 0; i < clubs.size() && !t;i++) {
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
		for(int i = 0; i < clubs.size() && !t;i++) {
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
			for(int j = 0; j < clubs.size() && !t;j++) {
				if(clubs.get(j).getIdClub().equals(idClubsi)) {
					clubs.get(j).delatedPetWithIdPet(idOwner, idPet);
					t = true;
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
				
				if(clubs.get(j).compare(menor,clubs.get(j)) > 0) {
					
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
	
	File fl = new File("files\\Ownersitos.csv");
	
	try {
	FileReader fi = new FileReader(fl);
	BufferedReader br = new BufferedReader(fi);
	for(int i = 0; i < clubs.size();i++) {
		int j = 0;
		String msj = br.readLine();
		while((msj) != null && j < 100) {
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

	File fl = new File("files\\Pets.csv");
	
	try {
	FileReader fi = new FileReader(fl.getAbsoluteFile());
	BufferedReader br = new BufferedReader(fi);
	String msj;
	for(Club clubsitos:clubs) {
		for(Owner owner: clubsitos.getOwners()) {
			int j = 0;
			while((msj = br.readLine())!= null && j < 2) {
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

public void getMethodsSortWithTypeOfAnimals(String idClubsi) {
	boolean t = false;
	try {
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			clubs.get(i).ordenarPorTipoDeAnimal();
			t = true;
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No valido id");
	}
	 }catch(errorIdClubNotFound e) {
		 e.getCause();
	 }
	
}

public void getMethodsSortWithCode(String idClubsi) {
	
	boolean t = false; 
	try{
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			clubs.get(i).ordenarPorIdOwner();
			t = true;
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No se enonctro");
	}
	
}catch(errorIdClubNotFound e) {
	e.getCause();
}
}
	
public void getMethodsSortWithSecondNames(String idClubsi) {
	boolean t = false;
	try {
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			clubs.get(i).ordenarPorSegundosNombres();
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

public void getMethodsSortWithName(String idClubsi) {
	boolean t = false;
	
	try {
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			clubs.get(i).ordenarPorNombrePrimero();
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No valido el id");
	}
 }catch(errorIdClubNotFound e) {
	 e.getCause();
 }
}

public void getMethodsSortWithDates(String idClubsi) {
	boolean t = false;
	try {
	for (int i = 0; i < clubs.size(); i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			clubs.get(i).ordenarPorFechas();
		}
	 }
	
	if(t == false) {
		throw new errorIdClubNotFound("No valido el id");
	}
	}catch(errorIdClubNotFound e) {
		e.getCause();
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

public String mostrarInfo(String idClubsi) {
	String msj = " ";
	boolean t = false;
	try {
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
			msj += " " +clubs.get(i).mostrarInfoOrdenado();
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("id no valido");
	}
	
	}catch(errorIdClubNotFound e) {
		e.getCause();
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
	
public String mostrarInfoOrdenado3(String idClubsi, String idOwner) {
	String msj = "";
	boolean t = false;
	try {
	for(int j = 0; j < clubs.size();j++) {
		if(clubs.get(j).getIdClub().equals(idClubsi)) {
		msj += clubs.get(j).mostrarInformacion(idOwner);
		}
	}
	if(t == false) {
		throw new errorIdClubNotFound("El id no es valido");
	}
	
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
	return msj;
}

public void ordenarPorNombrePets(String idClubsi,String idOwner) {
	boolean t = false;
	try {
	for(int j = 0; j < clubs.size();j++) {
		if(clubs.get(j).getIdClub().equals(idClubsi)) {
		clubs.get(j).getMethodsPetsName(idOwner);
		t = true;
		}
	}
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro el id");
	}
	
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
}

public void ordenarPorDates(String idClubsi,String idOwner) {
	
	boolean t = false;
	
	try {
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClubsi)) {
		clubs.get(i).getMethodsDatesPets(idOwner);
		t = true;
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No valido el id");
	}
	
  }catch(errorIdClubNotFound e) {
	  e.getMessage();
  }
	
}

public void ordenarPorGender(String idClubisto,String idOwner) {
	
	boolean t = false;
	
	try {
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClubisto)) {
		clubs.get(i).getMethodsGender(idOwner);
		t = true;
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro");
	}
	
	}catch(errorIdClubNotFound e) {
		e.getMessage();
	}
	
}

public void ordenarPorPetsId(String idClubsito,String idOwner){
	boolean t = false;
	
	try {
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClubsito)) {
		clubs.get(i).getMethodsPetsId(idOwner);
		t = true;
		}
	  }
	
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro");
	}
	
   }catch(errorIdClubNotFound e) {
	   e.getMessage();
   }
}

public void ordenarTipoDeMascota(String idClubsito,String idOwner){
	boolean t = false;
	
	try {
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClubsito)) {
		clubs.get(i).getMethodsPreferAnimal(idOwner);
		t = true;
		}
	}
	
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro el id");
	}
	
	}catch(errorIdClubNotFound e) {
		e.getMessage();
	}
}

//BINARIOS
public String searchBinariesForNameClub(String nameClub) { 
	String msj = "";
	String object = "";
	long a = System.currentTimeMillis();
	ordenarClubesPorNombre();
	int inicio = 0;
	int finales = clubs.size() -1;
	boolean t = false;
	while(inicio <= finales && !t) {
		int mitad = (inicio+finales)/2;
		if(clubs.get(mitad).getNameClub().compareTo(nameClub) == 0) {
			t = true;
			object = clubs.get(mitad).getIdClub();
			
		}else if(clubs.get(mitad).getNameClub().compareTo(nameClub) > 0) {
			finales = mitad -1;
		}else {
			inicio = mitad + 1;
		} 
	}
	long b = System.currentTimeMillis();
	
	
	msj = "Se encontro" + "1." + object +" " + t + "El tiempo binario:" + " " + (b-a);
	
	return msj;
}

public String searchBinariesForNameClubCase1(String nameClub) {
	String msj = " ";
	String object = "";
long c = System.currentTimeMillis();
	
	boolean findIt = false;
	
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getNameClub().equals(nameClub)) {
			findIt = true;
			object += clubs.get(i).getNameClub();
		}
	}
	
	long z = System.currentTimeMillis();
	
	msj = "Se encontro" + "1." + object + " " +findIt +" " + "El tiempo binario:" + " " + (z-c);
	
	return msj;
}

public String searchBinariesForId(String idClub) {
	String msj = "";
	String object = "";
	long a = System.currentTimeMillis();
	ordenarClubesPorId();
	int inicio = 0;
	int finales = clubs.size() -1;
	boolean t = false;
	while(inicio <= finales && !t) {
		int mitad = (inicio+finales)/2;
		if(clubs.get(mitad).getIdClub().compareTo(idClub) == 0) {
			t = true;
			object = clubs.get(mitad).getIdClub();
		}else if(clubs.get(mitad).getIdClub().compareTo(idClub) > 0) {
			finales = mitad -1;
		}else {
			inicio = mitad + 1;
		}
	}
	long b = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. "+object + " "+ t + " " + "El tiempo binario de uno:" + " " + (b-a);
	
	return msj; 
}

public String searchBinariesForIdCase1(String idClub) {
	String msj = "";
	String object = " ";
	
long c = System.currentTimeMillis();
	
	boolean findIt = false;
	
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			findIt = true;
			object = clubs.get(i).getIdClub();
		}
	}
	
	long z = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
	
	return msj;
	
}

public String searchBinariesForDate(String dates) {
	String msj = "";
	String object = " ";
	long a = System.currentTimeMillis();
	ordenarFechas();
	int inicio = 0;
	int finales = clubs.size() -1;
	boolean t = false;
	while(inicio <= finales && !t) {
		int mitad = (inicio+finales)/2;
		if(clubs.get(mitad).getCreationDate().compareTo(dates) == 0) {
			t = true;
			object = clubs.get(mitad).getCreationDate();
		}else if(clubs.get(mitad).getCreationDate().compareTo(dates) > 0) {
			finales = mitad -1;
		}else {
			inicio = mitad + 1;
		}
	}
	long b = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. "+ object + " " + t + " " + "El tiempo binario de uno:" + " " + (b-a);
	
	return msj; 
}

public String searchBinariesForDateCase1(String dates) {
	String msj = " ";
	String object = " ";
long c = System.currentTimeMillis();
	
	boolean findIt = false;
	
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getCreationDate().equals(dates)) {
			findIt = true;
			object += clubs.get(i).getCreationDate();
		}
	}
	
	long z = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. "+ object +" "+ findIt +" " + "El tiempo binario del otro:" + (z-c);
	
	return msj;
}

public String searchBinariesForTypeOfAnimals(String typeOfAnimals) {
	String msj = "";
	String object = "";
	long a = System.currentTimeMillis();
	ordenateTypeOfAnimals();
	int inicio = 0;
	int finales = clubs.size() -1;
	boolean t = false;
	while(inicio <= finales && !t) {
		int mitad = (inicio+finales)/2;
		if(clubs.get(mitad).getTypeOfAnimals().compareTo(typeOfAnimals) == 0) {
			object = clubs.get(mitad).getTypeOfAnimals();
			t = true;
		}else if(clubs.get(mitad).getTypeOfAnimals().compareTo(typeOfAnimals) > 0) {
			finales = mitad -1;
		}else {
			inicio = mitad + 1;
		}
	}
	long b = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. " + object + " " + t + " " + "El tiempo binario de uno:" + " " + (b-a);
	
	return msj; 
}

public String searchBinariesForTypeOfAnimalsCase1(String typeOfAnimals) {
	String msj = "";
	String object = "";
	long c = System.currentTimeMillis();
	
	boolean findIt = false;
	
	for(int i = 0; i < clubs.size();i++) {
		if(clubs.get(i).getTypeOfAnimals().equals(typeOfAnimals)) {
			findIt = true;
			object = clubs.get(i).getTypeOfAnimals();
		}
	}
	
	long z = System.currentTimeMillis();
	
	msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
	
	return msj; 
}

//BinarioPets
public String getBinaryOfIdOwnerPet(String idClub,String idOwner,String idPet) {
	String msj = "";
	boolean t = false;
	
	try {
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj = clubs.get(i).getMethodsPetsIdPets(idOwner,idPet);
			}
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No se encontro");
		}
		
	}catch(errorIdClubNotFound e) {
		e.getCause();
	}
	
	return msj;
	
}

public String getBinaryOfOwnerNamesPet(String idClub,String idOwner,String ownerNamePet) {
	String msj = "";
	boolean t = false;
	
	for(int i = 0; i < clubs.size() && !t;i++) {
		if(clubs.get(i).getIdClub().equals(idClub)){
			msj = clubs.get(i).getMethodsPetsName(idOwner,ownerNamePet);
			t = true;
		}
	}
	
	return msj;
	
}

public String getBinaryGenderPets(String idClub,String idOwner,String genderPet) {
	String msj = "";
	boolean t = false;
	
	for(int i = 0; i < clubs.size() && !t;i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			msj = clubs.get(i).getMethodsGender(idOwner,genderPet);
			t = true;
		}
	}
	return msj;
}

public String getBinaryOfTypeOfAnimalsPrefer(String idClub,String idOwner,String typeOfAnimalsPrefer) {
	String msj = "";
	boolean t = false;
	for(int i = 0; i < clubs.size() && !t;i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			msj = clubs.get(i).getMethodsAnimalPreferPet(idOwner,typeOfAnimalsPrefer);
			t = true;
		}
	}
	
	return msj;
	
}

public String getBinaryOfThePetBornDay(String idClub,String idOwner,String date) {
	String msj = "";
	boolean t = false;
	for(int i = 0; i < clubs.size() && !t;i++) {
		if(clubs.get(i).getIdClub().equals(idClub)) {
			msj = clubs.get(i).getMethodsBinaryBornPet(idOwner,date);
			t = true;
		}
	}
	
	return msj;
}


//BinariosOwner
public String getBinaryOfBornDay1(String idClub,String creationDate ) {
	String msj = "";
	boolean t = false;
	try {
		
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj += clubs.get(i).searchBinariesForBornDay(creationDate);
				msj += "---------------------------------------------------";
				msj += clubs.get(i).searchBinariesForBornDayCase1(creationDate);
				t = true;
			}
		}
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro");
	}
		
	}catch(errorIdClubNotFound e) {
		e.getMessage();
	}
	return msj;
}

public String getBinaryOfIdOwner2(String idClub,String idOwner) {
	String msj = "";
	boolean t = false;
	try {
		
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj = clubs.get(i).searchBinariesIdOwner(idOwner);
				msj = clubs.get(i).searchBinariesIdOwnerCase1(idOwner);
				t = true;
			}
		}
	if(t == false) {
		throw new errorIdClubNotFound("No se encontro");
	}
		
	}catch(errorIdClubNotFound e) {
		e.getMessage();
	}
	return msj;
}

public String getBinaryOfOwnerNames3(String idClub,String firstName) {
	String msj = "";
	boolean t = false;
	try {
		for(int i = 0; i < clubs.size() && !t ;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj = clubs.get(i).searchBinariesForOwnersNames(firstName);
				msj = clubs.get(i).searchBinariesForOwnersNamesCase1(firstName);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdOwner("No valido");
		}
	}catch(errorIdOwner e) {
		e.getMessage();
	}
	return msj;
}

public String getBinaryOfOwnersSecondNames4(String idClub,String secondNames) {
	String msj = "";
	
	boolean t = false;
	try {
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj = clubs.get(i).searchBinariesForSecondNames(secondNames);
				msj = clubs.get(i).searchBinariesForSecondNamesCase1(secondNames);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdOwner("No valido");
		}
	}catch(errorIdOwner e) {
		e.getMessage();
	}
	return msj;
}

public String getBinaryOfTypeOfAnimalsPrefer5(String idClub,String typeOfAnimals) {

	String msj = "";
	boolean t = false;
	try {
		for(int i = 0; i < clubs.size() && !t;i++) {
			if(clubs.get(i).getIdClub().equals(idClub)) {
				msj = clubs.get(i).searchBinariesForTypeOfAnimalsPrefer(typeOfAnimals);
				msj = clubs.get(i).searchBinariesForTypeOfAnimalsPreferCase1(typeOfAnimals);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdOwner("No valido");
		}
	}catch(errorIdOwner e) {
		e.getMessage();
	}
	return msj;
}

}//Final
	

	

