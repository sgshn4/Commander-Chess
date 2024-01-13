package com.cs.vsu.pereslavtsev_oleg.comander_chess.game;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.Figure;

public abstract class Game {

    private static Board board;
    private static boolean isSelected;
    private static int selectedFigure;
    private static boolean isRedTurn;

    public static void init() {
        board = new Board();
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        Game.board = board;
    }

    public static boolean getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(boolean isSelected) {
        Game.isSelected = isSelected;
    }

    public static int getSelectedFigure() {
        return selectedFigure;
    }

    public static void setSelectedFigure(int selectedFigure) {
        Game.selectedFigure = selectedFigure;
    }

    public static boolean getIsRedTurn() {
        return isRedTurn;
    }

    public static void setIsRedTurn(boolean isRedTurn) {
        Game.isRedTurn = isRedTurn;
    }
}
