package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.List;

public interface FigureInterface {
    public boolean getisRed();
    public Figure setPoint(Point point);
    public String getName();
    public List<Point> getAviableMovements();
    public Point getPoint();
}
