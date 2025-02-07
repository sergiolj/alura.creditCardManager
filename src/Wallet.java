import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<CreditCard> creditCardList;

    public Wallet() {
        this.creditCardList = new ArrayList<CreditCard>();
    }
    public void addCreditCard(CreditCard c) {
        creditCardList.add(c);
    }
    public void removeCreditCard(CreditCard c) {
        creditCardList.remove(c);
    }
    public void listAll() {
        if (!creditCardList.isEmpty()) {
            for(int i=0;i<creditCardList.size();i++) {
                System.out.println("["+i+"]"+ creditCardList.get(i));
            }
        }else {
            System.out.println("\nNo credit cards found");
        }

    }

      public int getSize(){
        return creditCardList.size();
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }
}
