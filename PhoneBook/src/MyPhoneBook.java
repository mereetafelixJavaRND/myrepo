import java.util.*;

import Exceptions.DuplicateNameExceptions;
import Exceptions.DuplicateNumberExceptions;
import dao.PhoneBookDao;
import model.PhoneBookModel;
public class MyPhoneBook {
    public static void main(String args[]) {
     @SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
     PhoneBookDao objmain=new PhoneBookDao();
     int ch = 0;
           

     while (ch == 0) {
            	 
                 System.out.println("Menu\n 1.Add new Phonebook\n 2.Search contact\n 3.Update Phonebook\n 4.Delete Phonebook\n 5.List all entries\n 6.Quit");
                 System.out.println("Enter your choice");
                 int choice = Integer.parseInt(sc.nextLine());
                 
                 if(choice == 1){
                     
                    PhoneBookModel obj = new PhoneBookModel();
                    System.out.println("Enter Id ");
                    obj.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Enter the  Name: ");
                    obj.setName(sc.nextLine());
                    System.out.println("Enter the Phone No. : ");
                    obj.setPhoneNumber(Long.parseLong(sc.nextLine()));
                    try {
						objmain.addContact(obj);
					} catch (DuplicateNumberExceptions | DuplicateNameExceptions e) {
						System.out.println(e.getMessage());
					}
                
                 }  if(choice == 2){
                     System.out.println("Enter 1 to search with Phone number");
                     System.out.println("Enter 2 to search with Id");
                     System.out.println("Enter 3 to search with Name");
                     int search = Integer.parseInt(sc.nextLine());
                     Long n1 =  null;
                     int id =0;
                     String name ;
                     PhoneBookModel obj1 = null;
					if(search == 1) {
					System.out.println("Enter Phone number");
                     n1=Long.parseLong(sc.nextLine());
                     obj1=objmain.searchContact(n1);
                     }
					if(search == 2) {
						System.out.println("Enter Id");
	                     id=Integer.parseInt(sc.nextLine());
	                     obj1=objmain.searchContact(id);
	                     }
					if(search == 3) {
						 System.out.println("Enter Name");
	                     name=sc.nextLine();
	                     obj1=objmain.searchContact(name);
	                     }
                    System.out.println("Id:"+obj1.getId());
                    System.out.println("The contact is:");
                    System.out.println("Name:"+obj1.getName());
                    System.out.println("Phone No.:"+obj1.getPhoneNumber());
                    
                 }if(choice == 3){
                      System.out.println("Enter the Phone number to be updated");
                      Long ph=Long.parseLong(sc.nextLine());
                      PhoneBookModel upobj = objmain.updateContact(ph);
                      System.out.println("Enter id ,name,phone no for updation");
                      upobj.setId(Integer.parseInt(sc.nextLine()));
                      upobj.setName(sc.nextLine());
                      upobj.setPhoneNumber(Long.parseLong(sc.nextLine()));
                      System.out.println("Id:"+upobj.getId());
                      System.out.println("The contact is:");
                      System.out.println("Name:"+upobj.getName());
                      System.out.println("Phone No.:"+upobj.getPhoneNumber());
                 }
                 if(choice==4) {
                     System.out.println("Enter the Phone number to remove:");
                     Long n1=Long.parseLong(sc.nextLine());
                     
                         boolean f1=objmain.removeContact(n1);
                         if(f1)
                         System.out.println("The contact is successfully deleted");
                         else
                         System.out.println("Contact is not found");
                     
                                      
                 }
                 if(choice==5)
                 {
                     System.out.println("The contacts in the List are:");
                     List<PhoneBookModel>obj=objmain.displayContacts();
                     for(PhoneBookModel temp:obj)
                     {
                         System.out.println("Id:"+temp.getId());
                         System.out.println("Last Name:"+temp.getName());
                         System.out.println("Phone No.:"+temp.getPhoneNumber());
                        
                     }
                 }
                 if(ch == 6) {
                	 System.exit(0);
                 }
               
                System.out.println("Press 0 to continue"); 
                ch = Integer.parseInt(sc.nextLine());
                 
            }
    }
}