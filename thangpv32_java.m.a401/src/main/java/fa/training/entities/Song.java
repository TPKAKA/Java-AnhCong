package fa.training.entities;

public class Song extends Multimedia {
    private String singer;

    public Song() {}

    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }

    public void createSong() {
        super.createMultimedia();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter singer: ");
        this.singer = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Song: Name = " + name + ", Duration = " + duration + " mins, Singer = " + singer;
    }
}

