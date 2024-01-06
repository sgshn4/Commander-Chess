package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Player;

import org.example.ChessBoard;
import org.example.moving.MovingInterface;

public class PlayerOnBoard extends Player {
    private ChessBoard board;
    public PlayerOnBoard(String name) {
        super(name);
    }
    @Override
    public MovingInterface getStep() throws InterruptedException {
        board.setClickedMovingNull();
        while(board.getClickedMoving() == null){
            Thread.sleep(3000);
            System.out.println("Ожидание");
        }
        MovingInterface movingInterface = board.getClickedMoving();
        board.setClickedMovingNull();
        return movingInterface;
    }
    public void setBoard(ChessBoard board){
        this.board = board;
    }
    @Override
    public boolean isPlayer() {
        return true;
    }
}
