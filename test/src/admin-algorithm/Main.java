package myproject;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static ArrayList<Account> database;

    public static void main(String[] args) {
        boolean exit = false;

        database = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Hola de nuevo admin");

        while (!exit) {
            int option = -1;
            boolean ok;
            System.out.println("\n\nLas siguientes opciones son las que su cuenta tiene permitidas");
            System.out.println("   0.  Salir");
            System.out.println("   1.  Ingresar una cuenta nueva ");
            System.out.println("   2.  Modificar saldo de una cuenta existente");
            System.out.println("   3.  Eliminar un cuenta existente");
            System.out.println("   4.  Ver todas las cuentas");
            ok = false;
            do {
                try {
                    System.out.print("Ingresa la opcion que se desea realizar : ");
                    option = in.nextInt();

                    if (option < 0 || option > 3) {
                        System.out.println("favor ingresar un numero en el rango de opciones");
                        ok = false;
                    } else {
                        ok = true;
                    }

                } catch (Exception e) {
                    System.out.println("Error: favor ingresar un numero entero");
                    return;
                }
            } while (!ok);

            switch (option) {
                case 0:
                    exitMessague();
                    exit = true;
                    break;
                case 1:
                    createAccount();
                    break;
                case 2:
                  changeBalance();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    showAllAccounts();
                default:
                    break;
            }
        }
    }

   
        
   
        


			
			
		

	
	
	private static void createAccount() {
		System.out.println("Seleccionaste la opcion 1");
		
		String newAccountNumber;
		double newBalance = 0;
		boolean ok = false;
		
		
		// ingresar numero de cuenta
		do {
			try { 
				Scanner in = new Scanner(System.in).useLocale(Locale.US);;
				System.out.print("Ingresa una cuenta (4 digitos) : ");
				newAccountNumber = in.nextLine();
				
				if (!newAccountNumber.matches("[0-9]+")) {
					System.out.println("favor ingresar digitos");
				} else if (newAccountNumber.length() != 4) {
					System.out.println("favor ingresar 4 digitos");
				} else if (doesAccountExists(Integer.parseInt(newAccountNumber))) {
					System.out.println("El usuario ya existe!");
				} else {
					ok = true;
				}					
			} catch (Exception e) {
				System.out.println("Error: ");
				return;
			}
		} while (!ok);
		
		
		// ingresar nuevo balance
		ok = false;
		do {
			try { 
				Scanner in = new Scanner(System.in).useLocale(Locale.US);;
				System.out.print("Ingresa balance incial : ");
				newBalance = in.nextDouble();
				
				if (newBalance < 0) {
					System.out.println("favor ingresar balance positivo");
				} else {
					ok = true;
				}					
			} catch (Exception e) {
				System.out.println("Favor ingresar un numero real");
			}
		} while (!ok);
		
		int accountNumber = Integer.parseInt(newAccountNumber) ;
		database.add(new Account(accountNumber , newBalance));
		
		System.out.println("Se creo una nueva cuenta");
		System.out.println("Numero : " + accountNumber);
		System.out.println("Balance : " + newBalance);
	}
	
	private static void exitMessague() {
		System.out.println("Bye admin!");
	}
	
	
	private static void changeBalance() {
            boolean ok=false;
            Scanner in =new Scanner (System.in);
            do{
                System.out.println("Ingrese por favor el numero de la cuenta");
                    String numberAccount = in.next();
                    if (numberAccount.length() != 4) {
                        System.out.println("La cuenta debe tener 4 digitos");
                    } else {
                        System.out.println("Ingrese el nuevo saldo de la cuenta");
                        
                        try{
                            double newBalance=in.nextDouble();
                          changeBalanceAux(Integer.parseInt(numberAccount), newBalance); 
                          System.out.println("se ha realizado el cambio de saldo con exito"); 
                          ok=true;
                        }catch(Exception e ){
                            System.out.println("No se pudo realizar la operacion");
                        }
                      
                        
                    }
            }while(!ok);
		  
                    
	}
	
	private static void deleteAccount() {
		
	}
	
	
	private static boolean doesAccountExists(int accountNumber) {
		for (Account a : database) 
			if (a.getAccountNumber() == accountNumber)
				return true;
		return false;
		
	}
	
	

   

 

    private static void changeBalanceAux(int account,double newBalance) throws Exception {
if(newBalance<0)throw new Exception();
if (account<0 || account >database.size())throw new Exception();
  Account theaccount=database.get(account);
  theaccount.setBalance(newBalance);
    
    }

  
    private static void showAllAccounts(){
        for (Account a:database){
            System.out.println(a.toString());
        }
    }


}
