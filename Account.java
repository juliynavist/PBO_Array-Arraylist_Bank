import java.util.ArrayList;

public class Account {
    protected double balance; //saldo
    protected static int totalTransaksi = 0;
    protected ArrayList<String> riwayat = new ArrayList<>(); //catatan transaksi rekening ini

    //Constructor
    public Account(double balance){
        this.balance = balance;
        riwayat.add("Rekening dibuka, saldo awal " + balance);
    }

    //Accessor
    public double getBalance(){
        return this.balance;
    }
    public static int getTotalTransaksi(){
        return totalTransaksi;
    }
    public ArrayList<String> getRiwayat(){
        return riwayat;
    }

    //Mutator
    public boolean deposit(double amount){ //pengisian saldo dengan nominal
        if (amount <= 0){
            System.out.println("Isi nominal untuk pengisian saldo");
            return false;
        } else{
            balance += amount;
            totalTransaksi++;
            riwayat.add("Setor " + amount);
            System.out.println("Pengisian Saldo Berhasil");
            return true;  
        }
    }
    public boolean withdraw(double amount){ //penarikan saldo dengan nominal
        if ( amount > 0 && balance >= amount ) {
            balance = balance - amount;
            totalTransaksi++;
            riwayat.add("Tarik " + amount);
            return true; 
        } else{
            return false;
        }
    }
}