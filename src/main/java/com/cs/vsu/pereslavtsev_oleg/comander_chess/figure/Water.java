package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.List;

public class Water extends Figure {

    private static class WaterFabric extends AbstractFabricInterface {

        public WaterFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new Water(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new WaterFabric(false, "w");
    public static final FabricInterface FACTORY_RED = new WaterFabric(true, "W");

    public Water(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        return super.getAvailableMovements();
    }

    @Override
    public String getName() {
        return "";
    }
}
