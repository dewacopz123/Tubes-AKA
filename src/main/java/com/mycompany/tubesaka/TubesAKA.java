package com.mycompany.tubesaka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TubesAKA {

    public static long faktorialIteratif(int n) {
        long hasil = 1;
        for (int i = 1; i <= n; i++) {
            hasil *= i;
        }
        return hasil;
    }

    public static long faktorialRekursif(int n) {
        if (n == 0 ) {
            return 1;
        }
        return n * faktorialRekursif(n - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Penghitung Faktorial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1));

        JLabel labelInput = new JLabel("Masukkan sebuah angka:");
        JTextField textField = new JTextField();
        JLabel labelMetode = new JLabel("Pilih metode perhitungan:");
        JRadioButton iteratifButton = new JRadioButton("Iteratif");
        JRadioButton rekursifButton = new JRadioButton("Rekursif");
        ButtonGroup metodeGroup = new ButtonGroup();
        metodeGroup.add(iteratifButton);
        metodeGroup.add(rekursifButton);

        JButton hitungButton = new JButton("Hitung");

        JLabel hasilLabel = new JLabel("");
        JLabel waktuLabel = new JLabel("");

        frame.add(labelInput);
        frame.add(textField);
        frame.add(labelMetode);
        frame.add(iteratifButton);
        frame.add(rekursifButton);
        frame.add(hitungButton);
        frame.add(hasilLabel);
        frame.add(waktuLabel);

        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int angka = Integer.parseInt(textField.getText());
                    if (angka < 0) {
                        hasilLabel.setText("Faktorial tidak terdefinisi untuk angka negatif.");
                        waktuLabel.setText("");
                    } else {
                        long hasil;
                        long startTime, endTime;
                        double duration;

                        if (iteratifButton.isSelected()) {
                            startTime = System.nanoTime();
                            hasil = faktorialIteratif(angka);
                            endTime = System.nanoTime();
                            duration = (endTime - startTime) / 1_000_000_000.0;

                            hasilLabel.setText("Faktorial: " + hasil);
                            waktuLabel.setText(String.format("Waktu eksekusi: %.7f detik", duration));
                        } else if (rekursifButton.isSelected()) {
                            startTime = System.nanoTime();
                            hasil = faktorialRekursif(angka);
                            endTime = System.nanoTime();
                            duration = (endTime - startTime) / 1_000_000_000.0;

                            hasilLabel.setText("Faktorial: " + hasil);
                            waktuLabel.setText(String.format("Waktu eksekusi: %.7f detik", duration));
                        } else {
                            hasilLabel.setText("Pilih metode perhitungan.");
                            waktuLabel.setText("");
                        }
                    }
                } catch (NumberFormatException ex) {
                    hasilLabel.setText("Masukkan angka yang valid.");
                    waktuLabel.setText("");
                }
            }
        });

        frame.setVisible(true);
    }
}
