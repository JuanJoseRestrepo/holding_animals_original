package model;
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

import exceptions.errorNoMoreAnimals;

public class Owner implements Serializable, Comparable<Owner>,Comparator<Owner>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Pet> pets;
	
	private String idOwner;
	private String ownerNames;
	private String ownerSecondNames;
	private String typeOfAnimalsPrefer;
	private String bornDay;
	
	public Owner(String idOwner,String ownerNames,String ownerSecondNames,String typeOfAnimalsPrefer,String bornDay) {
		this.idOwner = idOwner;
		this.ownerNames = ownerNames;
		this.ownerSecondNames = ownerSecondNames;
		this.typeOfAnimalsPrefer = typeOfAnimalsPrefer;
		this.bornDay = bornDay;
		
		pets = new ArrayList<Pet>();
	}
	
	
	
	public String getIdOwner() {
		return idOwner;
	}
	
	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}
	
	public String getOwnerNames() {
		return ownerNames;
	}
	
	public void setOwnerNames(String ownerNames) {
		this.ownerNames = ownerNames;
	}
	
	public String getBornDay() {
		return bornDay;
	}
	
	public void setBornDay(String bornDay) {
		this.bornDay = bornDay;
	}
	
	public String getOwnerSecondNames() {
		return ownerSecondNames;
	}
	
	public void setOwnerSecondNames(String ownerSecondNames) {
		this.ownerSecondNames = ownerSecondNames;
	}
	
	public String getTypeOfAnimalsPrefer() {
		return typeOfAnimalsPrefer;
	}
	
	public void setTypeOfAnimalsPrefer(String typeOfAnimalsPrefer) {
		this.typeOfAnimalsPrefer = typeOfAnimalsPrefer;
	}
	
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	public void addAnimals(String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		
		pets.add(new Pet(idPet,petName,gender,typeOfPet,bornPetDay));
	}
	
	public String toString() {
	String msj = "";
	
	msj += "El id del Owner:" + idOwner + " "; 
	msj += "El nombre del dueño es:" + ownerNames + " "; 
	msj += "El segundo nombre es:" + ownerSecondNames + " "; 
	msj += "El tipo de animal preferido es:" + typeOfAnimalsPrefer + " "; 
	msj += "El dia de nacimiento es:" + bornDay + " "; 
	
	return msj;
	}
	
	public String mostrarInfoOrdenado1() {
		String msj = " ";
		
		for(int j = 0; j < pets.size();j++) {
			msj +=  "\n" + pets.get(j).toString();
		}
		return msj;
	}
	
	@Override
	public int compare(Owner o1, Owner o2) {
		// TODO Auto-generated method stub
		return o1.getOwnerNames().compareToIgnoreCase(o2.getOwnerNames());
	}

	@Override
	public int compareTo(Owner o1) {
		// TODO Auto-generated method stub
		return idOwner.compareToIgnoreCase(o1.getIdOwner()) ;
	}
	
	public int compareToSecondNames(Owner o1, Owner o2) {
		
		return o1.getOwnerSecondNames().compareToIgnoreCase(o2.getOwnerSecondNames());
		
	}
	
	public int compareToTypeOfAnimalsPrefer(Owner o1) {
		
		return typeOfAnimalsPrefer.compareToIgnoreCase(o1.getTypeOfAnimalsPrefer());
		
	}
	
	public int compareToBornDay(Owner o1) {
		
		return formatTheDateOfThis(bornDay).compareTo(formatTheDateOfThis(o1.getBornDay()));
		
	}
	
	
	public Date formatTheDateOfThis(String dateOfThis) {
		Date inicialDate = null;
		SimpleDateFormat dateOfThis1 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			inicialDate = dateOfThis1.parse(dateOfThis);
		}catch(ParseException e) {
			e.getCause();
		}
		
		
		return inicialDate;
	}
	
	public void ordenarPorIdPet() {
		
		for(int i = 1; i < pets.size();i++) {
			for(int j = i; j > 0 && pets.get(j-1).compare(pets.get(j-1),pets.get(j)) > 0;j--) {
				Pet petsito = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, petsito);
			}
		}
		
	}
	
	public void ordenarPorNombres() {
		for(int i = 1; i < pets.size();i++) {
			for(int j = i; j > 0 && pets.get(j-1).compareTo(pets.get(j)) > 0;j--) {
				Pet petsito = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, petsito);
			}
		}
	}
	
	public void ordenarPorGenero() {
		
		for(int i = 0; i < pets.size();i++) {
			
			for(int j = 0; j < pets.size()-1-i;j++) {
				if(pets.get(j).compareGender(pets.get(j),pets.get(j+1)) > 0) {
					
					Pet pets1 = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1,pets1);		
				}
			}	
		}	
	}
	
	public void ordenarPorTipoDeAnimalElPet() {
		
		for(int i = 1; i < pets.size();i++) {
			for(int j = i; j > 0 && pets.get(j-1).compareTypeOfPet(pets.get(j)) > 0;j--) {
				Pet petsito = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, petsito);
			}
		}
		
	}
	
	public void ordenarPorFecha() {
		
		for(int i = 1; i < pets.size();i++) {
			for(int j = i; j > 0 && pets.get(j-1).compareBornDayPet(pets.get(j)) > 0;j--) {
				Pet petsito = pets.get(j);
				pets.set(j, pets.get(j-1));
				pets.set(j-1, petsito);
			}
		}
		
	}
	
	public void deletePet(String idPet) {
		
		boolean t = false;
		
		try {
		for(int j = 0; j < pets.size();j++) {
			if(pets.get(j).getIdPet().equals(idPet)) {
				pets.remove(pets.get(j));
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorNoMoreAnimals("No se pudo agregar");
		}
		
	}catch(errorNoMoreAnimals e) {
		e.getMessage();
	}
}
	public void deletePetName(String nameClub) {
		boolean t = false;
		
		try {
		for(int j = 0; j < pets.size();j++) {
			if(pets.get(j).getPetName().equals(nameClub)) {
				pets.remove(pets.get(j));
				t = true;
			}
		}
		
		if(t == false) {
			throw new errorNoMoreAnimals("No se pudo eliminar");
		}
		
		}catch(errorNoMoreAnimals e) {
			e.getMessage();
		}
	}
	
	public String searchBinariesForIdPet(String idPet) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorIdPet();
		int inicio = 0;
		int finales = pets.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(pets.get(mitad).getIdPet().compareTo(idPet) == 0) {
				object = pets.get(mitad).getIdPet();
				t = true;
			}else if(pets.get(mitad).getIdPet().compareTo(idPet) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesForIdPetCase1(String idPet) {
		String msj = "";
		String object = "";
		
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < pets.size();i++) {
			if(pets.get(i).getIdPet().equals(idPet)) {
				object = pets.get(i).getIdPet();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
	}
	
	
	public String searchBinariesForNamePet(String namePet) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorIdPet();
		int inicio = 0;
		int finales = pets.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(pets.get(mitad).getPetName().compareTo(namePet) == 0) {
				t = true;
				object = pets.get(mitad).getPetName();
			}else if(pets.get(mitad).getPetName().compareTo(namePet) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	} 
	
	public String searchBinariesForNamePetCase1(String namePet) {
		String msj = "";
		String object = "";
			
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < pets.size();i++) {
			if(pets.get(i).getPetName().equals(namePet)) {
				object = pets.get(i).getPetName();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
		
	}
	
	public String searchBinariesGender(String gender) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorIdPet();
		int inicio = 0;
		int finales = pets.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(pets.get(mitad).getGender().compareTo(gender) == 0) {
				object = pets.get(mitad).getGender();
				t = true;
			}else if(pets.get(mitad).getGender().compareTo(gender) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinariesGenderCase1(String gender) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < pets.size();i++) {
			if(pets.get(i).getGender().equals(gender)) {
				object = pets.get(i).getGender();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj;
	}
	
	public String searchBinaryTypeOfPet(String typeOfPet) {
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorIdPet();
		int inicio = 0;
		int finales = pets.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(pets.get(mitad).getTypeOfPet().compareTo(typeOfPet) == 0) {
				object = pets.get(mitad).getTypeOfPet();
				t = true;
			}else if(pets.get(mitad).getTypeOfPet().compareTo(typeOfPet) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
	}
	
	public String searchBinaryTypeOfPetCase1(String typeOfPet) {
		String msj =  "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < pets.size();i++) {
			if(pets.get(i).getTypeOfPet().equals(typeOfPet)) {
				object = pets.get(i).getTypeOfPet();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
	}
	
	public String searchBinariesBornDay(String bornDay) {
		
		String msj = "";
		String object = "";
		long a = System.currentTimeMillis();
		ordenarPorIdPet();
		int inicio = 0;
		int finales = pets.size() -1;
		boolean t = false;
		while(inicio <= finales && !t) {
			int mitad = (inicio+finales)/2;
			if(pets.get(mitad).getBornPetDay().compareTo(bornDay) == 0) {
				object = pets.get(mitad).getBornPetDay();
				t = true;
			}else if(pets.get(mitad).getBornPetDay().compareTo(bornDay) > 0) {
				finales = mitad -1;
			}else {
				inicio = mitad + 1;
			}
		}
		long b = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + t +"2." + object + " " + "El tiempo binario de uno:" + " " + (b-a);
		
		return msj; 
		
	}
	
	public String searchBinariesBornDayCase1(String bornDay) {
		String msj = "";
		String object = "";
		
		long c = System.currentTimeMillis();
		
		boolean findIt = false;
		
		for(int i = 0; i < pets.size();i++) {
			if(pets.get(i).getBornPetDay().equals(bornDay)) {
				object = pets.get(i).getBornPetDay();
				findIt = true;
			}
		}
		
		long z = System.currentTimeMillis();
		
		msj = "Se encontro" + "1. " + object +"2." + findIt + " " + "El tiempo binario del otro:" + (z-c);
		
		return msj; 
	}
	
}