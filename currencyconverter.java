import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Currency Converter ====");
        System.out.println("Available currencies: USD, EUR, INR");
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("From currency: ");
        String from = scanner.next().toUpperCase();

        System.out.print("To currency: ");
        String to = scanner.next().toUpperCase();

        System.out.println("Conversion feature coming soon!");

        scanner.close();
    }
}
