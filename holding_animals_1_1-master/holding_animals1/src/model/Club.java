package model;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import exceptions.errorIdClubNotFound;
import exceptions.errorIdOwner;
import exceptions.errorNameNotFound;
import exceptions.errorNameOwnerNotFound;

public class Club implements Serializable, Comparable<Club>,Comparator<Club> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String DATA = "\"Ownersit\"";
	//relaciones
	private ArrayList<Owner> owners;
	
	//Atributos
	private String idClub;
	private String nameClub;
	private String creationDate;
	private String typeOfAnimals;

	
	/**
	 * 
	 */
	public Club(String idClub,String nameClub,String creationDate,String typeOfAnimals) {
		this.idClub = idClub;
		this.nameClub = nameClub;
		this.creationDate = creationDate;
		this.typeOfAnimals = typeOfAnimals;
		owners = new ArrayList<Owner>();
		deserialazeOwner();
	
	}
	
	/**
	 * 
	 */
	public String getIdClub() {
		return idClub;
	}
	
	/**
	 * 
	 */
	public void setIdClub(String idClub) {
		this.idClub = idClub;
	}
	
	/**
	 * 
	 */
	public String getNameClub() {
		return nameClub;
	}
	
	/**
	 * 
	 */
	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}
	
	/**
	 * 
	 */
	public String getCreationDate() {
		return creationDate;
	}
	
	/**
	 * 
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * 
	 */
	public String getTypeOfAnimals() {
		return typeOfAnimals;
	}
	
	/**
	 * 
	 */
	public void setTypeOfAnimals(String typeOfAnimals) {
		this.typeOfAnimals = typeOfAnimals;
	}
	
	/**
	 * 
	 */
	public ArrayList<Owner> getOwners(){
		return owners;
	}
	
	/**
	 * 
	 */
	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	
	/**
	 * 
	 */
	public void addOwners(String idOwner, String ownerNames, String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {

		owners.add(new Owner(idOwner,ownerNames,ownerSecondNames,typeOfAnimalsPrefer,bornDay));
	}
	

	/**
	 * 
	 */
	public void searchForTheOwner(String idClient, String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		boolean t = false;
		try {
		for (int i = 0; i < owners.size(); i++){ 
			if(owners.get(i).getIdOwner().equals(idClient)) {
				owners.get(i).addAnimals(idPet, petName, gender, typeOfPet, bornPetDay);
				t = true;
			}
			
		}
		
		if(t == false) {
			throw new errorIdClubNotFound("No encontro el id del cliente");
		}
		
	}catch(errorIdClubNotFound e) {
		System.out.println("No encontro el id del cliente");
		e.getCause();
	}
}
	
	/**
	 * 
	 */
	public void delatedOwner(String nombredelMka,String apellidoOwner) {
		boolean t = false;
		
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			
			if((owners.get(i).getOwnerNames().equals(nombredelMka)) && (owners.get(i).getOwnerSecondNames().equals(apellidoOwner))){
				owners.remove(owners.get(i));
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorNameOwnerNotFound("No se encontro");
		}
	}catch (errorNameOwnerNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	/**
	 * 
	 */
	public void delatedOwnerNumber(String idDelMka) {
		boolean t = false;
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			
			if(owners.get(i).getIdOwner().equals(idDelMka)){
				owners.remove(owners.get(i));
				t = true;
			}
		}
		
		if(t == false) {
				throw new errorIdOwner("No valido el id");
		}
		
	}catch (errorIdOwner e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	/** 
	 * 
	 */
	public void delatedPetWithName(String idOwner,String namePet){
		boolean t = false;
		
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				owners.get(i).deletePetName(namePet);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdOwner("No valido");
		}
		
		}catch(errorIdOwner e) {
			System.out.println("No valido el id del owner");
			e.getCause();
		}
		
	}
	
	public void delatedPetWithIdPet(String idOwner,String idPet){
		boolean t = false;
		
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				owners.get(i).deletePet(idPet);
				t = true;
			}
		}
		if(t == false) {
			throw new errorIdOwner("Not found");
		}
		
		}catch(errorIdOwner e) {
			e.getCause();
		}
		
	}
	
	/**
	 * 
	 */
	public String toString() {
		String msj = "";
		
		msj+= "El id es: " + " " + idClub + " ";
		msj+= "El nombre del club es: " + " " + nameClub+ " ";
		msj+= "La fecha de creacion es: " + " " + creationDate+ " ";
		msj+= "El tipo de animal preferido es: " + " " + typeOfAnimals+ " ";
		
	
		return msj;
	}

	
	/**
	 * 
	 */
	@Override
	public int compareTo(Club club) {
		
		return idClub.compareTo(club.getIdClub());
		
	}

	@Override
	public int compare(Club o1, Club o2) {
		
		return o1.getNameClub().compareTo(o2.getNameClub());
	}
	
	public int compareOrdenarPorFecha(Club o1) {
		
		return formatTheDateOfThis(creationDate).compareTo(formatTheDateOfThis(o1.getCreationDate()));
		
	}
	
	public int compareTypeOfAnimals(Club o1) {
		
		return typeOfAnimals.compareTo(o1.getTypeOfAnimals());
	}
	
	public Date formatTheDateOfThis(String dateOfThis) {
		Date inicialDate = null;
		SimpleDateFormat dateOfThis1 = new SimpleDateFormat("d/mm/yyyy");
		
		try {
			inicialDate = dateOfThis1.parse(dateOfThis);
		}catch(ParseException e) {
			e.getCause();
		}
		
		
		return inicialDate;
	}
	
	public void ordenarPorIdOwner() {
		
		for(int i = 0; i < owners.size();i++) {
			Owner menor = owners.get(i);
			int indice = i;
			for(int j = i +1; j < owners.size()-1;j++) {
				if(owners.get(j).compareTo(menor) > 0) {
					
					menor = owners.get(j);
					indice = j;
					
				}
			}
			Owner temp = owners.get(i);
			owners.set(i, menor);
			owners.set(indice,temp);
			
		}
	}
	
	
	public void ordenarPorNombrePrimero() {
		for(int i = 1; i < owners.size();i++) {
			
			for(int j = i; j > 0 && owners.get(j-1).compareTo(owners.get(j-1)) > 0;j--) {
				Owner own = owners.get(j-1);
				owners.set(j-1, owners.get(j));
				owners.set(j, own);
			}
			
		}
	}
	
	public void ordenarPorSegundosNombres() {
		
		for(int i = 0; i < owners.size();i++) {
			
			for(int j = 0; j < owners.size()-1-i;j++) {
				if(owners.get(j).compareToSecondNames(owners.get(j),owners.get(j+1)) > 0) {
					Owner own = owners.get(j);
					owners.set(j, owners.get(j+1));
					owners.set(j+1,own);
				}
				
			}
			
		}	
	}
	
	public void ordenarPorTipoDeAnimal() {
		
		for(int i = 1; i < owners.size();i++) {
			
			for(int j = i; j > 0 && owners.get(j-1).compareToTypeOfAnimalsPrefer(owners.get(j)) > 0;j--) {
				Owner own = owners.get(j-1);
				owners.set(j-1, owners.get(j));
				owners.set(j, own);
				
				
			}
			
		}
		
		
	}
	
	public void ordenarPorFechas() {
		
		for(int i = 0; i < owners.size();i++) {
			for(int j = 0; j < owners.size()-1-i;j++) {
				if(owners.get(j).compareToBornDay(owners.get(j+1)) > 0) {
					Owner own = owners.get(j);
					owners.set(j,owners.get(j+1));
					owners.set(j+1, own);
					
				}
			}
		}
		
	}
	
	public String mostrarInfoOrdenado() {
		String msj = "";
		for(int j = 0; j < owners.size();j++) {
			msj += "\n" + owners.get(j).toString();
		}
	return msj;
	}
	
	public int compararPorTamaño(Club o1,Club o2) {
		
		return o1.getOwners().size() - o2.getOwners().size();
		
	}
	
	public void deserialazeOwner() {
		
	 File fl = new File("files\\Clubsito.dat");
	 ArrayList<Owner> ownersitos;
	 try {
		 FileInputStream fls = new FileInputStream(fl);
		 ObjectInputStream obs = new ObjectInputStream(fls);
		 
		 ownersitos = (ArrayList<Owner>) obs.readObject();
		 setOwners(ownersitos);
		 obs.close();
	 }catch(IOException e) {
		 e.getCause();
	 } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	

	}
	}
	
	
	public void serializableOwner() {
		
		File fl = new File("files\\Clubsito.dat");
		
		try {
			FileOutputStream flo = new FileOutputStream(fl);
			ObjectOutputStream ob = new ObjectOutputStream(flo);
			
			ob.writeObject(owners);
			ob.close();
			
		}catch(IOException e) {
			e.getCause();
		}
		
	}
	
	public String mostrarInformacion(String idOwner) {
		String msj = " ";
		for(int j = 0; j < owners.size();j++) {
			if(owners.get(j).getIdOwner().equals(idOwner)) {
			msj += owners.get(j).mostrarInfoOrdenado1();
		}
	}
		return msj;
	}
	
	public void getMethodsPetsName(String idOwner) {
		boolean t = false;
		
		try {
		for(int j = 0; j < owners.size() && !t;j++) {
			if(owners.get(j).getIdOwner().equals(idOwner)) {
			owners.get(j).ordenarPorNombres();
			t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdOwner("No se encontro el id");
		}
	 }catch(errorIdOwner e) {
		 e.getMessage();
	 }
	}
	
	public void getMethodsPetsId(String idOwner) {
		
		boolean t = false;
		
		try {
		for(int j = 0; j < owners.size() && !t ;j++) {
			if(owners.get(j).getIdOwner().equals(idOwner)){
			owners.get(j).ordenarPorIdPet();
			t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdOwner("No se encontro");
		}
		
	}catch(errorIdOwner e) {
		e.getMessage();
	}
}
	
	public void getMethodsGender(String idOwner) {
		boolean t = false;
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
			owners.get(i).ordenarPorGenero();
			t = true;
			}
		}
		
		if(t == false) {
			throw new errorIdOwner("No se encontro el id del owner");
		}
		
		}catch(errorIdOwner e) {
			e.getMessage();
		}
	}
	
	public void getMethodsPreferAnimal(String idOwner) {
		boolean t = false;
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
			owners.get(i).ordenarPorTipoDeAnimalElPet();
			t = true;
		}
	}
		if(t == false) {
			throw new errorIdOwner("La id no es valida");
		}
		}catch(errorIdOwner e) {
			e.getMessage();
		}
		
	}
	
	public void getMethodsDatesPets(String idOwner) {
		
		boolean t = false;
		try {
		for(int j = 0; j < owners.size() && !t;j++){
			if(owners.get(j).getIdOwner().equals(idOwner)){
			owners.get(j).ordenarPorFecha();
			t = true;
		 }
	}
		if(t == false) {
			throw new errorIdOwner("No valido el id del owner");
		}
	
	}catch(errorIdOwner e) {
		e.getMessage();
	}
}
	//BINARIOS
	public String searchBinariesIdOwner(String idOwner) {
		String msj = "";
		String object = "";
		
		long a = System.currentTimeMillis();
		ordenarPorIdOwner();
		int inicio = 0;
		int finales = owners.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(owners.get(mitad).getIdOwner().compareTo(idOwner) == 0) {
				t = true;
				object = owners.get(mitad).getIdOwner();
			}else if(owners.get(mitad).getIdOwner().compareTo(idOwner) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object + "2." + t + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesIdOwnerCase1(String idOwner) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < owners.size() && !findIt;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				findIt = true;
				object += owners.get(i).getIdOwner();
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
		
	}
	
	public String searchBinariesForOwnersNames(String ownerNames) {
		String msj = "";
		String object = "";
		
		long a = System.currentTimeMillis();
		ordenarPorNombrePrimero();
		int inicio = 0;
		int finales = owners.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(owners.get(mitad).getOwnerNames().compareTo(ownerNames) == 0) {
				t = true;
				object = owners.get(mitad).getOwnerNames();
				
			}else if(owners.get(mitad).getOwnerNames().compareTo(ownerNames) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();

		
		msj = "Se encontro" + "1. " + object +" " + t + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesForOwnersNamesCase1(String ownerNames) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < owners.size() && !findIt;i++) {
			if(owners.get(i).getOwnerNames().equals(ownerNames)) {
				findIt = true;
				object = owners.get(i).getOwnerNames();
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
		
	}
	
	public String searchBinariesForSecondNames(String secondNames) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorSegundosNombres();
		int inicio = 0;
		int finales = owners.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(owners.get(mitad).getOwnerSecondNames().compareTo(secondNames) == 0) {
				t = true;
				object = owners.get(mitad).getIdOwner();
				
			}else if(owners.get(mitad).getOwnerSecondNames().compareTo(secondNames) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
	
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesForSecondNamesCase1(String secondNames) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < owners.size() && !findIt;i++) {
			if(owners.get(i).getOwnerSecondNames().equals(secondNames)) {
				findIt = true;
				object = owners.get(i).getOwnerSecondNames();
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
	
	}
	
	public String searchBinariesForTypeOfAnimalsPrefer(String typeOfAnimals1) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorTipoDeAnimal();
		int inicio = 0;
		int finales = owners.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(owners.get(mitad).getTypeOfAnimalsPrefer().compareTo(typeOfAnimals1) == 0) {
				t = true;
				object = owners.get(mitad).getTypeOfAnimalsPrefer();
			}else if(owners.get(mitad).getTypeOfAnimalsPrefer().compareTo(typeOfAnimals1) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesForTypeOfAnimalsPreferCase1(String typeOfAnimals1) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < owners.size() && !findIt;i++) {
			if(owners.get(i).getTypeOfAnimalsPrefer().equals(typeOfAnimals1)) {
				object = owners.get(i).getTypeOfAnimalsPrefer();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
	}
	
	public String searchBinariesForBornDay(String bornDay) { 
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorFechas();
		int inicio = 0;
		int finales = owners.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(owners.get(mitad).getBornDay().compareTo(bornDay) == 0) {
				t = true;
				object = owners.get(mitad).getBornDay();
				
			}else if(owners.get(mitad).getBornDay().compareTo(bornDay) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			} 
		}
		long b = System.currentTimeMillis();

		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesForBornDayCase1(String bornDay) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < owners.size() && !findIt;i++) {
			if(owners.get(i).getBornDay().equals(bornDay)) {
				findIt = true;
				object = owners.get(i).getBornDay();
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
		
	}
	//BinarioPets
	public String getMethodsPetsIdPets(String idOwner,String idPet) {
		String msj = "";
		boolean t = false;
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				msj = owners.get(i).searchBinariesForIdPetCase1(idPet);
				msj = owners.get(i).searchBinariesForIdPet(idPet);
				t = true;		
			}
		}
		
		if(t == false) {
			throw new errorIdOwner("No se encontro la id");
		}
		
		}catch(errorIdOwner e) {
			e.getMessage();
		}
		
		return msj;
	}
	
	public String getMethodsPetsName(String idOwner,String petName) {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				msj = owners.get(i).searchBinariesForNamePet(petName);
				msj = owners.get(i).searchBinariesForNamePetCase1(petName);
				t = true;
			}
		}
		
		return msj;
	}
	
	public String getMethodsGender(String idOwner,String genderPet) {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				msj = owners.get(i).searchBinariesGender(genderPet);
				msj = owners.get(i).searchBinariesGenderCase1(genderPet); 
				t = true;
			}
		}
		
		return msj;
	}
	
	public String getMethodsAnimalPreferPet(String idOwner,String typeOfAnimalsPrefer) {
		String msj = "";
		boolean t = false;
		try {
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				msj = owners.get(i).searchBinaryTypeOfPet(typeOfAnimalsPrefer);
				msj = owners.get(i).searchBinaryTypeOfPetCase1(typeOfAnimalsPrefer);
				t= true;
			}
		}
		
		if(t == false) {
			throw new errorIdOwner("No se encontro");
		}
		
		}catch(errorIdOwner e) {
			e.getCause();
		}
		
		return msj;
	}
	
	public String getMethodsBinaryBornPet(String idOwner,String date) {
		String msj = " ";
		boolean t = false;
		
		for(int i = 0; i < owners.size() && !t;i++) {
			if(owners.get(i).getIdOwner().equals(idOwner)) {
				msj = owners.get(i).searchBinariesBornDay(date);
				msj = owners.get(i).searchBinariesBornDayCase1(date);
				t = true;
			}
		}
		
		return msj;
	}
			
}//finalDeLaClase