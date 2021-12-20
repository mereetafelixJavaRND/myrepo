package model;
public class PhoneBookModel {
  private int id;    
  private String name;
  private long  phoneNumber;
  public PhoneBookModel(){}
  public int getId() {
    return id;
  }
   public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public long getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
   public PhoneBookModel(int id, String name, long phoneNumber) {
    super();
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    
  }
 }