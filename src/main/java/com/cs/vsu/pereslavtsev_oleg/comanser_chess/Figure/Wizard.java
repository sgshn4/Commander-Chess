package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.moving.*;
public class Wizard extends Figure{
    public Wizard(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res =  new MovingInterface[12];
        for(int i = 1; i < Cell.SIZE; i += 2){
            res[i/2] = createMovingInterface(i);
        }
        res[4] = arbitraryMove(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMove(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMove(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() + 1);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() - 1);

        res[8] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 3);
        res[9] = arbitraryMove(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() + 3);
        res[10] = arbitraryMove(cell.getCoordinates().getX() + 1 , cell.getCoordinates().getY() - 3);
        res[11] = arbitraryMove(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() - 3);
        return res;
    }
    @Override
    public String getName() {
        return "W";
    }
}