package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroTank extends Figure {
    @Override
    public boolean checkMove(Point point) {
        List<Point> points = getAvailableMovements();
        for (Point p : points) {
            if (p.getX() == point.getX() && p.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    private static class HeroTankFabric extends AbstractFabricInterface {

        public HeroTankFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new HeroTank(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new HeroTankFabric(false, "HT");
    public static final FabricInterface FACTORY_RED = new HeroTankFabric(true, "ht");

    public HeroTank(Point point, boolean isRed) {
        super(point, isRed);
    }


    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> availablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 3), //up
                new Point(x, y + 3), // down
                new Point(x - 3, y), // left
                new Point(x + 3, y), //right
                new Point(x - 3, y - 3), //up-left
                new Point(x - 3, y + 3), // down-left
                new Point(x - 3, y - 3), // up-right
                new Point(x + 3, y + 3) // down-right
        ));
        return availablePoints;
    }

    @Override
    public String getName() {
        return "Ht";
    }
}
