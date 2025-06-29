package fa.training.entities;

public class Video extends Multimedia {
    public Video() {}

    public Video(String name, double duration) {
        super(name, duration);
    }

    public void createVideo() {
        super.createMultimedia();
    }

    @Override
    public String toString() {
        return "Video: Name = " + name + ", Duration = " + duration + " mins";
    }
}