package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Base extends Figure {

    private static class BaseFabric extends AbstractFabricInterface {

        public BaseFabric(boolean isRed, String symbol) {
            super(isRed, symbol);
        }

        @Override
        public Figure createFigure(Point p) {
            return new Base(p, isRed());
        }
    }


    public static final FabricInterface FACTORY_BLUE = new BaseFabric(false, "B");
    public static final FabricInterface FACTORY_RED = new BaseFabric(true, "b");

    public Base(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        List<Point> availablePoints = new ArrayList<>();
        return availablePoints;
    }

    @Override
    public String getName() {
        return "B";
    }
}
