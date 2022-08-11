package bean;

public  abstract class Vehicle {
    private String engine;
    private int wheels;

    public abstract String getVehicleInformation();

    public void customMethod(){
        this.engine = "SuperEngine";
        System.out.println(this.engine);
    }

}
