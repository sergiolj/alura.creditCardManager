
import java.util.HashMap;
import java.util.Map;

public class CreditCard {
    private double limit;
    private String cardBrand;
    private double debitAmount = 0.0;
    private final Map<String, Double> statement;

    public CreditCard(String cardBrand, double limit) {
        this.cardBrand = cardBrand;
        this.limit = limit;
        statement = new HashMap<>();
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void buyRequest(Purchase purchase) {
        if(verifyBalance(purchase)){
            this.limit -= purchase.getPrice();
            this.debitAmount += purchase.getPrice();
            addPurchase(purchase);
        }else{
            System.out.println("You don't have enough money");
        }
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    private void addPurchase(Purchase purchase) {
        this.statement.put(purchase.getDescription(), purchase.getPrice());
    }

    public boolean verifyBalance(Purchase purchase) {
        return !(purchase.getPrice() > limit);
    }

    public void getCreditCartStatement() {
        System.out.println("\nCredit Card Statement:\n");
        System.out.println("____________________________________");
        for(Map.Entry<String, Double> item : statement.entrySet()){
            System.out.println(item.getKey() + ": " + item.getValue());
        }
        System.out.println("_____________________________________");
        System.out.println("Bill: " + this.getDebitAmount());
        System.out.println("Credit Limit available: " + this.getLimit());
    }

    @Override
    public String toString() {
        return cardBrand+" "+limit;
    }
}
