package academy.learn;

public class Main {

    public static void main(String[] args) {
	    int count =0;
        while(count != 5){
            System.out.println("Count value is "+count);
            count++;
        }

        count =1;
        while (true){
            if(count==6){
                break;
            }
            System.out.println("Count value is "+count);
            count++;
        }
        count=6;
        System.out.println("**********************");
        do{
            System.out.println("Count value is "+count);
            count++;

            if (count >100){
                break;
            }
        }while (count!=6);
    }
}
