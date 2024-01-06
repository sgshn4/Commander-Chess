package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Board;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving.MovingInterface;

import static com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell.SIZE;

public class Queen extends Figure{
    public Queen(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[SIZE];
        for(int i = 0; i < SIZE; i++){
            res[i] = longMovement(i);
        }
        return res;
    }
    @Override
    public String getName() {
        return "Q";
    }

}