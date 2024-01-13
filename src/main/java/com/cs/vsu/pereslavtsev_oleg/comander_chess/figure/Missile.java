package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Missile extends Figure {

    private static class MissileFabric extends AbstractFabricInterface {

        public MissileFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new Missile(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new MissileFabric(false, "MI");
    public static final FabricInterface FACTORY_RED = new MissileFabric(true, "mi");

    public Missile(Point point, boolean isRed) {
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
                new Point(x + 2, y), //right
                new Point(x - 1, y - 1), //up-left
                new Point(x - 1, y + 1), // down-left
                new Point(x - 1, y - 1), // up-right
                new Point(x + 1, y + 1) // down-right
        ));
        return availablePoints;
    }

    @Override
    public String getName() {
        return "Mi";
    }
}
