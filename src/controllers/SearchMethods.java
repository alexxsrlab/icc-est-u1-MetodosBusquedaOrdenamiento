package controllers;

import models.Person;

public class SearchMethods {

    public boolean isSortedByAge(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            if (personas[i - 1].getAge() > personas[i].getAge()) return false;
        }
        return true;
    }

    public boolean isSortedByName(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            if (personas[i - 1].getName().compareToIgnoreCase(personas[i].getName()) > 0) return false;
        }
        return true;
    }

    public Person binarySearchByAge(Person[] personas, int age) {
        int bajo = 0;
        int alto = personas.length - 1;
        while (bajo <= alto) {
            int mid = (bajo + alto) / 2;
            if (personas[mid].getAge() == age) return personas[mid];
            else if (personas[mid].getAge() < age) bajo = mid + 1;
            else alto = mid - 1;
        }
        return null;
    }

    public Person binarySearchByName(Person[] personas, String name) {
        int bajo = 0, alto = personas.length - 1;
        while (bajo <= alto) {
            int mid = (bajo + alto) / 2;
            int cmp = personas[mid].getName().compareToIgnoreCase(name);
            if (cmp == 0) return personas[mid];
            else if (cmp < 0) bajo = mid + 1;
            else alto = mid - 1;
        }
        return null;
    }
}