package lab1;

public class Foot implements IVehicle {
    private final int speed = 5;
    @Override
    public int ride(int time) {
        return time * speed;
    }
    @Override
    public String getName() {
        return "Foot";
    }
}
