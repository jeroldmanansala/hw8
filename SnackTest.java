package hw8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnackTest {
    
    private Snack snack;

    @BeforeEach
    public void setUp() {
        snack = new Snack("Tester", 2.25, 3);
    }

    @Test
    public void testGetName() {
        assertEquals("Tester", snack.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.25, snack.getPrice());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(3, snack.getQuantity());
    }

    @Test
    public void testDecreaseQuantity() {
        snack.decreaseQuantity();
        assertEquals(2, snack.getQuantity());
    }

 
}

