import java.util.Scanner;

class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println(
                "(****************************************************************);\n" +
                        "██████╗ █████╗ ███╗   ███╗██████╗ ██╗ ██████╗ \n" +
                        "██╔════╝██╔══██╗████╗ ████║██╔══██╗██║██╔═══██╗\n" +
                        "██║     ███████║██╔████╔██║██████╔╝██║██║   ██║\n" +
                        "██║     ██╔══██║██║╚██╔╝██║██╔══██╗██║██║   ██║\n" +
                        "╚██████╗██║  ██║██║ ╚═╝ ██║██████╔╝██║╚██████╔╝\n" +
                        "╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═════╝ ╚═╝ ╚═════╝ \n" +
                        "\n" +
                        "1) Real brasileiro >> Dólar\n" +
                        "2) Dólar >> Real brasileiro\n" +
                        "3) Real brasileiro >> Peso argentino\n" +
                        "4) Peso argentino >> Real brasileiro\n" +
                        "5) Real brasileiro >> Peso colombiano\n" +
                        "6) Peso colombiano >> Real brasileiro\n" +
                        "7) Real brasileiro >> Peso chileno\n" +
                        "8) Peso chileno >> Real brasileiro\n" +
                        "0) Sair\n"
        );
    }

    public int getUserChoice() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public double getAmount() {
        System.out.print("Digite o valor a ser convertido: ");
        return scanner.nextDouble();
    }

    public void registerLog(int choice, double amount, double result) {
        // Implemente o registro de log, se necessário
    }
}
