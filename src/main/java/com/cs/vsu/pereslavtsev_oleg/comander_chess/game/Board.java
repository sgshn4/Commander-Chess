package com.cs.vsu.pereslavtsev_oleg.comander_chess.game;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private List<Figure> figures;

    public Board() {
        figures = new ArrayList<>(Arrays.asList(new Infantryman(new Point(2, 7), true),
                new Infantryman(new Point(2, 4), false),
                new Infantryman(new Point(10, 4), false),
                new Infantryman(new Point(10, 7), true),
                new Commander(new Point(0, 6), false),
                new Commander(new Point(11, 6), true),
                new Headquarters(new Point(11, 6), true),
                new Headquarters(new Point(11, 6), true),
                new Headquarters(new Point(11, 6), false),
                new Headquarters(new Point(11, 6), false),
                new Plane(new Point(11, 6), true),
                new Plane(new Point(11, 6), true),
                new Plane(new Point(11, 6), false),
                new Plane(new Point(11, 6), false),
                new Artillery(new Point(11, 6), true),
                new Artillery(new Point(11, 6), true),
                new Artillery(new Point(11, 6), false),
                new Artillery(new Point(11, 6), false),
                new AirDefense(new Point(11, 6), true),
                new AirDefense(new Point(11, 6), true),
                new AirDefense(new Point(11, 6), false),
                new AirDefense(new Point(11, 6), false),
                new Missile(new Point(11, 6), true),
                new Missile(new Point(11, 6), false),
                new Ship(new Point(11, 6), true),
                new Ship(new Point(11, 6), true),
                new Ship(new Point(11, 6), false),
                new Ship(new Point(11, 6), false),
                new Engineer(new Point(11, 6), true),
                new Engineer(new Point(11, 6), true),
                new Engineer(new Point(11, 6), false),
                new Engineer(new Point(11, 6), false),
                new Tank(new Point(11, 6), true),
                new Tank(new Point(11, 6), true),
                new Tank(new Point(11, 6), false),
                new Tank(new Point(11, 6), false),
                new Militiaman(new Point(11, 6), true),
                new Militiaman(new Point(11, 6), false)));
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
