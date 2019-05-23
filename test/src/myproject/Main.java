package myproject;

import java.util.ArrayList;
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
                    System.out.println("Ingrese por favor el numero de la cuenta");
                    String numberAccount = in.next();
                    if (numberAccount.length() != 4) {
                        System.out.println("La cuenta debe tener 4 digitos");
                    } else {
                        System.out.println("Ingrese el nuevo saldo de la cuenta");
                        double newBalance=in.nextDouble();
                        try{
                          changeBalance(Integer.parseInt(numberAccount), newBalance); 
                          System.out.println("se ha realizado el cambio de saldo con exito"); 
                        }catch(Exception e ){
                            System.out.println("No se pudo realizar la operacion");
                        }
                      
                        
                    }
                    
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
        database.add(null);
        
    }

    private static void exitMessague() {

    }

    private static void changeBalance(int account,double newBalance) {
  Account account=database.get(account);
  account.setBalance(newBalance);
    
    }

    private static void deleteAccount() {

    }
    private static void showAllAccounts(){
        for (Account a:database){
            System.out.println(a.toString());
        }
    }

}
