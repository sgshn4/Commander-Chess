package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.moving.MovingInterface;

public interface FigureInterface {
    public Cell getCell();
    public void setCell(Cell cell);
    public MovingInterface[] getMovingVariants();
    public boolean getIsWhite();
    public Board getBoard();
    public String getName();
}


