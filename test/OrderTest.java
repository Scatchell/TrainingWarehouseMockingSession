import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OrderTest {
    public static final String WEAT = "weat";
    public static final String CORN = "corn";
    Warehouse warehouse;

    @Before
    public void setUp() throws Exception {
        warehouse = new Warehouse();
        warehouse.add(WEAT, 100);
        warehouse.add(CORN, 100);
    }

    @Test
    public void shouldFillOrderWhenEnoughInWarehouse() throws OrderDoesNotExistException {
        Order order = new Order(WEAT,100);
        order.fill(warehouse);
        assertTrue(order.filled());
        assertThat(warehouse.get(WEAT), is(0));
    }

    @Test
    public void shouldNotFillOrderWhenWarehouseDoesNotHaveInventory() throws OrderDoesNotExistException {
        Order order = new Order(WEAT,150);
        order.fill(warehouse);
        assertFalse(order.filled());
        assertThat(warehouse.get(WEAT), is(100));
    }
}
