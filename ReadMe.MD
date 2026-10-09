# Simulasi ATM Bank 

Tugas latihan Pemrograman Berorientasi Objek (PBO).
materi Array dan Array List
Program mensimulasikan ATM dengan nasabah yang sudah terdaftar di Bank dan memiliki 1 rekening dengan saldo awal Rp 100.000.

## Kelas
`Account.java` berisi Rekening: saldo, `deposit`, `withdraw`, dan penghitung total transaksi (atribut `static`) 
`Customer.java` berisi Nasabah: nama dan daftar rekening (maks. 5) yang disimpan dalam **`ArrayList<Account>`** 
`Bank.java` berisi Bank: menyimpan nasabah dalam **array** `Customer[]` 
`Main.java` berisi Program utama berupa menu ATM dengan `Scanner` 

## Relasi Antar Kelas

Bank 1 ---- 0..* Customer 1 ---- 0..5 Account

## Fitur Menu ATM
1. Tambah rekening
2. Setor saldo
3. Tarik saldo
4. Cek saldo
5. Lihat total transaksi
0. Keluar
Setiap selesai satu menu, layar menunggu tombol Enter sebelum kembali ke menu utama.

