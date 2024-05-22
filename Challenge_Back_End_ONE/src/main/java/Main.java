import java.util.Scanner;

public class Main {
    private static final String API_KEY = "https://v6.exchangerate-api.com/v6/c04268bca506dccfd2a9c580/latest/BRL";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        do {
            menu.displayMenu();
            int choice = menu.getUserChoice();
            if (choice == 0) {
                System.out.println("Saindo...");
                break;
            } else if (choice < 0 || choice > 8) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            String fromCurrency = "BRL"; // Real brasileiro
            String toCurrency;
            double result;
            double amount = menu.getAmount();

            switch (choice) {
                case 1:
                case 3:
                case 5:
                case 7:
                    toCurrency = getToCurrency(choice);
                    result = Converter.convertCurrency(toCurrency, amount, API_KEY);
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    toCurrency = "BRL"; // Real brasileiro
                    result = Converter.convertCurrency(toCurrency, amount, API_KEY);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            if (result != -1) {
                System.out.println("O valor convertido é: " + result);
                menu.registerLog(choice, amount, result);
            } else {
                System.out.println("Erro ao converter a moeda. Verifique sua conexão com a internet e tente novamente.");
            }

        } while (true);

        scanner.close();
    }

    private static String getToCurrency(int choice) {
        switch (choice) {
            case 1:
                return "USD"; // Dólar
            case 3:
                return "ARS"; // Peso argentino
            case 5:
                return "COP"; // Peso colombiano
            case 7:
                return "CLP"; // Peso chileno
            default:
                return "";
        }
    }
}
