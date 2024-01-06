package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Board;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving.MovingInterface;

import static com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Cell.SIZE;

public class Knight extends Figure {
    public Knight(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[SIZE];
        res[0] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 1);
        res[1] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 1);
        res[2] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 2);
        res[3] = arbitraryMove(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() + 2);
        res[4] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() - 2);
        return res;
    }
    @Override
    public String getName() {
        return "K";
    }
}