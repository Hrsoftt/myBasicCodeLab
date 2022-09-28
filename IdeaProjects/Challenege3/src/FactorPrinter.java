public class FactorPrinter {

    public static void main(String[] args) {
        printFactor(6);
    }

    public static void printFactor(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            }


            int count = 1;
            while (number >= count) {
                if (number % count == 0) {
                    System.out.println(count);

                }
                count++;

            }
        }
    }

