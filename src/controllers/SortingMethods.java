package controllers;
import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] persona, boolean ascendente) {
        int n = persona.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int comparaResultado = persona[j].getName().compareTo(persona[j + 1].getName());
                if ((ascendente && comparaResultado > 0) || (!ascendente && comparaResultado < 0)) {
                    Person temp = persona[j];
                    persona[j] = persona[j + 1];
                    persona[j + 1] = temp;
                }
            }
        }
    }


    public void sortByNameWithSelection(Person[] persona, boolean ascendente) {
        int n = persona.length;
        for (int i = 0; i < n - 1; i++) {
            int selectedIndex = i;
            for (int j = i + 1; j < n; j++) {
                int comparaResultado = persona[j].getName().compareTo(persona[selectedIndex].getName());
                if ((ascendente && comparaResultado < 0) || (!ascendente && comparaResultado > 0)) {
                    selectedIndex = j;
                }
            }
            Person temp = persona[i];
            persona[i] = persona[selectedIndex];
            persona[selectedIndex] = temp;
        }
    }

    public void sortByAgeWithInsertion(Person[] persona, boolean ascendente) {
        int n = persona.length;
        for (int i = 1; i < n; i++) {
            Person tem = persona[i];
            int j = i - 1;

            while (j >= 0 && ((ascendente && persona[j].getAge() > tem.getAge()) || 
                    (!ascendente && persona[j].getAge() < tem.getAge()))) {
                persona[j + 1] = persona[j];
                j--;
            }
            persona[j + 1] = tem;
        }
    }

    public void sortByNameWithInsertion(Person[] persona, boolean ascendente) {
        int n = persona.length;
        for (int i = 1; i < n; i++) {
            Person tem = persona[i];
            int j = i - 1;

            while (j >= 0 && ((ascendente && persona[j].getName().compareTo(tem.getName()) > 0) ||
                    (!ascendente && persona[j].getName().compareTo(tem.getName()) < 0))) {
                persona[j + 1] = persona[j];
                j--;
            }
            persona[j + 1] = tem;
        }
    }
}


