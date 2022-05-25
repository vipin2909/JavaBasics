// cloneable is used to make the methods and classes cloneable
public class Vehicle extends Crashable implements Drivable, Cloneable {
    int numOfWheels = 2;
    double theSpeed = 0;
    int carStrength = 0;
    public int getWheel() {
        return this.numOfWheels;
    }
    public void setWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }
    public double getSpeed() {
        return this.theSpeed;
    }
    public void setSpeed(double theSpeed) {
        this.theSpeed = theSpeed;
    }
    public Vehicle() {

    }
    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }
    public void setCarStrength(int carStrength) {
           this.carStrength = carStrength;
    }
    @Override
    public String toString() {
        return "Num of wheels " + this.numOfWheels;
    }

    public int getCarStrength() {
        return this.carStrength;
    }
    public Object clone() {
        Vehicle car;

        try{
            car = (Vehicle)super.clone();
        }
        catch(CloneNotSupportedException e) {
            return null;
        }
        return car;
    }
}
