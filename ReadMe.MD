# ATM Bank (Account, Customer, Bank)
Tugas latihan Pemrograman Berorientasi Objek (PBO) materi Array dan Array List.
Program mensimulasikan ATM: beberapa nasabah sudah terdaftar di bank dan masing-masing memiliki 1 rekening. Nasabah masuk ke ATM dengan memasukkan **PIN 4 angka**.

## Kelas
`Account.java` berisi Rekening: saldo, `deposit`, `withdraw`, penghitung total transaksi (atribut `static`), dan riwayat transaksi dalam **`ArrayList<String>`**
`Customer.java` berisi Nasabah: nama dan daftar rekening (maks. 5) yang disimpan dalam **array** `Account[]` 
`Bank.java` berisi Bank: menyimpan nasabah dalam **array** `Customer[]` 
`Main.java` berisi Program utama berupa ATM dengan login PIN dan menu `Scanner` 

## Login dengan PIN
Saat program dijalankan, ATM meminta PIN 4 angka. PIN menentukan nasabah yang masuk.
contoh:
Ariana Grande dengan PIN = 1234 
Billie Eilish dengan PIN = 5678 
- Jika PIN salah 3 kali: kartu diblokir dan program berhenti.
- Ketik `0` di layar PIN untuk mematikan ATM.

## Fitur Menu ATM
1. Tambah rekening
2. Setor saldo
3. Tarik saldo
4. Cek saldo
5. Lihat total transaksi (beserta riwayat tiap rekening)
0. Keluar (kembali ke layar PIN, nasabah lain bisa masuk dengan PIN-nya)

## Menambah Nasabah
Data nasabah ada di array `DATA` pada bagian atas `Main.java`, dengan format `{"nama depan", "nama belakang", "saldo awal", "PIN"}`. Tambahkan satu baris untuk nasabah baru (PIN tiap nasabah harus berbeda).

## Cara Menjalankan
Pastikan JDK sudah terpasang (`javac -version`).
javac *.java
java Main