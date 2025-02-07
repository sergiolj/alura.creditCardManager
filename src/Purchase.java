public class Purchase implements Comparable<Purchase> {
    private final Double price;
    private final String description;

    public Purchase(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Purchase [price=" + price + ", description=" + description + "]";
    }

    @Override
    public int compareTo(Purchase anotherPurchase) {
        return Double.compare(this.getPrice(), anotherPurchase.getPrice());
    }
}
