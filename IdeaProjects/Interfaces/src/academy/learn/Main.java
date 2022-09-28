package academy.learn;

public class Main {

    public static void main(String[] args) {
	    ITelephone rashPhone;
        rashPhone = new DeskPhone(123456);
        rashPhone.powerOn();
        rashPhone.callPhone(123456);
        rashPhone.answer();

        rashPhone = new MobilePhone(123456);
       // rashPhone.powerOn();
        rashPhone.callPhone(123456);
        rashPhone.answer();

    }
}
