package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Coordinates;

public class KillDecorator implements MovingInterface{
    private final MovingInterface moving;
    private final Cell cell;
    private final FigureInterface killedFigure;
    private int size = 0;
    public KillDecorator(MovingInterface moving, Cell cell, FigureInterface killedFigure) {
        this.moving = moving;
        this.cell = cell;
        this.killedFigure = killedFigure;
    }

    @Override
    public boolean moving() {
        try {
            if(killedFigure.getIsWhite()){
                killedFigure.getBoard().removeToWhiteFigures(killedFigure);
            }else{
                killedFigure.getBoard().removeToBlackFigures(killedFigure);
            }
            killedFigure.getCell().setFigure(null);
            killedFigure.setCell(null);
            size++;
            return moving.moving();
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void reverse() {
        moving.reverse();
        if(killedFigure.getIsWhite()){
            killedFigure.getBoard().addToWhiteFigures(killedFigure);
        }else{
            killedFigure.getBoard().addToBlackFigures(killedFigure);
        }
        cell.setFigure(killedFigure);
        killedFigure.setCell(cell);
    }
    @Override
    public FigureInterface getFigure() {
        return moving.getFigure();
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isKilled() {
        return true;
    }

    @Override
    public Coordinates[] getCoordinates() {
        return moving.getCoordinates();
    }
}
