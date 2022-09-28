public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12,30));
    }
    public static int getGreatestCommonDivisor(int first,int second){
        if(first >=10 && second>=10){
            int count=0;
            int greatest = 0;
          for(int i =1; ((i <=first)&&(i <=second)); i++){
              if(first %i == 0 && (second % i == 0)){
                  greatest =i;
              }

          }return greatest;








        }return -1;
    }
}
