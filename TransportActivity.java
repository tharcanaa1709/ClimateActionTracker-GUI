public class TransportActivity extends Activity {
    private double distance;

    public TransportActivity(double distance) {
        super("Transport");
        this.distance = distance;
    }

    @Override
    public double calculateEmission() {
        return distance * 0.21;
    }
}