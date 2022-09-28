public class Repeat {

    public static void main(String[] args) {
        System.out.println(getLargestCommonDivisor(12,13));
    }

     static int getLargestCommonDivisor(int first, int second){
         if(first<10&&second <10){
             return -1;
         }
         int Largest=0;
         int count =1;
         while(count<=first&&count<=second){
             if(first%count==0&&second%count==0){
               Largest=count;
             }
             count++;
         }return Largest;
     }
}
