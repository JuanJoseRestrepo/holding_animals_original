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
		System.out.println("2.Crear due�o");
		System.out.println("3.Crear mascota");
		System.out.println("4.Eliminas el clubsito");
		System.out.println("5.Eliminar al due�o :O");
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
				
				System.out.println("Digite el id del Club que va agregar al due�o");
				String idnameClub = 
				reader.nextLine();
				
				System.out.println("Digite el id del due�o");
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
				
				System.out.println(system.findClubForOwner(idnameClub, idCli, Cliname, CliSecond, typeOfPet, bornD));
			
			}else if(inputUser == 3) {
				
			}else if(inputUser == 4) {
				
			}else if(inputUser == 5) {
				
			}else if(inputUser == 6) {
				
			}else if(inputUser == 7) {
				int userNumber = 0;
				
				
					
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("1.Mostrar club ordenados por id");
					System.out.println("2.Mostrar clubs ordenados por nombre");
					System.out.println("3.Mostrar clubs ordenados por Fechas");
					System.out.println("4.Mostrar clubs ordenados por tipo de animal");
					System.out.println("5.Salir");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

					while(userNumber != 5) {
						
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
						}else{
							
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
							System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
							System.out.println("1.Crear club");
							System.out.println("2.Crear due�o");
							System.out.println("3.Crear mascota");
							System.out.println("4.Eliminas el clubsito");
							System.out.println("5.Eliminar al due�o :O");
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
					}else{
						
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
						System.out.println("1.Crear club");
						System.out.println("2.Crear due�o");
						System.out.println("3.Crear mascota");
						System.out.println("4.Eliminas el clubsito");
						System.out.println("5.Eliminar al due�o :O");
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
				
			}else {
				System.out.println("Vuelva pronto!!!");
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