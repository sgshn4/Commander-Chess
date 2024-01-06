package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Coordinates;

public interface MovingInterface {
    public boolean moving();
    public void reverse();
    public FigureInterface getFigure();
    public int getSize();
    public boolean isKilled();
    public Coordinates[] getCoordinates();
}
