public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(
                123456, 100, "Wojtek",
                "wojtek@argentus.pl", "123-456-789"
        );

        BankAccount bankAccount1 = new BankAccount();

        bankAccount1.status();

        System.out.println(bankAccount.getAccountNum());

        bankAccount.setAccountNum(654321);

        System.out.println(bankAccount.getAccountNum());

        bankAccount.withdraw(10);
        bankAccount.withdraw(100);

        bankAccount.deposit(30);

        bankAccount.status();

    }

}
