import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreditCard {
    private double limit;
    private final String cardBrand;
    private double debitAmount = 0.0;
    private final List<Purchase> statement;

    public CreditCard(String cardBrand, double limit) {
        this.cardBrand = cardBrand;
        this.limit = limit;
        statement = new ArrayList<>();
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
        this.statement.add(purchase);
    }

    public boolean verifyBalance(Purchase purchase) {
        return !(purchase.getPrice() > limit);
    }

    public boolean hasPurchases() {
        return !statement.isEmpty();
    }

    /**
     * This method uses the Collections class with Comparable<Purchases> to sort the statement list using the
     * rules defined in Purchase class @Override compareTo method.
     */
    public void sortStatement() {
        Collections.sort(this.statement);
    }

    public void getCreditCartStatement() {
        sortStatement();
        System.out.println("\n** Credit Card Statement **");
        System.out.println("____________________________________");
        if(hasPurchases()){
            for(Purchase item : statement){
                System.out.println((item.getDescription() + ": " + item.getPrice()));
            }
        }else{
            System.out.println("CreditCard Statement is empty");
        }
        System.out.println("____________________________________");
        System.out.println("Bill US$: " + this.getDebitAmount());
        System.out.println("Credit Limit Available US$: " + this.getLimit());
    }

    @Override
    public String toString() {
        return "Brand: "+ cardBrand+" - Limit US$: "+limit;
    }
}
