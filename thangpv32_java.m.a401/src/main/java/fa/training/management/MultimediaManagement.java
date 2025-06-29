package fa.training.management;

import fa.training.entities.Multimedia;
import java.util.*;

public class MultimediaManagement {
    private List<Multimedia> listOfMultimedia;

    public MultimediaManagement(List<Multimedia> listOfMultimedia) {
        this.listOfMultimedia = listOfMultimedia;
    }

    public void addMultimedia(Multimedia multimedia) {
        listOfMultimedia.add(multimedia);
    }

    public void displayMultimedia() {
        for (Multimedia m : listOfMultimedia) {
            System.out.println(m);
        }
    }
}