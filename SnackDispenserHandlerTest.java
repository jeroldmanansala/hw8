package hw8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnackDispenserHandlerTest {

    @Test
    public void testDispenseSnack() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        assertEquals(4, vendingMachine.getSnack("Coke").getQuantity()); //quantity - 1

        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();
        assertEquals(6, vendingMachine.getSnack("Pepsi").getQuantity()); //insufficient funds

       
    }
    
    public void outOfStockTest() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        assertEquals(0, vendingMachine.getSnack("Snickers").getQuantity()); //out of stock
    }
}
