
public class Purchase {
    private Double price;
    private String description;

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
}
