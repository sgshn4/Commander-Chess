package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Militiaman extends Figure {

    private static class MilitiamanFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return null;
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Militiaman(p, isRed);
        }
    }

    public Militiaman(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> aviablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 1), //up
                new Point(x, y + 1), // down
                new Point(x - 1, y), // left
                new Point(x + 1, y), //right
                new Point(x - 1, y - 1), //up-left
                new Point(x - 1, y + 1), // down-left
                new Point(x - 1, y - 1), // up-right
                new Point(x + 1, y + 1) // down-right
        ));
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "M";
    }
}
