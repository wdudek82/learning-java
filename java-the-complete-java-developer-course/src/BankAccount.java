public class BankAccount {

    private int accountNum;
    private int balance;
    private String customerName;
    private String email;
    private String phoneNum;

    BankAccount() {
        this.accountNum = 0;
        this.balance = 0;
        this.customerName = "";
        this.email = "";
        this.phoneNum = "";
    }

    BankAccount(int accountNum, int balance, String customerName, String email, String phoneNum) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        int result = this.balance - amount;

        System.out.print("Whitdrawing " + amount + "... ");

        if (result >= 0) {
            this.balance -= amount;
        } else {
            System.out.print("Insufficient funds! ");
        }

        this.status();
    }

    public void deposit(int amount) {
        System.out.print("Deposit " + amount + "... ");

        this.balance += amount;

        this.status();
    }

    public void status() {
        System.out.println("Balans is now: " + this.getBalance());
    }

}
