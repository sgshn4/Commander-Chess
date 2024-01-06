package com.cs.vsu.pereslavtsev_oleg.comanser_chess;

import org.example.Game.Board;
import org.example.Game.GameState;
import org.example.Player.Bot;
import org.example.Player.PlayerOnBoard;

import javax.swing.*;

public class MultiThreadApp {
    private ChessBoard frame;

    public MultiThreadApp() {
        Board b = new Board();
        b.buildBoard();
        GameState gs = new GameState(new Bot("Димас"), new PlayerOnBoard("Не Димас"));
        SwingUtilities.invokeLater(() -> {
            frame = new ChessBoard(gs);
        });

        Thread appThread = new Thread(() -> {
            while (true) {
                try {
                    updateGUI();
                    gs.setStep();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        appThread.start();

    }

    // Метод для обновления GUI из главного потока
    private void updateGUI() {
        SwingUtilities.invokeLater(() -> {
            frame.resetChessBoard();
        });
    }

    public static void main(String[] args) {
        new MultiThreadApp();

    }
}
