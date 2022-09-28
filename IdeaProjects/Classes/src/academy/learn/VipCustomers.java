package academy.learn;

public class VipCustomers {
    private String name;
    private double cardLimits;
    private String emailAddress;

    public VipCustomers() {
       this("Default name",10000.2,"Default email");
    }

    public VipCustomers(String name, double cardLimits) {
        this(name,cardLimits,"tayo@gmail.com");
    }

    public VipCustomers(String name, double cardLimits, String emailAddress) {
        this.name = name;
        this.cardLimits = cardLimits;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCardLimits() {
        return cardLimits;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
