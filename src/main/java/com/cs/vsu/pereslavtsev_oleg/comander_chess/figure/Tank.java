package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tank extends Figure {

    private static class TankFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return "Tank";
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Tank(p, isRed);
        }
    }

    public static final FabricInterface FACTORY = new TankFabric();

    public Tank(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> availablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 2), //up
                new Point(x, y + 2), // down
                new Point(x - 2, y), // left
                new Point(x + 2, y) // right
        ));
        return availablePoints;
    }

    @Override
    public String getName() {
        return "T";
    }
}
