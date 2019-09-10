package ui;
import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private Holding system;
	private Scanner reader;
	
	
	public Main() {
		reader = new Scanner(System.in);
		system = new Holding("Clubes.csv");
	}
	
	public void showMenu(){
		int inputUser = 0; 
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("1.Crear club");
		System.out.println("2.Crear dueño");
		System.out.println("3.Crear mascota");
		System.out.println("4.Eliminas el clubsito");
		System.out.println("5.Eliminar al dueño :O");
		System.out.println("6.Eliminar a la mascota");
		System.out.println("7.Mostrar la informacion ordenada de los clubes");
		System.out.println("8.Mostrar la informacion ordenada de los owners");
		System.out.println("9. Mostrar la informacion ordenada de los pets");
		System.out.println("10.Salir del programa");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

		
		while(inputUser != 10) {
			try {
			inputUser = reader.nextInt();
			reader.nextLine();
			
			if(inputUser == 1) {
				System.out.println("Digite la identificacion del club");
				String idClub =
				reader.nextLine();
				
				System.out.println("Digite el nombre del club");
				String nameClub = reader.nextLine();
				
				System.out.println("Digite la fecha de creacion" + "//" + "En formato YYYY/MM/DD" );
				String nameCreation = reader.nextLine();
				
				System.out.println("Digite el tipo de mascotas");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Perros ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Gatos ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Kanguro");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Otros");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				
				String typeOfAnimals = reader.nextLine();
				
				system.registerClubInTheSystem(idClub,nameClub,nameCreation,typeOfAnimals);
				System.out.println("Se agrego el club");
				
				
				system.saveClub();

			}else if(inputUser == 2) {
				
				System.out.println("Digite el id del Club que va agregar al dueño");
				String idnameClub = 
				reader.nextLine();
				
				System.out.println("Digite el id del dueño");
				String idCli = 
				reader.nextLine();
				
				System.out.println("Digite su nombre o sus nombres");
				String Cliname = reader.nextLine();
				
				System.out.println("Digite su apellido o sus apellidos");
				String CliSecond = reader.nextLine();
				
				System.out.println("Digite el tipo de animal que mas prefiere");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Perros ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Gatos ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Kanguro");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Otros");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				
				String typeOfPet = reader.nextLine();
				
				System.out.println("Digite su fecha de nacimiento" + "//" + "En formato YYYY/MM/DD");
				String bornD = reader.nextLine();
				
				system.findClubForOwner(idnameClub, idCli, Cliname, CliSecond, typeOfPet, bornD);
			
			}else if(inputUser == 3) {
				System.out.println("Digite  el id del Club que va agregar la mascota");
				String idPetClub = reader.nextLine();
				
				System.out.println("Digite el id del dueño que va agregar la mascota");
				String idDelDueño = reader.nextLine();
				
				System.out.println("Digite el  id  del animalito");
				String idPetsito = reader.nextLine();
				
				System.out.println("Digite el nombre del animalito");
				String idName = reader.nextLine();
				
				System.out.println("Digite el genero de la mascota");
				String gender = reader.nextLine();
				
				System.out.println("Digite el tipo de mascota");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Perros ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Gatos ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Kanguro");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("Otros");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				
				String typeOfPet3 = reader.nextLine();
				
				System.out.println("Digite el dia de cumpleaños de la mascota" +"||" + "En formato de:" + "||" + "YYYY/MM/DD");
				String datePe = reader.nextLine();
				
				system.findClubWithClubAndOwnerAndPet(idPetClub, idDelDueño, idPetsito, idName, gender, typeOfPet3, datePe);
				
			}else if(inputUser == 4) { 
				int userImput1 = 0;
				System.out.println("Digite lo siguiente");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("1.Eliminar club por id ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("2.Eliminar club por nombre ");
				System.out.println("3.Salir");
				
				while(userImput1 != 3) {
					userImput1 = reader.nextInt();
					reader.nextLine();
					
					if(userImput1 == 1) {
						System.out.println("Digite el id del club");
						String idClub = reader.nextLine();
						
						system.delatedClubWithNumber(idClub);
					}else if(userImput1 == 2) {
						System.out.println("Digite el nombre del club");
						String nameClub = reader.nextLine();
						
						system.delatedClubWithName(nameClub);
					}else {
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear dueño");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al dueño :O");
						System.out.println("6.Eliminar a la mascota");
						System.out.println("7.Mostrar la informacion ordenada de los clubes");
						System.out.println("8.Mostrar la informacion ordenada de los owners");
						System.out.println("9. Mostrar la informacion ordenada de los pets");
						System.out.println("10.Salir del programa");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					}	
				}
				 
				
			}else if(inputUser == 5) {
				int userImput2 = 0;
				System.out.println("Digite lo siguiente");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("1.Eliminar owner por nombre ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("2.Eliminar owner por id ");
				System.out.println("3.Salir");
				
				while(userImput2 != 3) {
					userImput2 = reader.nextInt();
					reader.nextLine();
				
				if(userImput2 == 1) {
				System.out.println("Digite el id del club");
				String idClubsito = reader.nextLine();
				
				System.out.println("Digite el nombre del dueño");
				String nombreOwner = reader.nextLine();
				
				System.out.println("Digite el apellido del dueño");
				String apellidoParaco = reader.nextLine();
				
				system.delatedWithClubOwner(idClubsito, nombreOwner, apellidoParaco);
					}else if(userImput2 == 2) {
						System.out.println("Digite el id del club");
						String idClubsisos = reader.nextLine();
						
						System.out.println("Digite el id del owner");
						String idOwner1 = reader.nextLine();
						
						system.delatedWithClubOwnerNumber(idClubsisos, idOwner1);
					}else {
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear dueño");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al dueño :O");
						System.out.println("6.Eliminar a la mascota");
						System.out.println("7.Mostrar la informacion ordenada de los clubes");
						System.out.println("8.Mostrar la informacion ordenada de los owners");
						System.out.println("9. Mostrar la informacion ordenada de los pets");
						System.out.println("10.Salir del programa");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					}
				}
			}else if(inputUser == 6) {
				int userNumber3 = 0;
				
				System.out.println("Digite lo siguiente");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("1.Eliminar owner por nombre ");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("2.Eliminar owner por id ");
				System.out.println("3.Salir");
				
				while(userNumber3 != 3) {
					userNumber3 = reader.nextInt();
					reader.nextLine();
					
					if(userNumber3 == 1) {
						System.out.println("Digite el id del Club");
						String idClubsitos1 = reader.nextLine();
						
						System.out.println("Digite el idOwner");
						String idOwner1 = reader.nextLine();
						
						System.out.println("Digite el nombre de la mascota");
						String namePet = reader.nextLine();
						
						system.delatedWithClubWithPet(idClubsitos1, idOwner1, namePet);
					}else if(userNumber3 == 2) {
						System.out.println("Digite el id del club");
						String idClubsixos = reader.nextLine();
						
						System.out.println("Digite el id del Owner");
						String idOwnerss = reader.nextLine();
						
						System.out.println("Digite el id del pet");
						String idPetsito = reader.nextLine();
						
						system.delatedWithClubWithPetid(idClubsixos, idOwnerss, idPetsito);
						
					}else {
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear dueño");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al dueño :O");
						System.out.println("6.Eliminar a la mascota");
						System.out.println("7.Mostrar la informacion ordenada de los clubes");
						System.out.println("8.Mostrar la informacion ordenada de los owners");
						System.out.println("9. Mostrar la informacion ordenada de los pets");
						System.out.println("10.Salir del programa");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					}
					
					
				}
				
				
			}else if(inputUser == 7) {
				int userNumber = 0;
				
				
					
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("1.Mostrar club ordenados por id");
					System.out.println("2.Mostrar clubs ordenados por nombre");
					System.out.println("3.Mostrar clubs ordenados por Fechas");
					System.out.println("4.Mostrar clubs ordenados por tipo de animal");
					System.out.println("5.Mostrar clubes ordenados por numero de dueños");
					System.out.println("6.Salir");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

					while(userNumber != 6) {
						
						try {
						userNumber = reader.nextInt();
						reader.nextLine(); 
						
						if(userNumber == 1) { 
											
							system.ordenarClubesPorId();
							System.out.println(system.mostrarInfoOrdenado());
							
						}else if(userNumber == 2) {
							
							system.ordenarClubesPorNombre();
							System.out.println(system.mostrarInfoOrdenado());
							
						}else if(userNumber == 3) {
							
							system.ordenarFechas();
							System.out.println(system.mostrarInfoOrdenado());
							
						}else if(userNumber == 4){
							system.ordenateTypeOfAnimals();
							System.out.println(system.mostrarInfoOrdenado());
						}else if(userNumber ==5){
							system.ordenarClubesPorNumeroDeDueños();
							System.out.println(system.mostrarInfoOrdenado());
						}else {
							
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
							System.out.println("1.Crear club");
							System.out.println("2.Crear dueño");
							System.out.println("3.Crear mascota");
							System.out.println("4.Eliminas el clubsito");
							System.out.println("5.Eliminar al dueño :O");
							System.out.println("6.Eliminar a la mascota");
							System.out.println("7.Mostrar la informacion ordenada de los clubes");
							System.out.println("8.Mostrar la informacion ordenada de los owners");
							System.out.println("9. Mostrar la informacion ordenada de los pets");
							System.out.println("10.Salir del programa");
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	
						}
						
					}catch(InputMismatchException e) {
						e.getCause();
					}
						
					}
					
				
			}else if(inputUser == 8) {
				int userNumber = 0;
				
				
				
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("1.Mostrar owners ordenados por id");
				System.out.println("2.Mostrar owners ordenados por nombre primero");
				System.out.println("3.Mostrar owners ordenados por Fechas");
				System.out.println("4.Mostrar owners ordenados por tipo de animal");
				System.out.println("5.Mostrar owners ordenados por sus segundos nombres");
				System.out.println("6. Salir");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

				while(userNumber != 6) {
					
					try {
					userNumber = reader.nextInt();
					reader.nextLine(); 
					
					if(userNumber == 1) {
						System.out.println("Por favor digite el id del club");
						String idClubistoss = reader.nextLine();
						
						system.getMethodsSortWithCode(idClubistoss);
						System.out.println(system.mostrarInfo(idClubistoss));
						
					}else if(userNumber == 2) {
						System.out.println("Por favor digite el id del club");
						String id1 = reader.nextLine();
						
						system.getMethodsSortWithName(id1);
						System.out.println(system.mostrarInfo(id1));
						
					}else if(userNumber == 3) {
						System.out.println("Por favor digite el id del club");
						String id2 = reader.nextLine();
						
						system.getMethodsSortWithDates(id2);
						System.out.println(system.mostrarInfo(id2));
						
					}else if(userNumber == 4){
						System.out.println("Por favor digite el id del club");
						String id3 = reader.nextLine();
						
						system.getMethodsSortWithTypeOfAnimals(id3);
						System.out.println(system.mostrarInfo(id3));
						
					}else if(userNumber == 5) {
						System.out.println("Por favor digite el id del club");
						String id4 = reader.nextLine();
						
						system.getMethodsSortWithSecondNames(id4);
						System.out.println(system.mostrarInfo(id4));
						
						
					}else{
						
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear dueño");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al dueño :O");
						System.out.println("6.Eliminar a la mascota");
						System.out.println("7.Mostrar la informacion ordenada de los clubes");
						System.out.println("8.Mostrar la informacion ordenada de los owners");
						System.out.println("9. Mostrar la informacion ordenada de los pets");
						System.out.println("10.Salir del programa");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

					}
					
				}catch(InputMismatchException e) {
					e.getCause();
				}
					
				}
				
				
			}else if(inputUser == 9) {
				int userImput4 = 0;
				
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("1.Mostrar Pets ordenados por id");
				System.out.println("2.Mostrar Pets ordenados por nombre ");
				System.out.println("3.Mostrar owners ordenados por Fechas");
				System.out.println("4.Mostrar owners ordenados por tipo de animal");
				System.out.println("5.Mostrar owners ordenados por genero");
				System.out.println("6. Salir");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
				
				while(userImput4 != 6) {
					userImput4 = reader.nextInt();
					reader.nextLine();
					
					if(userImput4 == 1) {
						system.ordenarPorPetsId();
						System.out.println(system.mostrarInfoOrdenado3());
					}else if(userImput4 == 2) {
						system.ordenarPorNombrePets();
						System.out.println(system.mostrarInfoOrdenado3());
					}else if(userImput4 == 3) {
						system.ordenarPorDates();
						System.out.println(system.mostrarInfoOrdenado3());
					}else if(userImput4 == 4) {
						system.ordenarTipoDeMascota();
						System.out.println(system.mostrarInfoOrdenado3());
						
					}else if(userImput4 == 5) {
						system.ordenarPorGender();
						System.out.println(system.mostrarInfoOrdenado3());
					}else {
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear dueño");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al dueño :O");
						System.out.println("6.Eliminar a la mascota");
						System.out.println("7.Mostrar la informacion ordenada de los clubes");
						System.out.println("8.Mostrar la informacion ordenada de los owners");
						System.out.println("9. Mostrar la informacion ordenada de los pets");
						System.out.println("10.Salir del programa");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

					}
					
					
				}
				
				
				
				
			}else {
				System.out.println("Vuelva pronto!!!");
				for(Club miC: system.getClubs()) {
				miC.serializableOwner(); 
			}
			
		}
	}catch(InputMismatchException e) {
			System.out.println("Por favor digite una opcion valida" + "  " + e.getClass());
			reader.nextLine();
	}
			
			
		}//finalDelWhile
		
	}//FinalDeShowMenu
	

	public static void main(String[] args){
		Main m = new Main();
		m.showMenu();
	}

}
