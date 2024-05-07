package hw8;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {

    @Test
    public void testStateTransitions() {
        VendingMachine vendingMachine = new VendingMachine();

        assertEquals(IdleState.class, vendingMachine.getCurrentState().getClass()); //idle state

        vendingMachine.selectSnack("Coke");
        
        assertEquals(WaitingForMoneyState.class, vendingMachine.getCurrentState().getClass()); //waiting state

        vendingMachine.insertMoney(2.00);
        assertEquals(DispensingSnackState.class, vendingMachine.getCurrentState().getClass()); //dispensing state

        vendingMachine.dispenseSnack();
        assertEquals(IdleState.class, vendingMachine.getCurrentState().getClass()); //back to idle after dispensing
    }
}
