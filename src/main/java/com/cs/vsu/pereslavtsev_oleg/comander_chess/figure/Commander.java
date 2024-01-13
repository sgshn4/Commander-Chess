package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Commander extends Figure {

    private static class CommanderFabric extends AbstractFabricInterface {

        public CommanderFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new Commander(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new CommanderFabric(false, "C");
    public static final FabricInterface FACTORY_RED = new CommanderFabric(true, "c");

    public Commander(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public String getName() {
        return "C";
    }

    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> availablePoints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (x != i && i < 10) {
                availablePoints.add(new Point(i, y));
                if (y != i) {
                    availablePoints.add(new Point(x, i));
                }
            }
        }
        return availablePoints;
    }
}
