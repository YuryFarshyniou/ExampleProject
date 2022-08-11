import bean.Car;
import bean.Vehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExampleMainClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,  InstantiationException, ClassNotFoundException {
        Car someCar = Car.class.getDeclaredConstructor().newInstance();
        Class<? extends Car> carCl = someCar.getClass();
         carCl.getDeclaredMethod("someMethod",String.class, int.class).invoke(someCar,"Ford",70);


        Car car = null;
        Class<?> carClass = Class.forName(Car.class.getName());
        Class[]params = {Integer.class,Vehicle.class};
        Car vehicle = Car.class.getDeclaredConstructor().newInstance();
        car = (Car) carClass.getDeclaredConstructor(params).newInstance(4,vehicle );
        car.setSeats(5);
        System.out.println(car.getSeats());

        Constructor<?>[] constructors = carClass.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
            Class[] parameterTypes = constructor.getParameterTypes();
            for(Class param:parameterTypes){
                System.out.println(param);
            }
        }

    }
}
