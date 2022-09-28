public class MegaBytesConverter {

    public static void printMegaByteAndKiloByte(int kiloByte){
        if (kiloByte <0){
            System.out.println("Invalid Value");
        }else {
            long kilo = (kiloByte/1024);
            int remain = (kiloByte%1023);
            System.out.println(kiloByte +" KB = "+kilo +" MB"+ " and "+remain+" KB");
        }
    }
}
