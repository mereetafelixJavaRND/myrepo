package dao;
import Exceptions.*;
import java.util.*;

import model.PhoneBookModel;
public class PhoneBookDao
{
    private List<PhoneBookModel> phoneBook=new ArrayList<PhoneBookModel>();
    public void setPhoneBook(List<PhoneBookModel>obj)
    {
        phoneBook=obj;
    }
    public List<PhoneBookModel>getPhoneBook()
    {
        return phoneBook;
    }
    public void addContact(PhoneBookModel contactObj) throws DuplicateNameExceptions,DuplicateNumberExceptions{
    	try {
    	for(PhoneBookModel obj1:phoneBook){
            if(obj1.getPhoneNumber()==contactObj.getPhoneNumber()){
                throw new DuplicateNumberExceptions("Duplicate phone number");
            }
            if(obj1.getName().equals(contactObj.getName())) {
            	throw new DuplicateNameExceptions("Duplicate name");
            }
    }
    	}catch (Exception e) {
			throw e;
		}
        phoneBook.add(contactObj);
        
    }
    public List<PhoneBookModel> displayContacts()
    {
        return phoneBook;
    }
    public PhoneBookModel searchContact(long phoneNumber)
    {
        PhoneBookModel obj=new PhoneBookModel();
        for(PhoneBookModel obj1:phoneBook){
            if(obj1.getPhoneNumber()==phoneNumber){
                obj=obj1;
            }
        }
        return obj;
    }
    public PhoneBookModel searchContact(int id)
    {
        PhoneBookModel obj=new PhoneBookModel();
        for(PhoneBookModel obj1:phoneBook){
            if(obj1.getId()==id){
                obj=obj1;
            }
        }
        return obj;
    }
    public PhoneBookModel searchContact(String name)
    {
        PhoneBookModel obj=new PhoneBookModel();
        for(PhoneBookModel obj1:phoneBook){
            if(obj1.getName()==name){
                obj=obj1;
            }
        }
        return obj;
    }
    public PhoneBookModel updateContact(long phoneNumber) {
    	 PhoneBookModel obj=new PhoneBookModel();
    	 for(PhoneBookModel obj1:phoneBook) {
    		 if(obj1.getPhoneNumber()==phoneNumber){
                 obj=obj1;
             }
    	 }
    	 return obj;
    }
    public boolean removeContact(long phoneNumber)
    {
        boolean f=false;
        for(PhoneBookModel obj:phoneBook)
        {
            if(obj.getPhoneNumber()==phoneNumber)
            {
                f=true;
                phoneBook.remove(obj);
                break;
            }
        }
        return f;
    }
}