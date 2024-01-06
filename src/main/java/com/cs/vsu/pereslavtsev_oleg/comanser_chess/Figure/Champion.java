package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.moving.*;

import static org.example.Game.Cell.SIZE;

public class Champion extends Figure{
    public Champion(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res =  new MovingInterface[12];
        for (int i = 0; i < SIZE; i += 2){
            res[i/2] = createMovingInterface(i);
        }
        res[4] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 2);
        res[5] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 2);
        res[6] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 2);
        res[8] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY());
        res[9] = arbitraryMove(cell.getCoordinates().getX() -2 , cell.getCoordinates().getY() );
        res[10] = arbitraryMove(cell.getCoordinates().getX() , cell.getCoordinates().getY() - 2);
        res[11] = arbitraryMove(cell.getCoordinates().getX() , cell.getCoordinates().getY() + 2);
        return res;
    }
    @Override
    public String getName() {
        return "CH";
    }
}