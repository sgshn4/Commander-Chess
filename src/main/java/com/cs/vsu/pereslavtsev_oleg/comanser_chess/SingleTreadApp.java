package com.cs.vsu.pereslavtsev_oleg.comanser_chess;

import org.example.Game.Board;
import org.example.Game.GameState;
import org.example.Player.Bot;

import javax.swing.*;

public class SingleTreadApp {
    private ChessBoard frame;

    public SingleTreadApp(){
        Board b = new Board();
        b.buildBoard();
        GameState gs = new GameState(new Bot("Димас"), new Bot("Не димас"));
        SwingUtilities.invokeLater(() -> {
            frame = new ChessBoard(gs);
        });
    }

    public static void main(String[] args) {
        new SingleTreadApp();
    }
}
