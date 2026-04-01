public class CarbonCalculator {
    public static double calculateTotal(User user) {
        double total = 0;
        for (Activity activity : user.getActivities()) {
            total += activity.calculateEmission();
        }
        return total;
    }
}