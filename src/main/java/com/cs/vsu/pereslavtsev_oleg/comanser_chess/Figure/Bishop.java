package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.moving.MovingInterface;

public class Bishop extends Figure{
    public Bishop(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[8];
        for(int i = 1; i < Cell.SIZE; i += 2){
            res[i/2] = longMovement(i);
        }
        return res;
    }
    @Override
    public String getName() {
        return "B";
    }
}