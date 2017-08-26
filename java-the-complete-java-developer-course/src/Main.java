public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(300, false);

        printer.getPagesPrinted();

        printer.getTonerLevel();
        printer.print("This is only a test page", 4);
        printer.getTonerLevel();


        // Player Class
        // Player player = new Player();
        //
        // player.fullName = "Tim";
        // player.health = 20;
        // player.weapon = "Sword";
        //
        // int damage = 10;
        // player.loseHealth(damage);
        // System.out.println("Remaining health = " + player.healthRemaining());
        //
        // damage = 11;
        // player.loseHealth(damage);
        // System.out.println("Remaining health = " + player.healthRemaining());

        // Enhanced Player Class
        // EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Neevor",300, "Sword");
        //
        // int health = enhancedPlayer.getHealth();
        // System.out.println("health: " + health);


        // BankAccount bankAccount = new BankAccount(
        //         123456, 100, "Wojtek",
        //         "wojtek@argentus.pl", "123-456-789"
        // );
        //
        // BankAccount bankAccount1 = new BankAccount();
        //
        // bankAccount1.status();
        //
        // System.out.println(bankAccount.getAccountNum());
        //
        // bankAccount.setAccountNum(654321);
        //
        // System.out.println(bankAccount.getAccountNum());
        //
        // bankAccount.withdraw(10);
        // bankAccount.withdraw(100);
        //
        // bankAccount.deposit(30);
        //
        // bankAccount.status();

    }

}
