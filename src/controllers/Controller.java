package controllers;

import models.Person;
import controllers.SortingMethods;
import views.View;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private View vista;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private ArrayList<Person> personas;
    private Scanner scanner;

    public Controller(View vista, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.vista = vista;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.personas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option = -1;
        while (option != 6) {
            option = vista.showMenu();

            if (option == 1) {
                inputPersons();
            } else if (option == 2) {
                addPersons();
            } else if (option == 3) {
                vista.displayPersons(personas.toArray(new Person[personas.size()]));
            } else if (option == 4) {
                sortPersons();
            } else if (option == 5) {
                searchPerson();
            } else if (option == 6) {
                System.out.println("Gracias por usar la aplicacion.");
            } else {
                System.out.println("Opción invalida.");
            }
        }
    }

    public void inputPersons() {
        System.out.print(" Cuantas personas desea ingresar = ");
        int contar = scanner.nextInt();

        for (int i = 0; i < contar; i++) {
            Person persona = vista.inputPerson();
            personas.add(persona);
        }
    }

    public void addPersons() {
        Person persona = vista.inputPerson();
        personas.add(persona);
    }

    public void sortPersons() {
        Person[] personitas = personas.toArray(new Person[personas.size()]);
        int option = vista.selectSortingMethodAndOrder();

        int method = option / 10;  
        int order = option % 10;   

        boolean ascendente = (order == 1);

        switch (method) {
            case 1: 
                sortingMethods.sortByNameWithBubble(personitas, ascendente);
                break;
            case 2: 
                sortingMethods.sortByNameWithSelection(personitas, ascendente);
                break;
            case 3: 
                sortingMethods.sortByAgeWithInsertion(personitas, ascendente);
                break;
            case 4: 
                sortingMethods.sortByNameWithInsertion(personitas, ascendente);
                break;
            default:
                System.out.println("Metodo de ordenamiento invalido.");
                return;
        }

        personas.clear();
        for (Person persona : personitas) {
            personas.add(persona);
        }

        System.out.println("Personas ordenadas correctamente.");
        vista.displayPersons(personas.toArray(new Person[personas.size()]));
    }

    public void searchPerson() {
        Person[] personitas = personas.toArray(new Person[personas.size()]);
        int option = vista.selectSearchCriterion();

        if (option == 1) {
            if (!searchMethods.isSortedByName(personitas)) {
                sortingMethods.sortByNameWithBubble(personitas, true);  
            }
            String name = vista.inputName();
            Person encontro = searchMethods.binarySearchByName(personitas, name);
            vista.displaySearchResult(encontro);

        } else if (option == 2) {
            if (!searchMethods.isSortedByAge(personitas)) {
                sortingMethods.sortByAgeWithInsertion(personitas, true); 
            }
            int age = vista.inputAge();
            Person encontro = searchMethods.binarySearchByAge(personitas, age);
            vista.displaySearchResult(encontro);

        } else {
            System.out.println("Opcion invalida.");
        }
    }
}




