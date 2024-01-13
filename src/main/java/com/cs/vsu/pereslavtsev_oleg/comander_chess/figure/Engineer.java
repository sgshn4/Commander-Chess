package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engineer extends Figure {

    private static class EngineerFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return "Engineer";
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Engineer(p, isRed);
        }
    }

    public static final FabricInterface FACTORY = new EngineerFabric();

    public Engineer(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> availablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 1), //up
                new Point(x, y + 1), // down
                new Point(x - 1, y), // left
                new Point(x + 1, y) // right
        ));
        return availablePoints;
    }

    @Override
    public String getName() {
        return "E";
    }
}
