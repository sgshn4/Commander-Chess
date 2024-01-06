package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Player;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving.MovingInterface;

import java.util.List;

public interface PlayerInterface {

    public MovingInterface getStep() throws InterruptedException;
    public void setName(String name);
    public String getName();
    public void setFigures(List<FigureInterface> figures);
    public boolean isPlayer();
}
