package lab1;

public class Road {
    Road(int distance){
        this.distance = distance;
        this.position = 0;
    }
    private int position;
    private final int distance;
    void moveForward(int distance) {
        if (distance > 0)
        {
            this.position += distance;
        }
    }
    boolean isComplete(){
        return position >= distance;
    }
    int getDistanceLeft(){
        return position > distance ? 0 : distance - position;
    }
}
