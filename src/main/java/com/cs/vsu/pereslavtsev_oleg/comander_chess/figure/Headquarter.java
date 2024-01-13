package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Headquarter extends Figure {

    private static class HeadquarterFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return null;
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Headquarter(p, isRed);
        }
    }

    public Headquarter(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        List<Point> aviablePoints = new ArrayList<>();
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "H";
    }
}
