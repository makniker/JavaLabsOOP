package lab1;

public class Cart implements IVehicle {
    private final int speed = 7;
    @Override
    public int ride(int time) {
        return time * speed;
    }
    @Override
    public String getName() {
        return "Cart";
    }
}
