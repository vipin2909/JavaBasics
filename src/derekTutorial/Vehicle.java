package derekTutorial;

public class Vehicle extends Crashable implements Drivable, Cloneable {

    int numOfWheels = 2;
    double theSpeed = 0;

    int carStrength = 0;
    // the method inside implemened class of an interface must atleast as visible as inside an interface

    public int getWheel() {
        return this.numOfWheels;
    }
    public void setWheels(int numOfWs) {
        this.numOfWheels = numOfWs;
    }
    public double getSpeed() {
        return this.theSpeed;
    }
    public void setSpeed(double speedo) {
        this.theSpeed = speedo;
    }

    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }

    public Vehicle() {}

    public void setCarStrength(int carStrength) {
         this.carStrength = carStrength;
    }
    public int getCarStrength() {
        return this.carStrength;
    }
    @Override
    public String toString() {
        return "Num of Wheels " + this.numOfWheels;
    }

    public Object clone() {
        // catch the clone not supported exception which is catch only at compile time

        Vehicle car;
        try {
            car = (Vehicle)super.clone();
            System.out.println(super.getClass());
        }
        catch (CloneNotSupportedException e) {
             return null;

        }

        return car;
    }
}
