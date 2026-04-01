public class WasteManagement extends Activity {
    private double wasteKg;

    public WasteManagement(double wasteKg) {
        super("Waste");
        this.wasteKg = wasteKg;
    }

    @Override
    public double calculateEmission() {
        return wasteKg * 0.30;
    }
}