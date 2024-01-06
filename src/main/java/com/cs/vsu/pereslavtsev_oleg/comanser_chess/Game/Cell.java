package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game;

import org.example.Figure.FigureInterface;

public class Cell {
    public static final int UP = 0;
    public static final int RIGHT_UP = 1;
    public static final int RIGHT = 2;
    public static final int RIGHT_DOWN = 3;
    public static final int DOWN = 4;
    public static final int LEFT_DOWN = 5;
    public static final int LEFT = 6;
    public static final int LEFT_UP = 7;
    public static final int SIZE = 8;
    private FigureInterface figure = null;
    private final Coordinates coordinates;
    private final Cell[] neighbours = new Cell[8];
    public Cell( Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public FigureInterface getFigure() {
        return figure;
    }
    public void setFigure(FigureInterface figure) {
        this.figure = figure;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Cell[] noSafetyGetNeighbours() {
        return neighbours;
    }
    public Cell getNeighbours(int index) {
        if(index < 0 || index > 7){
            return null;
        }
        return neighbours[index];
    }
    public void setNeighbours(int index, Cell value) {
        if(index < 0 || index > 7){
            return;
        }
         neighbours[index] = value;
    }
    @Override
    public String toString() {
        return "Cell{" +
                " figure=" + figure +
                ", coordinates=" + coordinates +
                '}';
    }
}
