
public class Main {
    public static void main(String[] args) {

        Wallet wallet = new Wallet();
        var menu = new AppMenu(wallet);
        menu.show();

//        CreditCard myCard = new CreditCard("Visa", 1500);
//        System.out.println(myCard.getLimit());
//        CreditCard myCard2 = new CreditCard("Master",20000);
//
//        myCard.buyRequest(new Purchase("Shoe",50));
//        myCard.buyRequest(new Purchase("T-shirt",150));
//        myCard.buyRequest(new Purchase("Pants",250));
//        myCard.buyRequest(new Purchase("Watch",700));
//        myCard.getCreditCartStatement();
//        Purchase item2 = new Purchase("Blusa",100);
//        Purchase item3 = new Purchase("Tenis",150);
//        wallet.addCreditCard(myCard);
//        wallet.addCreditCard(myCard2);
//
//        wallet.getCreditCardList();
//        System.out.println(wallet.getCreditCardList().getFirst());
    }
}