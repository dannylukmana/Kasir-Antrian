/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.antrianfirstinfirstout;

import java.time.LocalDateTime;

/**
 *
 * @author Danny
 */
public class Antrian {
    private final int nomorAntrian;
    private final LocalDateTime waktuDibuat;

    public Antrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
        this.waktuDibuat = LocalDateTime.now();
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public LocalDateTime getWaktuDibuat() {
        return waktuDibuat;
    }

    @Override
    public String toString() {
        return "Nomor Antrian: " + nomorAntrian + ", Waktu: " + waktuDibuat;
    }
}
