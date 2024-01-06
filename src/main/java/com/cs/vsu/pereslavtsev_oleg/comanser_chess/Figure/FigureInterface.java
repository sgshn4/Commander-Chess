package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Board;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving.MovingInterface;

public interface FigureInterface {
    public Cell getCell();
    public void setCell(Cell cell);
    public MovingInterface[] getMovingVariants();
    public boolean getIsWhite();
    public Board getBoard();
    public String getName();
}


