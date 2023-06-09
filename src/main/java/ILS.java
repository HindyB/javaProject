public class ILS extends Coin {
    private final double value = 0.27;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }
}