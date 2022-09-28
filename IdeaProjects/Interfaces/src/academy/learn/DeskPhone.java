package academy.learn;

public class DeskPhone implements ITelephone{

    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing "+ phoneNumber + " on desk phone");
    }

    @Override
    public void answer() {
        if (isRinging){
            System.out.println("Answering the desk phone");
            isRinging=true;
        }

    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber){
            isRinging=true;
        }else{
            isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
