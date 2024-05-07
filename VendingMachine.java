package hw8;

import java.util.*;



interface StateOfVendingMachine {
    void selectSnack(String snackName);
    void insertMoney(double money);
    void dispenseSnack();
}

class VendingMachine {
    private StateOfVendingMachine currentState;
    private SnackDispenserHandler snackDispenser;

    private Map<String, Snack> snacks;
    private String selectedSnackName;
    private double selectedMoney;

    public VendingMachine() {
        currentState = new IdleState(this);
        snacks = new HashMap<>();
        snackDispenser = new CokeHandler(); 

        addSnack(new Snack("Coke", 2.00, 5));
        addSnack(new Snack("Pepsi", 2.00, 6));
        addSnack(new Snack("Cheetos", 1.50, 3));
        addSnack(new Snack("Doritos", 1.50, 2));
        addSnack(new Snack("KitKat", 1.25, 3));
        addSnack(new Snack("Snickers", 1.25, 1));
    }

    public void setState(StateOfVendingMachine state) {
        this.currentState = state;
    }
    
    public StateOfVendingMachine getCurrentState() {
        return currentState;
    }

    public void selectSnack(String snackName) {
        selectedSnackName = snackName;
        currentState.selectSnack(snackName);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack();
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name) {
        return snacks.get(name);
    }

    public void insertMoney(double money) {
        this.selectedMoney = money;
        currentState.insertMoney(money);
    }

    public String getSelectedSnackName() {
        return selectedSnackName;
    }

    public double getSelectedMoney() {
        return selectedMoney;
    }

    public void setSelectedMoney(double selectedMoney) {
        this.selectedMoney = selectedMoney;
    }

    public SnackDispenserHandler getSnackDispenser() {
        return snackDispenser;
    }

    public void setSnackDispenser(SnackDispenserHandler snackDispenser) {
        this.snackDispenser = snackDispenser;
    }
}

class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
        Snack selectedSnack = vendingMachine.getSnack(snackName);
        if (selectedSnack != null) {
            vendingMachine.setState(new WaitingForMoneyState(vendingMachine, selectedSnack));
        } else {
            System.out.println("Snack not available.");
        }
    }

    @Override
    public void insertMoney(double money) {
    }

    @Override
    public void dispenseSnack() {
    }
}

class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;
    private Snack selectedSnack;

    public WaitingForMoneyState(VendingMachine vendingMachine, Snack selectedSnack) {
        this.vendingMachine = vendingMachine;
        this.selectedSnack = selectedSnack;
    }

    @Override
    public void selectSnack(String snackName) {
    }

    @Override
    public void insertMoney(double money) {
        if (money >= selectedSnack.getPrice()) {
            vendingMachine.setState(new DispensingSnackState(vendingMachine));
        } else {
            System.out.println("Not enough money");
        }
    }

    @Override
    public void dispenseSnack() {
    }
}

class DispensingSnackState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(String snackName) {
    }

    @Override
    public void insertMoney(double money) {
    }

    @Override
    public void dispenseSnack() {
        vendingMachine.getSnackDispenser().dispenseSnack(vendingMachine.getSelectedSnackName(), vendingMachine);
        vendingMachine.setState(new IdleState(vendingMachine)); 
    }
}

