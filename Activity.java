public abstract class Activity {
    protected String name;

    public Activity(String name) {
        this.name = name;
    }

    public abstract double calculateEmission();

    public String getName() {
        return name;
    }
}