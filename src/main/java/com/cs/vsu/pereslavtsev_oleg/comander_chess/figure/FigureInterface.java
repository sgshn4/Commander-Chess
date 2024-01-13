package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.List;

public interface FigureInterface {
    public boolean getIsRed();
    public Figure setPoint(Point point);
    public String getName();
    public List<Point> getAvailableMovements();
    public Point getPoint();
    //create figure, get symbol
    //фабрика фабрик для фигур
    //матрица для фигур
}
