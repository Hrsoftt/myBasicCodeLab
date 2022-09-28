package academy.learn;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if (findContact(contact)>=0){
            System.out.println("Contact " +contact +" already exists");
            return false;
        }
        this.myContact.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if (findContact(oldContact)<0){
            System.out.println("Contact dose not exist");
            return false;
        }else if (findContact(newContact)!=-1){
            System.out.println("Name "+ newContact + " already exist");
            return false;
        }
        this.myContact.set(foundPosition,newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if (findContact(contact)<0){
            System.out.println("Contact does not exist");
            return false;
        }
        this.myContact.remove(position);
        return true;
    }

    private int findContact(Contact contact){
        return myContact.indexOf(contact);
    }
    private int findContact(String contactName){
        for (int i=0; i<this.myContact.size(); i++){
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }return -1;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            this.myContact.get(position);
        }return null;
    }

    public void printContact(){
        System.out.println("Contact list:");
        for(int i=0; i<myContact.size();i++){
            System.out.println((i+1) +". "+this.myContact.get(i).getName()+
                    " -> "+ this.myContact.get(i).getPhoneNumber());
        }
    }
}
