package hw8;

abstract class SnackDispenserHandler {
    private SnackDispenserHandler nextHandler;

    public void setNextHandler(SnackDispenserHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void dispenseSnack(String snackName, VendingMachine vendingMachine) {
        SnackDispenserHandler currentHandler = this;
    
        while (currentHandler != null) {
            if (currentHandler.represents(snackName)) {
                Snack snack = vendingMachine.getSnack(snackName);
                double insertedMoney = vendingMachine.getSelectedMoney();
                double price = snack.getPrice();
    
                if (snack != null && snack.getQuantity() > 0) {
                    if (insertedMoney >= price) {
                        // change calculations
                        double change = insertedMoney - price;
                        System.out.println("Dispensing " + snack.getName());
                        if (change > 0) {
                            System.out.println("Change: " + change);
                        }
                        snack.decreaseQuantity();
                    } else {
                        System.out.println("Not enough money");
                    }
                    return;
                } else {
                    System.out.println(snackName + " is out of stock");
                    return;
                }
            } else {
                System.out.println("Next handler...");
            }
    
            currentHandler = currentHandler.nextHandler;
        }
    }
    
    abstract boolean represents(String snackName);
}

class CokeHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "Coke".equals(snackName);
    }
}

class PepsiHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "Pepsi".equals(snackName);
    }
}

class CheetosHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "Cheetos".equals(snackName);
    }
}

class DoritosHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "Doritos".equals(snackName);
    }
}

class KitKatHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "KitKat".equals(snackName);
    }
}

class SnickersHandler extends SnackDispenserHandler {
    @Override
    boolean represents(String snackName) {
        return "Snickers".equals(snackName);
    }
}
