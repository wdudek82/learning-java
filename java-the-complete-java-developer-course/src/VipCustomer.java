public class VipCustomer {

    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer() {
        this.name = "Wojtek";
        this.creditLimit = 1000d;
        this.email = "wojtek@vip.pl";
    }

    public VipCustomer(String name, String email) {
        this.name = name;
        this.creditLimit = 0d;
        this.email = email;
    }

    public VipCustomer(String name, Double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditLimit(Double amount) {
        this.creditLimit = creditLimit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
