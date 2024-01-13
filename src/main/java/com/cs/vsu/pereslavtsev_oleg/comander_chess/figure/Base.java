package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Base extends Figure {

    private static class BaseFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return "Base";
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Base(p, isRed);
        }
    }

    public static final FabricInterface FACTORY = new BaseFabric();

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
