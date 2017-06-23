package framework.cars.model;

/**
 * Created by User on 23.06.2017.
 */
public class Car {
    public String make;
    public String model;
    public String year;
    public String engine;
    public String transmission;

    public Car(){}

    public Car(String make, String model, String year, String engine, String transmission) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.transmission = transmission;
    }
}
