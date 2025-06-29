package fa.training.main;

import fa.training.entities.*;
import fa.training.management.MultimediaManagement;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MultimediaManagement manager = new MultimediaManagement(new ArrayList<>());

        while (true) {
            System.out.println("\n1. Add Song");
            System.out.println("2. Add Video");
            System.out.println("3. Display All");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Song song = new Song();
                    song.createSong();
                    manager.addMultimedia(song);
                    break;
                case 2:
                    Video video = new Video();
                    video.createVideo();
                    manager.addMultimedia(video);
                    break;
                case 3:
                    manager.displayMultimedia();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
