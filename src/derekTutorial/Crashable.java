package derekTutorial;

public abstract class Crashable {

    // abstract class means not all methods tends to be override compulsory
    boolean carDrivable = true;
    public void youCrashed() {
        this.carDrivable = false;
    }

    public abstract void setCarStrength(int carStrength);

    public abstract int getCarStrength();
}
