package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int SIZE = 10;
    private Cell rootCell;
    private List<FigureInterface> whiteFigures = new ArrayList<>();
    private List<FigureInterface> blackFigures = new ArrayList<>();
    private King whiteKing;
    private King blackKing;
    public Board() {
        buildBoard();
    }
    public void buildBoard() {
        creatingCellsOnBoard();
        creatingWitchCells();
        createFigures();
    }
    private void createFigures() {
        whiteKing = new King(getCell(0, 5), true, this);
        whiteFigures = new ArrayList<>(Arrays.asList(new Wizard(getCell(-1, -1), true, this),
                new Champion(getCell(0, 0), true, this),
                new Rook(getCell(0, 1), true, this),
                new Knight(getCell(0, 2), true, this),
                new Bishop(getCell(0, 3), true, this),
                new Queen(getCell(0, 4), true, this),
                whiteKing,
                new Bishop(getCell(0, 6), true, this),
                new Knight(getCell(0, 7), true, this),
                new Rook(getCell(0, 8), true, this),
                new Champion(getCell(0, 9), true, this),
                new Wizard(getCell(-1, 10), true, this)));
        for (int i = 0; i < SIZE; i++) {
            new Pawn(getCell(1, i), true, this);
        }
        blackKing = new King(getCell(9, 5), false, this);
        blackFigures = new ArrayList<>(Arrays.asList(
                new Wizard(getCell(10, -1), false, this),
                new Champion(getCell(9, 0), false, this),
                new Rook(getCell(9, 1), false, this),
                new Knight(getCell(9, 2), false, this),
                new Bishop(getCell(9, 3), false, this),
                blackKing,
                new Queen(getCell(9, 4), false, this),
                new Bishop(getCell(9, 6), false, this),
                new Knight(getCell(9, 7), false, this),
                new Rook(getCell(9, 8), false, this),
                new Champion(getCell(9, 9), false, this),
                new Wizard(getCell(10, 10), false, this)));
        for (int i = 0; i < SIZE; i++) {
            new Pawn(getCell(8, i), false, this);
        }
    }
    public Cell getCell(int x, int y) {
        return new CellFinder(rootCell, x, y).getFindedCell();
    }
    private boolean checkValideCoords(int i) {
        return i < SIZE && i >= 0;
    }
    private void creatingCellsOnBoard() {
        Cell[] current = createBoardRow(0);
        rootCell = current[0];
        for (int i = 1; i < SIZE; i++) {
            Cell[] res = createBoardRow(i);
            for (int j = 0; j < SIZE; j++) {
                if (checkValideCoords(j + 1)) {
                    current[j].setNeighbours(Cell.RIGHT_DOWN, res[j + 1]);
                    res[j + 1].setNeighbours(Cell.LEFT_UP, current[j]);
                }
                current[j].setNeighbours(Cell.DOWN, res[j]);
                res[j].setNeighbours(Cell.UP, current[j]);
                if (checkValideCoords(j - 1)) {
                    current[j].setNeighbours(Cell.LEFT_DOWN, res[j - 1]);
                    res[j - 1].setNeighbours(Cell.RIGHT_UP, current[j]);
                }
            }
            current = res;
        }
    }
    private void creatingWitchCells() {
        getCell(0, 0).setNeighbours(Cell.LEFT_UP, CellFactory.createSell(-1, -1));
        getCell(0, 0).getNeighbours(Cell.LEFT_UP).setNeighbours(Cell.RIGHT_DOWN, getCell(0, 0));
        getCell(9, 0).setNeighbours(Cell.LEFT_DOWN, CellFactory.createSell(10, -1));
        getCell(9, 0).getNeighbours(Cell.LEFT_DOWN).setNeighbours(Cell.RIGHT_UP, getCell(9, 0));
        getCell(0, 9).setNeighbours(Cell.RIGHT_UP, CellFactory.createSell(-1, 10));
        getCell(0, 9).getNeighbours(Cell.RIGHT_UP).setNeighbours(Cell.LEFT_DOWN, getCell(0, 9));
        getCell(9, 9).setNeighbours(Cell.RIGHT_DOWN, CellFactory.createSell(10, 10));
        getCell(9, 9).getNeighbours(Cell.RIGHT_DOWN).setNeighbours(Cell.LEFT_UP, getCell(9, 9));
    }
    private Cell[] createBoardRow(int x) {
        Cell[] resList = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            resList[i] = CellFactory.createSell(x, i);
            if (i - 1 >= 0) {
                resList[i - 1].setNeighbours(Cell.RIGHT, resList[i]);
                resList[i].setNeighbours(Cell.LEFT, resList[i - 1]);
            }
        }
        return resList;
    }
    public List<FigureInterface> getWhiteFiguresNonSafety() {
        return whiteFigures;
    }
    public List<FigureInterface> getBlackFiguresNonSafety() {
        return blackFigures;
    }
    public void addToWhiteFigures(FigureInterface figure) {
        whiteFigures.add(figure);
    }
    public void addToBlackFigures(FigureInterface figure) {
        blackFigures.add(figure);
    }
    public void removeToWhiteFigures(FigureInterface figure) {
        whiteFigures.remove(figure);
    }
    public void removeToBlackFigures(FigureInterface figure) {
        blackFigures.remove(figure);
    }
    public King getWhiteKing() {
        return whiteKing;
    }
    public King getBlackKing() {
        return blackKing;
    }
}