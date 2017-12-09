//Isaac Jon
//APCS1 pd 8
//HW07 -- On the Origins of a BigSib
//2001-09-27

public class BigSib {
    //inst vars
    public String helloMsg;
    //Methods
    public BigSib(){
	helloMsg = "Hello";
    }
    public BigSib(String grting) {
        helloMsg = grting;
    }
   
    public String greet(String phrase) {
	return helloMsg += " " + phrase;
	
    }
    public void setHelloMsg(String newMsg) {
        helloMsg = newMsg;
    }
}
