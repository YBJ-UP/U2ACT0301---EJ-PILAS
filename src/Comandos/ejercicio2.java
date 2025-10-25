package Comandos;

import java.util.Scanner;
import java.util.Stack;

public class ejercicio2 {
    private Stack<String> undo;
    private Stack<String> redo;
    private String currentText;

    public ejercicio2() {
        undo = new Stack<>();
        redo = new Stack<>();
        currentText = "";
    }

    private void write() {
        Scanner sc = new Scanner(System.in);
        String text;
        text = sc.nextLine();
        undo.push(currentText);
        currentText += text;
        redo.clear();
        getCurrentText();
    }

    private void undo(){
        if(!undo.isEmpty()) {
            redo.push(currentText);
            currentText = undo.pop();
            System.out.println("¡Acción deshecha con éxito!");
            getCurrentText();
        }else{
            System.out.println("No hay acciones por deshacer.");
        }
    }

    private void redo(){
        if(!redo.isEmpty()) {
            undo.push(currentText);
            currentText = redo.pop();
            System.out.println("¡Acción rehecha con éxito!");
            getCurrentText();
        }else{
            System.out.println("No hay acciones por rehacer.");
        }
    }

    private void getCurrentText() {
        System.out.println("Texto actual: " + currentText);
    }

    public void run(){
        boolean hasEnded = false;
        int option;
        Scanner sc = new Scanner(System.in);

        while (!hasEnded) {
            System.out.println("--------------------------------------------------");
            System.out.println("Menú de acciones");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Deshacer acción");
            System.out.println("3. Rehacer acción");
            System.out.println("0. Salir");

            System.out.println("Ingrese una opción:");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.print("Ingrese el texto que desea escribir: ");
                    write();
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    redo();
                    break;
                case 0:
                    hasEnded = true;
                    undo.clear();
                    redo.clear();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }
        }
    }
}
