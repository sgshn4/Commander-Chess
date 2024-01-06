package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Coordinates;

public abstract class Moving implements MovingInterface {
    protected FigureInterface figure;
    protected Coordinates[] coordinates = new Coordinates[1];
    public Moving(FigureInterface figure, Cell cell) {
        this.figure = figure;
        if(cell != null){
            this.coordinates = new Coordinates[]{cell.getCoordinates()};
        }
    }
    @Override
    public int getSize() {
        return 1;
    }
    @Override
    public FigureInterface getFigure() {
        return figure;
    }
    public Coordinates[] getCoordinates(){
        return coordinates;
    }
}
