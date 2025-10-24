class Printer {
    public synchronized void printDocument(String userName, String documentName) {
        System.out.println(userName + " started printing: " + documentName);

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(userName + " printing page " + i + " of " + documentName);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted for " + userName);
        }

        System.out.println(userName + " finished printing: " + documentName);
        System.out.println("--------");
    }
}

class User extends Thread {
    private Printer printer;
    private String userName;
    private String documentName;

    public User(Printer printer, String userName, String documentName) {
        this.printer = printer;
        this.userName = userName;
        this.documentName = documentName;
    }

    @Override
    public void run() {
        printer.printDocument(userName, documentName);
    }
}

public class PrintQueueSimulation {
    public static void main(String[] args) {
        System.out.println("=== Office Print Queue Simulation ===\n");

        Printer sharedPrinter = new Printer();

        User user1 = new User(sharedPrinter, "Alice", "ProjectReport.pdf");
        User user2 = new User(sharedPrinter, "Bob", "InvoiceList.docx");
        User user3 = new User(sharedPrinter, "Charlie", "Presentation.pptx");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\n=== All print jobs completed ===");
    }
}
