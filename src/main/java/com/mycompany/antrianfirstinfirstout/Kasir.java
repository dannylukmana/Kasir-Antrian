/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.antrianfirstinfirstout;

/**
 *
 * @author Danny
 */
public class Kasir {
    private final Antrian[] antrianArray;
    private final int kapasitas;
    private int jumlahAntrian;
    private final String jenisKasir;

    public Kasir(String jenisKasir, int kapasitas) {
        this.jenisKasir = jenisKasir;
        this.kapasitas = kapasitas;
        this.antrianArray = new Antrian[kapasitas];
        this.jumlahAntrian = 0;
    }

    public void tambahAntrian(int nomorAntrian) {
        if (jumlahAntrian < kapasitas) {
            antrianArray[jumlahAntrian] = new Antrian(nomorAntrian);
            System.out.println(jenisKasir + " - " + antrianArray[jumlahAntrian] + " ditambahkan ke antrian.");
            jumlahAntrian++;
        } else {
            System.out.println(jenisKasir + " - Antrian penuh. Tidak bisa menambah antrian.");
        }
    }

    public Antrian[] getAntrianArray() {
        return antrianArray;
    }

    public int getJumlahAntrian() {
        return jumlahAntrian;
    }
}
