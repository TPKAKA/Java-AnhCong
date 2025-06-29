package fa.training.entities;

public abstract class Multimedia {
    protected String name;
    protected double duration;

    public Multimedia() {

    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void createMultimedia() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter duration (minutes): ");
        this.duration = Double.parseDouble(sc.nextLine());
    }

    @Override
    public abstract String toString();
}