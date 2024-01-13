package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirDefense extends Figure {

    public AirDefense(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAviableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> aviablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 4), //up
                new Point(x, y + 4), // down
                new Point(x - 4, y), // left
                new Point(x + 4, y) // right
        ));
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "AD";
    }
}
