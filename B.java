public class OOPS {
    public static void main(String[] args){
        BankAccount myACC = new BankAccount();
        myACC.username = "ayush";
        myACC.setPassword("abc");
        System.out.println(myACC.username);
        System.out.println(myACC.getPassword());
        BankAccount myACC2 = new BankAccount(myACC);
        myACC2.setPassword("xyz");
        System.out.println(myACC2.username);
        System.out.println(myACC2.getPassword());
    }
}
class BankAccount{
    public String username;
    private String password;
    public BankAccount(){
        
    }
    public BankAccount(BankAccount myACC){
        this.username = myACC.username;
    }
    public void setPassword(String pwd){
        password = pwd;
    }
    public String getPassword() {
        return password;
    }
    }
