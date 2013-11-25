import java.util.HashMap;

public class Warehouse {
    private HashMap<String, Integer> orders;

    public Warehouse() {
        orders = new HashMap<String, Integer>();
    }

    public void add(String orderName, int orderSize) {
        if (orders.containsKey(orderName)) {
            orders.put(orderName, orders.get(orderName) + orderSize);
        } else {
            orders.put(orderName, orderSize);
        }
    }

    public int get(String orderName) {
        return orders.get(orderName);
    }

    public void remove(String orderName, int orderSize) throws OrderDoesNotExistException {
        if (orders.containsKey(orderName)) {
            orders.put(orderName, orders.get(orderName) - orderSize);
        } else {
            throw new OrderDoesNotExistException();
        }
    }

    public boolean hasInventory(String orderName, int orderSize) {
        return orders.containsKey(orderName) ? orders.get(orderName) >= orderSize : false;
    }
}
