import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WarehouseTest {

    public static final String WHEAT = "wheat";
    public static final String CORN = "corn";

    @Test
    public void shouldAddOrdersToWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.add(WHEAT, 50);
        assertThat(warehouse.get(WHEAT), is(50));
    }

    @Test
    public void shouldAddToExistingOrdersInWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.add(WHEAT, 50);
        warehouse.add(WHEAT, 50);
        assertThat(warehouse.get(WHEAT), is(100));
    }

    @Test
    public void shouldBeAbleToAddMultipleOrdersToWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.add(WHEAT, 50);
        warehouse.add(CORN, 50);
        assertThat(warehouse.get(WHEAT), is(50));
        assertThat(warehouse.get(CORN), is(50));
    }

    @Test
    public void shouldRemoveOrdersFromWarehouse() throws OrderDoesNotExistException {
        Warehouse warehouse = new Warehouse();
        warehouse.add(WHEAT, 100);
        warehouse.remove(WHEAT, 50);
        assertThat(warehouse.get(WHEAT), is(50));
    }

    @Test(expected = OrderDoesNotExistException.class)
    public void shouldThrowExceptionWhenRemovingOrderWhichDoesNotExist() throws OrderDoesNotExistException {
        Warehouse warehouse = new Warehouse();
        warehouse.remove(CORN, 50);
    }
}
