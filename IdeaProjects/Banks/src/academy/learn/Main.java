package academy.learn;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("First Bank");
        if(bank.addBranch("Lagos")){
            System.out.println("Lagos branch added");
        }
        bank.addBranch("Lagos");
        bank.addCustomer("Lagos","Rasheed",50.05);
        bank.addCustomer("Lagos", "Tayo", 175.34);
        bank.addCustomer("Lagos", "Karim",500.30);

        bank.addBranch("Abuja");
        bank.addCustomer("Abuja","Bade",108.30);

        bank.addCustomerTransaction("Lagos","Tayo", 109.60);
        bank.addCustomerTransaction("Lagos","Tayo", 103.60);
        bank.addCustomerTransaction("Lagos","Rasheed", 109.60);


        bank.listCustomers("Lagos",true);
        bank.listCustomers("Abuja",true);

        bank.addBranch("Ibadan");

        if(!bank.addCustomer("Ibadan","Ope",5.53)){
            System.out.println("Error Ibadan branch does not exist");
        }
        if (!bank.addBranch("Lagos")){
            System.out.println("Lagos branch already exists");
        }

        if (!bank.addCustomerTransaction("Lagos","Bad",123.3)){
            System.out.println("Customer dose not exist at branch");
        }
    }
}
