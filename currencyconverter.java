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

        double converted = convert(amount, from, to);

        System.out.printf("%.2f %s = %.2f %s\n", amount, from, converted, to);

        scanner.close();
    }

    public static double convert(double amount, String from, String to) {
        double rate = 1.0;

        // Currency rates AUD, USD, EUR and INR
        if (from.equals("USD") && to.equals("EUR")) rate = 0.92;
        else if (from.equals("USD") && to.equals("INR")) rate = 83.0;
        else if (from.equals("AUD") && to equals("USD")) rate = 0.65;
        else if (from.equals("USD") && to equals("AUD")) rate = 1.55;
        else if (from.equals("EUR") && to equals("AUD")) rate = 1.79;
        else if (from.equals("AUD") && to equals("EUR")) rate = 0.56;
        else if (from.equals("EUR") && to.equals("USD")) rate = 1.09;
        else if (from.equals("EUR") && to.equals("INR")) rate = 90.0;
        else if (from.equals("INR") && to.equals("USD")) rate = 0.012;
        else if (from.equals("INR") && to.equals("EUR")) rate = 0.011;
        // Same currency
        else if (from.equals(to)) rate = 1.0;

        return amount * rate;
    }
}
