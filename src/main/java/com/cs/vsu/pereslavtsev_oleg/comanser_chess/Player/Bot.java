package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Player;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving.MovingInterface;

import java.util.Random;

public class Bot  extends Player{
    private static final Random random= new Random();
    public Bot(String name) {
        super(name);
    }
    @Override
    public MovingInterface getStep() {
        for(FigureInterface figureInterface : figures){
            MovingInterface[] moves= figureInterface.getMovingVariants();
            for(MovingInterface move : moves){
                if(move == null){
                    continue;
                }
                if(move.isKilled()){
                    return move;
                }
            }
        }
        return randomMove();
    }
    @Override
    public boolean isPlayer() {
        return false;
    }
    private MovingInterface randomMove(){
        FigureInterface figureInterface = figures.get(random.nextInt(figures.size()));
        MovingInterface[] moves  =  figureInterface.getMovingVariants();
        MovingInterface move = moves[random.nextInt(moves.length)];
        if(move == null){
            return randomMove();
        }
        if(move.getSize() != 0){
            return move;
        }
        return randomMove();
    }
}
