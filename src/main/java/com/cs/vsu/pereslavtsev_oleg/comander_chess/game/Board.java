package com.cs.vsu.pereslavtsev_oleg.comander_chess.game;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {

    private List<Figure> figures;

    public Board(String[][] map) {
        figures = new ArrayList<>();
        FabricInterface[] factories = new FabricInterface[]{
                AirDefense.FACTORY_BLUE,
                AirDefense.FACTORY_RED,
                Artillery.FACTORY_BLUE,
                Artillery.FACTORY_RED,
                Base.FACTORY_BLUE,
                Base.FACTORY_RED,
                Commander.FACTORY_BLUE,
                Commander.FACTORY_RED,
                Engineer.FACTORY_BLUE,
                Engineer.FACTORY_RED,
                Infantryman.FACTORY_BLUE,
                Infantryman.FACTORY_RED,
                Militiaman.FACTORY_BLUE,
                Militiaman.FACTORY_RED,
                Missile.FACTORY_BLUE,
                Missile.FACTORY_RED,
                Plane.FACTORY_BLUE,
                Plane.FACTORY_RED,
                Ship.FACTORY_BLUE,
                Ship.FACTORY_RED,
                Tank.FACTORY_BLUE,
                Tank.FACTORY_RED,
                Water.FACTORY_BLUE,
                Water.FACTORY_RED
        };

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    FabricInterface fabric = find(map[i][j], factories);
                    if (fabric != null) {
                        figures.add(fabric.createFigure(new Point(j, i)));
                    }
                }
            }
        }
    }

    private static FabricInterface find(String name, FabricInterface[] fabricInterfaces) {
        for (int i = 0; i < fabricInterfaces.length; i++) {
            if (fabricInterfaces[i].getSymbol().equals(name)) return fabricInterfaces[i];
        }
        return null;
    }


    public List<Figure> getFigures() {
        return figures;
    }

    public void editFigure(Figure figure, int index) {
        figures.remove(index);
        figures.add(figure);
    }

    public void removeFigure(int index) {
        figures.remove(index);
    }
}