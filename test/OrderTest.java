import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OrderTest {
    public static final String WEAT = "weat";
    public static final String CORN = "corn";
    Warehouse warehouse;

    @Before
    public void setUp() throws Exception {
        warehouse = mock(Warehouse.class);
    }

    @Test
    public void shouldFillOrderWhenEnoughInWarehouse() throws OrderDoesNotExistException {
        Order order = new Order(WEAT,100);
        when(warehouse.hasInventory(WEAT, 100)).thenReturn(true);
        order.fill(warehouse);
        assertTrue(order.filled());
        verify(warehouse).remove(WEAT, 100);
    }

    @Test
    public void shouldNotFillOrderWhenWarehouseDoesNotHaveInventory() throws OrderDoesNotExistException {
        Order order = new Order(WEAT,150);
        when(warehouse.hasInventory(WEAT, 150)).thenReturn(false);
        order.fill(warehouse);
        assertFalse(order.filled());
        verify(warehouse, never()).remove(anyString(), anyInt());
    }
}
