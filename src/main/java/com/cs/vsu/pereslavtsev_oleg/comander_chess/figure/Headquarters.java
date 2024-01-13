package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Headquarters extends Figure {
    public Headquarters(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAviableMovements() {
        List<Point> aviablePoints = new ArrayList<>();
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "H";
    }
}
