import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Activity> activities;

    public User(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public String getName() {
        return name;
    }
}