// Team 08 Comierades - Sam, Johnny, William
// APCS1 pd 8
// HW09 -- building a more meaningful class
// 2017-10-03 T

public class BankAccount
{
  //instance variables
  private String name;
  private String passwd;
  private int pin;
  private int acctNum;
  private double balance;


    /* default constructor: initializes instance vars to default vals
       precondition:  none
       postcondition: instance vars have appropriate default vals
       ````````````````````````````````````````````````````*/
    public BankAccount() {
      name = "";
      passwd = "";
      pin = 0;
      acctNum = 0;
      balance = 0;
    }


    /* overloaded constructor: allows caller to specify account 
                               number and passwd. Assigns defaults
                               to other instance vars.
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass ) {
      name = "";
      passwd = newPass;
      pin = 0;
      setAcctNum(newAcctNum);
      balance = 0;
      
    }
    /* overloaded constructor: allows caller to specify instance vars
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass, 
      double newBal, String newName, int newPin ) {
      name = newName;
      passwd = newPass;
      setPin(newPin);
      setAcctNum(newAcctNum);
      balance = newBal;
      
    }
      
  //mutators
  public String setName( String newName )
  {
    String oldName = name;
    name = newName; //Your name can't ever be invalid!!
    return oldName; //Lets you know what your previous name was
  }

  public String setPasswd( String newPasswd )
  {
    String oldPasswd = passwd;
    passwd = newPasswd; //You can make your password anything you want it to b
    return oldPasswd; //Lets you know what your previous password was
  }

  public int setPin( int newPin )
  {
    int oldPin = pin;
    if (newPin >= 1000 && newPin <= 9998){ // if newPin is not in range of [1000,9998], it is invalidated
  pin = newPin;
    }
    else {
  pin = 9999;
  System.out.println("Invalid pin - must be 4 digits");
    }
    return oldPin;
  }

  public int setAcctNum( int newAcctNum )
  { 
    int oldAcctNum = acctNum;
    if (newAcctNum >= 100000000 && newAcctNum <= 999999998){ // if newAcctNum is not in range of [100000000,999999998], it is invalidated
  acctNum = newAcctNum;
    }
    else {
  acctNum = 999999999;
  System.out.println("Invalid account number - must be 9 digits");
    }
    return oldAcctNum;
  }

  public double setBalance( double newBalance )
  {
    double oldBalance = balance;
    balance = newBalance; //sets new balance
    return oldBalance; //Lets you know your previous balance
  }

  public void deposit( double depositAmount ) {
    balance = balance + depositAmount; //deposits money
  }

    public boolean withdraw ( double withdrawalAmount ) {
  if (balance >= withdrawalAmount) { //Checks whether you have enough money before withdrawing
      balance = balance - withdrawalAmount;
      return true;
  }
  else {
      System.out.println("Withdrawal amount exceeds balance");
      return false;
  }
    }

    //returns whether or not AcctNum and passwd are correct
    public boolean authenticate ( int AcctNum, String passwd) {
  int currentAcctNum = acctNum;
  String currentPasswd = passwd;
  return (currentAcctNum == AcctNum & currentPasswd == passwd); 
    }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    // INSERT YOUR METHOD CALLS FOR TESTING HERE
      BankAccount testing = new BankAccount();
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
      
  }//end main()

}//end class BankAccount
