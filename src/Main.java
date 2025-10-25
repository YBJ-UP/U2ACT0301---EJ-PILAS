import Comandos.ejercicio2;
import Navegador.ejercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean hasEnded = false;
        Scanner sc = new Scanner(System.in);
        int option;

        while(!hasEnded){
            System.out.println("--------------------------------------------------");
            System.out.println("Elegir ejercicio:");
            System.out.println("1. Ejercicio de historial de navegación");
            System.out.println("2. Ejercicio de editor de texto");
            System.out.println("0. Salir");

            option = sc.nextInt();

            switch (option){
                case 0:
                    hasEnded = true;
                    break;
                case 1:
                    ejercicio historialDeNavegacion = new ejercicio();
                    historialDeNavegacion.run();
                    break;
                case 2:
                    ejercicio2 editorDeTexto = new ejercicio2();
                    editorDeTexto.run();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}