/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.antrianfirstinfirstout;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Antrianfirstinfirstout {
    public static void lihatSemuaAntrian(Kasir kasirDineIn, Kasir kasirTakeAway) {
        int totalAntrian = kasirDineIn.getJumlahAntrian() + kasirTakeAway.getJumlahAntrian();
        Antrian[] semuaAntrian = new Antrian[totalAntrian];
        int index = 0;

        for (int i = 0; i < kasirDineIn.getJumlahAntrian(); i++) {
            semuaAntrian[index++] = kasirDineIn.getAntrianArray()[i];
        }

        for (int i = 0; i < kasirTakeAway.getJumlahAntrian(); i++) {
            semuaAntrian[index++] = kasirTakeAway.getAntrianArray()[i];
        }

        Arrays.sort(semuaAntrian, Comparator.comparing(Antrian::getWaktuDibuat));
        
        System.out.println("Semua Antrian:");
        for (Antrian antrian : semuaAntrian) {
            String jenisKasir = getJenisKasir(antrian, kasirDineIn, kasirTakeAway);
            System.out.println("Nomor Antrian: " + antrian.getNomorAntrian() + ", Waktu: " + antrian.getWaktuDibuat() + ", Jenis Kasir: " + jenisKasir);
        }
    }
    
    private static String getJenisKasir(Antrian antrian, Kasir kasirDineIn, Kasir kasirTakeAway) {
        if (antrian == null) {
            return "Unknown";
        }
        for (Antrian a : kasirDineIn.getAntrianArray()) {
            if (a != null && a.equals(antrian)) {
                return "Dine In";
            }
        }
        for (Antrian a : kasirTakeAway.getAntrianArray()) {
            if (a != null && a.equals(antrian)) {
                return "Take Away";
            }
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Setiap kasir memiliki kapasitas maksimal 5
        Kasir kasirDineIn = new Kasir("Kasir Dine-In", 5);
        Kasir kasirTakeAway = new Kasir("Kasir Take Away", 5);

        while (true) {
            System.out.println("\nPilih operasi:");
            System.out.println("1. Tambah Antrian Dine-In");
            System.out.println("2. Tambah Antrian Take Away");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Keluar");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nomor antrian Dine-In: ");
                    int nomorDineIn = scanner.nextInt();
                    kasirDineIn.tambahAntrian(nomorDineIn);
                    break; 
                case 2:
                    System.out.print("Masukkan nomor antrian Take Away: ");
                    int nomorTakeAway = scanner.nextInt();
                    kasirTakeAway.tambahAntrian(nomorTakeAway);
                    break;
                case 3:
                    lihatSemuaAntrian(kasirDineIn, kasirTakeAway);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
