public class USD extends Coin {
    private final double value = 3.61;

    @Override
    public double getValue(){
        return value;
        }

    @Override
    public double calculate(double input){
        return input * getValue();
    }
}