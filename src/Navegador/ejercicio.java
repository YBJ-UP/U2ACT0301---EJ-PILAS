package Navegador;
import java.util.Scanner;
import java.util.Stack;

public class ejercicio {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentUrl;

    public ejercicio() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentUrl = "";
    }

    public void newUrl() {
        Scanner sc = new Scanner(System.in);
        String url = sc.nextLine();
        if (currentUrl != null) {
            backStack.push(currentUrl);
        }
        forwardStack.clear();
        currentUrl = url;
        getCurrentUrl();
    }

    public void goBack(){
        if (!backStack.isEmpty()){
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
        }else{
            System.out.println("No hay un URL anterior");
            return;
        }
        getCurrentUrl();
    }

    public void goForward(){
        if (!forwardStack.isEmpty()){
            backStack.push(currentUrl);
            currentUrl = forwardStack.pop();
        }else{
            System.out.println("No hay un URL adelante");
            return;
        }
        getCurrentUrl();
    }

    public void getCurrentUrl() {
        if (currentUrl != "") {
            System.out.println("El URL actual es: " + currentUrl);
        }else{
            System.out.println("No hay URL");
        }
    }

    public void run(){
        boolean hasEnded = false;
        int option;
        Scanner sc = new Scanner(System.in);

        while (!hasEnded) {
            System.out.println("--------------------------------------------------");
            System.out.println("Menú de acciones");
            System.out.println("1. Ingresar url");
            System.out.println("2. Retroceder página");
            System.out.println("3. Avanzar página");
            System.out.println("0. Salir");

            System.out.println("Ingrese una opción:");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.print("Ingrese el URL al que desea navegar: ");
                    newUrl();
                    break;
                case 2:
                    goBack();
                    break;
                case 3:
                    goForward();
                    break;
                case 0:
                    hasEnded = true;
                    backStack.clear();
                    forwardStack.clear();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }
        }
    }
}
