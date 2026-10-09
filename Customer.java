public class Customer { //nasabah bank
    private String firstName;
    private String lastName;
    private Account[] accounts = new Account[5];//akun rekening
    private int numberOfAccounts = 0;
    
    //Constructor
    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
    }
    
    //Accessor & Mutator
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public void setAccount(Account akun) {
        if (numberOfAccounts<5) accounts[numberOfAccounts++] = akun;
    }
    public Account getAccount(int indAccount) {
        return accounts[indAccount];
    }
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }
}