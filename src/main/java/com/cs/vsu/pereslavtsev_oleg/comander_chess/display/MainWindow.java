package com.cs.vsu.pereslavtsev_oleg.comander_chess.display;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setSize(new Dimension(810, 920));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        DrawPanel drawPanel = new DrawPanel();
        add(drawPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
