import java.util.Scanner;

public class Main {
    //DATA NASABAH = nama depan, nama belakang, saldo rekening, PIN ATM
    static final String[][] DATA = {
        {"Ariana", "Grande", "100000", "1234"},
        {"Billie", "Eilish", "250000", "5678"}
    };
    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank(10);
    static Customer nasabah; //nasabah yang login 
    static void clear() { //hapus layar
        System.out.print("\033[H\033[2J"); System.out.flush(); 
    } 
    static String rupiah(double x) { 
        return String.format("Rp %,.0f", x); 
    } 
    static double bacaAngka(String teks) { //input salah -> -1
        System.out.print(teks);
        try { return Double.parseDouble(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
    
    public static void main(String[] args) {
        for (String[] d : DATA) {
            bank.addCustomer(d[0], d[1]);
            bank.getCustomer(bank.getNumOfCustomers() - 1).setAccount(new Account(Double.parseDouble(d[2])));
        }
        while ((nasabah = login()) != null) {
            menuAtm();
        }
        clear();
        System.out.println("ATM dimatikan.");
    }
    static Customer login() { 
        for (int coba = 1; coba <= 3; coba++) {
            clear();
            System.out.println("===== ATM BANK =====");
            System.out.print("Masukkan PIN (4 angka, 0 = matikan ATM): ");
            String pin = sc.nextLine().trim();
            if (pin.equals("0")) return null;
            for (int i = 0; i < bank.getNumOfCustomers(); i++)
                if (pin.equals(DATA[i][3])) return bank.getCustomer(i); //PIN cocok
            System.out.print("PIN salah (" + coba + "/3). Tekan Enter...");
            sc.nextLine();
        }
        clear();
        System.out.println("PIN salah 3 kali. Kartu diblokir.");
        return null;
    }
    static void menuAtm() {
        int pilih;
        do {
            clear();
            System.out.println("===== ATM BANK =====");
            System.out.println("Selamat datang, " + nasabah.getFullName());
            System.out.println("1. Tambah rekening\n2. Setor saldo\n3. Tarik saldo\n4. Cek saldo");
            System.out.println("5. Lihat total transaksi\n0. Keluar");
            pilih = (int) bacaAngka("Pilih: ");
            clear(); 
            switch (pilih) {
                case 1: tambahRekening(); break;
                case 2: setorSaldo(); break;
                case 3: tarikSaldo(); break;
                case 4: System.out.println("== CEK SALDO =="); daftarRekening(); break;
                case 5: lihatTransaksi(); break;
                case 0: System.out.println("Terima kasih, " + nasabah.getFirstName() + "."); break;
                default: System.out.println("Menu tidak ada.");
            }
            System.out.print("\nTekan Enter untuk lanjut...");
            sc.nextLine();
        } while (pilih != 0);
    }
    static void tambahRekening() {
        System.out.println("== TAMBAH REKENING ==");
        if (nasabah.getNumOfAccounts() >= 5) { System.out.println("Rekening sudah penuh (maks 5)."); return; }
        double awal = bacaAngka("Saldo awal: ");
        if (awal < 0) { System.out.println("Saldo awal tidak valid."); return; }
        nasabah.setAccount(new Account(awal));
        System.out.println("Rekening nomor " + nasabah.getNumOfAccounts() + " berhasil dibuka.");
    }
    static void setorSaldo() {
        System.out.println("== SETOR SALDO ==");
        Account a = pilihRekening();
        if (a == null) return;
        a.deposit(bacaAngka("Nominal setor: ")); 
        System.out.println("Saldo sekarang: " + rupiah(a.getBalance()));
    }
    static void tarikSaldo() {
        System.out.println("== TARIK SALDO ==");
        Account a = pilihRekening();
        if (a == null) return;
        if (a.withdraw(bacaAngka("Nominal tarik: "))) System.out.println("Penarikan berhasil. Saldo sekarang: " + rupiah(a.getBalance()));
        else System.out.println("Penarikan gagal (nominal tidak valid atau saldo tidak cukup).");
    }
    static void lihatTransaksi() {
        System.out.println("== TOTAL TRANSAKSI ==");
        int milikNasabah = 0;
        for (int i = 0; i < nasabah.getNumOfAccounts(); i++)
            milikNasabah += nasabah.getAccount(i).getRiwayat().size() - 1; 
        System.out.println("Transaksi " + nasabah.getFirstName() + "      : " + milikNasabah);
        System.out.println("Transaksi semua nasabah : " + Account.getTotalTransaksi());
        for (int i = 0; i < nasabah.getNumOfAccounts(); i++) {
            System.out.println("\nRiwayat rekening " + (i + 1) + ":");
            for (String r : nasabah.getAccount(i).getRiwayat()) System.out.println(" - " + r);
        }
    }
    static void daftarRekening() {
        for (int i = 0; i < nasabah.getNumOfAccounts(); i++)
            System.out.println("Rekening " + (i + 1) + " : " + rupiah(nasabah.getAccount(i).getBalance()));
    }
    static Account pilihRekening() {
        daftarRekening();
        int n = nasabah.getNumOfAccounts();
        if (n == 1) return nasabah.getAccount(0); 
        int idx = (int) bacaAngka("Pilih nomor rekening (1-" + n + "): ") - 1;
        if (idx < 0 || idx >= n) { System.out.println("Rekening tidak ditemukan."); return null; }
        return nasabah.getAccount(idx);
    }
}