package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;

public class DefaultMoving extends Moving{
    private final int destination;
    public DefaultMoving(FigureInterface figure, int destination, Cell currCell ) {
        super(figure, currCell);
        this.destination = destination;
    }
    @Override
    public boolean moving() {
        if (figure.getCell().getNeighbours(destination) == null) {
            return false;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getNeighbours(destination));
        figure.getCell().setFigure(figure);
        return true;
    }
    @Override
    public void reverse() {
        int tmpDestination;
        if(destination < 4 ){
            tmpDestination = destination + 4;
        }else{
            tmpDestination = destination - 4;
        }
        figure.getCell().setFigure(null);
        figure.setCell(figure.getCell().getNeighbours(tmpDestination));
        figure.getCell().setFigure(figure);
    }

    @Override
    public boolean isKilled() {
        return false;
    }
}