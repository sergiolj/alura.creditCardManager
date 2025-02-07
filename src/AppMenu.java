import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMenu {
    private boolean running = true;
    private final Scanner sc;
    private final Wallet wallet;

    public AppMenu(Wallet wallet) {
        this.wallet = wallet;
        this.sc = new Scanner(System.in);
    }

    public void show(){
        int option;

        while(running){
            System.out.println("\nWelcome to the App Menu");
            System.out.println("[1] Add Card");
            System.out.println("[2] List All My Credit Cards");
            System.out.println("[3] Define a Credit Card limit");
            System.out.println("[4] Add a purchase");
            System.out.println("[5] Remove a Credit Card");
            System.out.println("[6] List Credit Card Statement");
            System.out.println("[7] Exit");
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            // * If you not use the next line (sc.nextLine()) and read a String after that
            // * you will get an entry error without any warning. This must be used to clean up the buffer.
            sc.nextLine();

            switch (option) {
                case 1:
                    createCreditCard();
                    break;
                case 2:
                    showCreditCardList();
                    break;
                case 3:
                    alterCreditCardLimit();
                    break;
                case 4:
                    registerAPurchase();
                    break;
                case 5:
                    removeACreditCard();
                    break;
                case 6:
                    listCreditCardStatement();
                    break;
                case 7:
                    running = false;
                    break;
            }
        }
     sc.close();
    }

    private void listCreditCardStatement() {
        getCreditCard().getCreditCartStatement();
    }

    private void removeACreditCard() {
        System.out.println("Which Credit Card would you like to remove?");
        CreditCard cardToBeRemoved = getCreditCard();

        if (cardToBeRemoved.hasPurchases()) {
            System.out.println("You cannot remove a Credit Card with purchases");
        } else {
            System.out.println("Are you sure that you wan to remove this credit card? (s)");
            System.out.println(cardToBeRemoved);
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("s")) {
                wallet.removeCreditCard(cardToBeRemoved);
            } else {
                System.out.println("Operation cancelled");
            }
        }
    }

    private void registerAPurchase() {
        try{
            getCreditCard().buyRequest(makeAPurchase());
        }catch(NullPointerException e){
            System.out.println("You don't selected a valid credit card or a valid purchase");
        }
    }

    private Purchase makeAPurchase() {
        System.out.print("Item description: ");
        String description = sc.nextLine();

        System.out.print("Item price: ");
        double price = sc.nextDouble();

        Purchase item = new Purchase(description, price);
        System.out.println(item);
        return item;
    }

    private void showCreditCardList() {
        wallet.listAll();
    }

    private CreditCard getCreditCard() {
        CreditCard card = null;
        if(wallet.getSize()==1){
            card = wallet.getCreditCardList().getFirst();
        }else{
            System.out.println("Chose one Credit Card:");
            wallet.listAll();
            try{
                int choice = sc.nextInt();
                // * If you not use the next line (sc.nextLine()) and read a String after that
                // * you will get an entry error without any warning. This must be used to clean up the buffer.
                sc.nextLine();
                if(choice >=0 && choice < wallet.getSize()){
                    card = wallet.getCreditCardList().get(choice);
                }else {
                    System.out.println("Invalid choice");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice. Only integer allowed.");
            }
        }
        return card;
    }

    private void alterCreditCardLimit() {
        System.out.println("Select a Credit Card");
        wallet.listAll();
        CreditCard card = null;
        try{
            int choice = sc.nextInt();
            if(choice >=0 && choice < wallet.getSize()){
                card = wallet.getCreditCardList().get(choice);
            }else {
                System.out.println("Invalid choice");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice. Only integer allowed.");
        }

        if (card != null) {
            System.out.println("Inform new credit limit");
            try {
                double limit = sc.nextDouble();
                card.setLimit(limit);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid limit");
            }
        }
    }

    private void createCreditCard() {
        System.out.print("\nEnter the card Brand: ");
        String brand = sc.nextLine();
        try{
            System.out.print("Enter the card Limit: ");
            double limit = sc.nextDouble();
            CreditCard cc = new CreditCard(brand,limit);
            this.wallet.addCreditCard(cc);
        }catch (IllegalArgumentException e){
            System.out.println("Invalid Card Limit");
        }
    }
}
