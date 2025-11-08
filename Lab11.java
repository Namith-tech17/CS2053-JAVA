import java.util.*;

@FunctionalInterface
interface ProductFormatter {
    String format(Product p);
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Price: ₹%.2f", id, name, price);
    }
}

public class Lab11 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", 85000));
        products.add(new Product(102, "Smartphone", 45000));
        products.add(new Product(103, "Headphones", 3000));
        products.add(new Product(104, "Monitor", 12000));
        products.add(new Product(105, "Keyboard", 2500));

        System.out.println(" Original Product List:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\n Sorted by Price (Low → High):");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("\n Sorted by Name (A → Z):");
        products.forEach(System.out::println);

        ProductFormatter formatter = (p) -> {
            return " Product: " + p.getName() + " costs ₹" + p.getPrice();
        };

        System.out.println("\n Formatted Product Details (using Lambda and Functional Interface):");
        products.forEach(p -> System.out.println(formatter.format(p)));
    }
}
