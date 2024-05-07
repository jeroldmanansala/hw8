package hw8;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        CokeHandler cokeHandler = new CokeHandler();
        PepsiHandler pepsiHandler = new PepsiHandler();
        CheetosHandler cheetosHandler = new CheetosHandler();
        DoritosHandler doritosHandler = new DoritosHandler();
        KitKatHandler kitkatHandler = new KitKatHandler();
        SnickersHandler snickersHandler = new SnickersHandler();

        //chain of responsibility
        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitkatHandler);
        kitkatHandler.setNextHandler(snickersHandler);

        vendingMachine.setSnackDispenser(cokeHandler);

        while (true) {
        
            System.out.println("Which snack would you like to dispense?");
            System.out.println("1. Coke");
            System.out.println("2. Pepsi");
            System.out.println("3. Cheetos");
            System.out.println("4. Doritos");
            System.out.println("5. KitKat");
            System.out.println("6. Snickers");
            System.out.print("Enter a number (1-6): ");

            int input = scanner.nextInt();
            String snackName;
            switch (input) {
                case 1:
                    snackName = "Coke";
                    break;
                case 2:
                    snackName = "Pepsi";
                    break;
                case 3:
                    snackName = "Cheetos";
                    break;
                case 4:
                    snackName = "Doritos";
                    break;
                case 5:
                    snackName = "KitKat";
                    break;
                case 6:
                    snackName = "Snickers";
                    break;
                default:
                    System.out.println("Choose an available option");
                    continue;
            }

            System.out.print("Insert money: ");
            double money = scanner.nextDouble();

            vendingMachine.selectSnack(snackName);
            vendingMachine.insertMoney(money);
            vendingMachine.dispenseSnack();

            System.out.print("Continue? (yes/no): ");

            String dispenseAgain = scanner.next();

            if (!dispenseAgain.equalsIgnoreCase("yes")) {
                break;
            }
           
        }
        scanner.close();
    }
}
