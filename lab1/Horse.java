package lab1;

public class Horse implements IVehicle {
    private final int speed = 10;
    @Override
    public int ride(int time) {
        return time * speed;
    }
    @Override
    public String getName() {
        return "Horse";
    }
}
