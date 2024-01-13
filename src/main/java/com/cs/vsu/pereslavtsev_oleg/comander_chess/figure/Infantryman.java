package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Infantryman extends Figure {

    private static class InfantryFabric extends AbstractFabricInterface {

        public InfantryFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new Infantryman(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new InfantryFabric(false, "I");
    public static final FabricInterface FACTORY_RED = new InfantryFabric(true, "i");

    public Infantryman(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public String getName() {
        return "I";
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
}
