//Maryann Foley, Richard Wong, Isaac Jon (IceCode)
//APCS1 pd 8
//HW 11 - 

public class Teller {
  public static void main( String[] args) {
      BankAccount testing = new BankAccount();
      System.out.println(testing.toString());
      System.out.println(testing.setName("Commies")); 
      System.out.println(testing.setPasswd("stalinForPrez"));
      System.out.println(testing.setPin(1)); // testing for false case for setPin
      System.out.println(testing.setPin(1234)); // testing for true case for setPin
      System.out.println(testing.setAcctNum(1)); // testing for false case for setAcctNum
      System.out.println(testing.setAcctNum(123456789)); // testing for true case for setAcctNum
      System.out.println(testing.setBalance(1000.00));
      testing.deposit(50.00);
      System.out.println(testing.withdraw(100051.00)); // testing for false case for withdraw
      System.out.println(testing.withdraw(49.00)); // testing for true case for withdraw
      System.out.println(testing.authenticate(987654321,"hi")); // testing for false case for authenticate
      System.out.println(testing.authenticate(123456789,"stalinForPrez")); // testing for true case for authenticate
      System.out.println(testing.toString()); // print out current values of instance variables
    
      BankAccount testing2 = new BankAccount(1234,"password"); //Invalid acctNum, password will be set to "password"
      System.out.println(testing2.toString());
    
      BankAccount testing3 = new BankAccount(123456789, "password"); //acctNum set to 123456789, password set to "password"
      System.out.println(testing3.toString());
    
      BankAccount testing4 = new BankAccount(12345678, "password", 100, "name", 12345); //All values but pin are valid, set to respective entries
      System.out.println(testing4.toString());
    
      BankAccount testing5 = new BankAccount(123456789, "password", 1000, "name", 1234);//All values are valid, set to respective entries
      System.out.println(testing5.toString());
    
      BankAccount testing6 = new BankAccount();//All values set to default values
      System.out.println(testing6.toString());
  }
}