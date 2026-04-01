public class ElectricityUsage extends Activity {
    private double units;

    public ElectricityUsage(double units) {
        super("Electricity");
        this.units = units;
    }

    @Override
    public double calculateEmission() {
        return units * 0.50;
    }
}