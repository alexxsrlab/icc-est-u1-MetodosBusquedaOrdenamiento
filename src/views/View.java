package views;

import models.Person;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("*** MENU PRINCIPAL ***");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Agregar persona");
        System.out.println("3. Mostrar personas");
        System.out.println("4. Ordenar personas");
        System.out.println("5. Buscar persona");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }
    
    public int selectSearchCriterion() {
        System.out.println();
        System.out.println("***SELECCION UN CRITERIO DE BUSQUEDA***");
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por edad");
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }

    
    public Person inputPerson() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre: ");
        String name = scanner.nextLine();
    
        int age;
        while (true) {
            System.out.print("Ingrese la edad: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 0) {
                    break;
                } else {
                    System.out.println("Edad invalida solo se permiten valores positivos.");
                }
            } else {
                System.out.println(" Entrada invalida solo debe ingresar numeros");
                scanner.next(); 
            }
        }
    
        return new Person(name, age);
    }
    

    public String inputName() {
        System.out.print("Ingrese el nombre a buscar: ");
        return scanner.next();
    }

    public int inputAge() {
        System.out.print("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person.getName() + ", " + person.getAge() + " años");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void displayPersons(Person[] personas) {
        if (personas.length == 0) {
            System.out.println("No hay personas para mostrar.");
        } else {
            System.out.println("Lista de personas:");
            for (Person p : personas) {
                System.out.println(p.getName() + ", " + p.getAge() + " años");
            }
        }
    }

    public int selectSortingMethodAndOrder() {
        System.out.println();
        System.out.println("*** SELECCIONE UN METODO DE ORDENAMIENTO ***");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Seleccione una opcion: ");
        int method = scanner.nextInt();
        System.out.println();
        System.out.println("Seleccione el tipo de orden:");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        System.out.print("Seleccione una opcion: ");
        int order = scanner.nextInt();
        return method * 10 + order; 
    }
}


