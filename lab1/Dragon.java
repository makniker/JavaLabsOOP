package lab1;

public class Dragon implements Vehicle{
    private final int speed = 50;
    @Override
    public int ride(int time) {
        return time * speed;
    }
    @Override
    public String getName() {
        return "Dragon";
    }
}
