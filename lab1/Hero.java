package lab1;

public class Hero {
    private final Road road;
    private IVehicle vehicle;
    Hero(int distance) {
        this.road = new Road(distance);
        this.vehicle = new Foot();
    }

    public void setVehicle(IVehicle IVehicle1) {
        this.vehicle = IVehicle1;
    }

    public boolean isRoadComplete(){
        return road.isComplete();
    }

    public void move(int time) {
        road.moveForward(vehicle.ride(time));
        System.out.println("Hero moves on the " + vehicle.getName() + " by " + time + " hours");
        System.out.println(road.getDistanceLeft() + " km left");
    }
}
