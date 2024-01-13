package com.cs.vsu.pereslavtsev_oleg.comander_chess.game;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {

    private List<Figure> figures;
    private Figure[][] boardMatrix;
    private Random random;

    public Board() {
        boardMatrix = new Figure[11][10];
        random = new Random();
        boolean isRed = false;
        for (int i = 0; i < 4; i++) {
            Infantryman.FACTORY.createFigure(new Point(random.nextInt(10),
                    random.nextInt(11)), isRed);
            isRed = !isRed;
        }

        figures = new ArrayList<>(Arrays.asList(
                new Infantryman(new Point(2, 7), true),
                new Infantryman(new Point(2, 4), false),
                new Infantryman(new Point(10, 4), false),
                new Infantryman(new Point(10, 7), true),
                new Commander(new Point(0, 6), false),
                new Commander(new Point(11, 6), true),
                new Base(new Point(11, 6), true),
                new Base(new Point(11, 6), true),
                new Base(new Point(11, 6), false),
                new Base(new Point(11, 6), false),
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
