import java.util.ArrayList;

class Box<T> {       
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public void displayValue() {
        System.out.println("Stored Value: " + value);
    }
}

public class Lab8 {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>(25);      
        Box<String> strBox = new Box<>("Hello Generics");
        Box<Double> doubleBox = new Box<>(19.5);  

        System.out.println("Displaying Box Values:");
        intBox.displayValue();
        strBox.displayValue();
        doubleBox.displayValue();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);   
        numbers.add(20);
        numbers.add(30);

        System.out.println("\nArrayList of Numbers:");
        for (Integer num : numbers) {
            System.out.println(num);
        }
    }
}

