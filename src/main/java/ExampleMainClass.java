import java.util.List;

public class ExampleMainClass {
    public static void main(String[] args) {
        Class<List> listClass = List.class;
        System.out.println(listClass.getConstructors().toString());
        System.out.println("Hello From Honor!");

        System.out.println("Another Hello From pC!!!!");
    }
}
