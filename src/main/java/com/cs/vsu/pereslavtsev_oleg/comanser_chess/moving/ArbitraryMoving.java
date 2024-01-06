package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Coordinates;

public class ArbitraryMoving implements MovingInterface{
    protected FigureInterface figure;
    protected Coordinates coordinates;
    private int size = 0;
    protected Cell cellBefore;
    public ArbitraryMoving(FigureInterface figure, Coordinates coordinates) {
        this.figure = figure;
        this.coordinates = coordinates;
        cellBefore = figure.getCell();
    }

    @Override
    public boolean moving() {
        Cell cell = figure.getBoard().getCell(coordinates.getX(), coordinates.getY());
        if(figure.getBoard().getCell(coordinates.getX(), coordinates.getY()) == null){
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(cell);
        cell.setFigure(figure);
        size = 1;
        return true;
    }
    @Override
    public void reverse() {
        Cell cell = figure.getBoard().getCell(coordinates.getX(), coordinates.getY());
        cell.setFigure(null);
        cellBefore.setFigure(figure);
        figure.setCell(cellBefore);
    }
    @Override
    public FigureInterface getFigure() {
        return figure;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isKilled() {
        return false;
    }

    @Override
    public Coordinates[] getCoordinates() {
        return new Coordinates[]{coordinates};
    }
}
