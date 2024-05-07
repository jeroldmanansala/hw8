package hw8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testSelectSnack() {
        vendingMachine.selectSnack("Coke");
        assertEquals("Coke", vendingMachine.getSelectedSnackName());
    }

    @Test
    public void testInsertMoney() {
        vendingMachine.insertMoney(2.50);
        assertEquals(2.50, vendingMachine.getSelectedMoney(), 0.01);
    }

    @Test
    public void testDispenseSnack() {
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        assertTrue("Coke".equalsIgnoreCase(vendingMachine.getSelectedSnackName()));
    }
}
