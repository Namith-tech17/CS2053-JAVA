class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title; 
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("📚 Book Title: " + this.title);
        System.out.println("✍️ Author: " + this.author);
        System.out.println("💲 Price: " + this.price);
        System.out.println("---------------------------");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", 450.0);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 650.5);
        Book b3 = new Book("Clean Code", "Robert C. Martin", 500.0);

        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
    }
}
