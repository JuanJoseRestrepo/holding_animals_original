package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
	
	public void getTypeOfAnimalsPrefer(String typeOfAnimalsPrefer) {
		this.typeOfAnimalsPrefer = typeOfAnimalsPrefer;
	}
	
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	public String addAnimals(String idPet,String petName, String gender,String typeOfPet,String bornPetDay) {
		String msj = " ";
		for(int i = 0; i < pets.size();i++) {
			if(!pets.get(i).getPetName().equals(petName)) {
	          msj = "No puede haber iguales";
	          pets.add(new Pet(idPet,petName,gender,typeOfPet,bornPetDay));
			}else {
				msj = "Se agrego el pet";
				pets.add(new Pet(idPet,petName,gender,typeOfPet,bornPetDay));
			}
		}
		return msj;
	}
	

	public String toString() {
	String msj = "";
	
	msj += "El id del Owner:" + idOwner + " "; 
	msj += "El nombre del dueño es:" + ownerNames + " "; 
	msj += "El segundo nombre es:" + ownerSecondNames + " "; 
	msj += "El tipo de animal preferido es:" + typeOfAnimalsPrefer + " "; 
	msj += "El dia de nacimiento es:" + bornDay + " "; 
	
	for(int i = 0; i < pets.size();i++) {
		pets.get(i).toString();
	}
	
	return msj;
	}

	@Override
	public int compare(Owner o1, Owner o2) {
		// TODO Auto-generated method stub
		return o1.getOwnerNames().compareTo(o2.getOwnerNames());
	}

	@Override
	public int compareTo(Owner o1) {
		// TODO Auto-generated method stub
		return idOwner.compareTo(o1.getIdOwner()) ;
	}
	
	public int compareToSecondNames(Owner o1, Owner o2) {
		
		return o1.getOwnerSecondNames().compareTo(o2.getOwnerSecondNames());
		
	}
	
	public int compareToTypeOfAnimalsPrefer(Owner o1) {
		
		return typeOfAnimalsPrefer.compareTo(o1.getTypeOfAnimalsPrefer());
		
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
		
		for(int i = 0; i < pets.size();i++) {
			Pet menor = pets.get(i);
			int indice = i;
			for(int j = i +1; i < pets.size()-1;j++) {
				if(pets.get(j).compare(pets.get(j), pets.get(j+1)) < 0) {
					menor = pets.get(j);
					indice = j;
				}
				
			}
			Pet temp = pets.get(i);
			pets.set(i,menor);
			pets.set(indice, temp);
			
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
	
}