public class Bank { //bank menyimpan daftar nasabah
    private Customer[] customers;
    private int numberOfCustomers;
 
    //Constructor
    public Bank(int maxCustomers) {
        customers = new Customer[maxCustomers];
        numberOfCustomers = 0;
    }
    public Bank() { //kapasitas maksimal 10 nasabah
        this(10);
    }
 
    //Mutator
    public boolean addCustomer(String f, String l) {
        if (numberOfCustomers >= customers.length) {
            return false;
        }
        customers[numberOfCustomers] = new Customer(f, l);
        numberOfCustomers++;
        return true;
    }
 
    //Accessor
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }
    public Customer getCustomer(int index) {
        if (index < 0 || index >= numberOfCustomers) {
            return null; 
        }
        return customers[index];
    }
}