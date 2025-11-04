import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        ArrayList<Integer> marksList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Marks Menu:");
            System.out.println("1. Add Mark");
            System.out.println("2. View All Marks");
            System.out.println("3. Update Mark");
            System.out.println("4. Delete Mark");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter mark to add: ");
                    int markToAdd = scanner.nextInt();
                    marksList.add(markToAdd);
                    System.out.println("Mark added.");
                    break;

                case 2:
                    System.out.println("All Marks:");
                    Iterator<Integer> iterator = marksList.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;

                case 3:
                    System.out.print("Enter index to update: ");
                    int indexToUpdate = scanner.nextInt();
                    if (indexToUpdate >= 0 && indexToUpdate < marksList.size()) {
                        System.out.print("Enter new mark: ");
                        int newMark = scanner.nextInt();
                        marksList.set(indexToUpdate, newMark);
                        System.out.println("Mark updated.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Enter index to delete: ");
                    int indexToDelete = scanner.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < marksList.size()) {
                        marksList.remove(indexToDelete);
                        System.out.println("Mark deleted.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}