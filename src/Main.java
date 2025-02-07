public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        var menu = new AppMenu(wallet);
        menu.show();
    }
}