package com.cs.vsu.pereslavtsev_oleg.comanser_chess.moving;

import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Figure.FigureInterface;
import com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game.Coordinates;

import java.util.Arrays;

public class MovingComposite implements MovingInterface{
    private final MovingInterface[] movingInterfaces;
    private final Coordinates[] coordinates;
    private final boolean isKilled;
    public MovingComposite(boolean isKilled, MovingInterface... movingInterfaces) {
        this.movingInterfaces = movingInterfaces;
        int counter = 0;
        for(MovingInterface movingInterface : movingInterfaces){
            if(movingInterface != null){
                counter += movingInterface.getCoordinates().length;
            }
        }
        coordinates = new Coordinates[counter];
        for(int i = 0; i < movingInterfaces.length; i ++){
            if(movingInterfaces[i] == null){
                continue;
            }
            Coordinates[] tmpCoordinates = movingInterfaces[i].getCoordinates();
            if(tmpCoordinates.length > 1){
                for (int j = 0; j < tmpCoordinates.length; j++) {
                    coordinates[i] = tmpCoordinates[j];
                    i++;
                }
                continue;
            }
            coordinates[i] = tmpCoordinates[0];
        }
        this.isKilled = isKilled;
    }
    @Override
    public boolean moving() {
        for(MovingInterface move : movingInterfaces){
            if(move != null){
                move.moving();
            }
        }
        return true;
    }
    @Override
    public void reverse() {
        for(MovingInterface move : movingInterfaces){
            if(move != null){
                move.reverse();
            }
        }
    }
    @Override
    public FigureInterface getFigure() {
        return null;
    }
    @Override
    public int getSize() {
        int counter = 0;
        for(MovingInterface m : movingInterfaces){
            if(m != null){
                counter++;
            }
        }
        return counter;
    }
    @Override
    public boolean isKilled() {

        return isKilled;
    }

    @Override
    public Coordinates[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "MovingComposite{" +
                "movingInterfaces=" + Arrays.toString(movingInterfaces) +
                ", isKilled=" + isKilled +
                '}';
    }
}
