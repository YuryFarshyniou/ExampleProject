import bean.Car;
import bean.Vehicle;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ExampleMainClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Car car = new Car();
        car.setSeats(7);
        Class<? extends Vehicle> carClass = car.getClass();
        System.out.println();
        Field seats = carClass.getDeclaredField("seats");
        seats.setAccessible(true);
        seats.set(car, 4);

        System.out.println(carClass.getDeclaredMethod("getVehicleInformation").invoke(car));

    }
}
