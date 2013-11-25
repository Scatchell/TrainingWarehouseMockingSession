public class Order {
    private final String name;
    private final int size;
    private boolean filled;

    public Order(String name, int size) {
        this.filled = false;

        this.name = name;
        this.size = size;
    }


    public void fill(Warehouse warehouse) throws OrderDoesNotExistException {
        if (warehouse.hasInventory(name, size)){
            warehouse.remove(name, size);
            this.filled = true;
        }
    }

    public boolean filled() {
        return filled;
    }
}
