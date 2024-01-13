package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.List;

public abstract class Figure implements FigureInterface {

    private boolean isRed;
    private Point point;
    private String name;

    public Figure(Point point, boolean isRed) {
        this.point = point;
        this.isRed = isRed;
    }

    @Override
    public boolean getisRed() {
        return isRed;
    }

    @Override
    public Point getPoint() {
        return point;
    }

    @Override
    public Figure setPoint(Point point) {
        this.point = point;
        return null;
    }


    @Override
    public List<Point> getAviableMovements() {
        return null;
    }
}
