package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Artillery extends Figure {
    public Artillery(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAviableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> aviablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 3), //up
                new Point(x, y + 3), // down
                new Point(x - 3, y), // left
                new Point(x + 3, y), //right
                new Point(x - 3, y - 3), //up-left
                new Point(x - 3, y + 3), // down-left
                new Point(x - 3, y - 3), // up-right
                new Point(x + 3, y + 3) // down-right
        ));
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "A";
    }
}
