package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Commander extends Figure {

    private static class CommanderFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return null;
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Commander(p, isRed);
        }
    }

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
        List<Point> aviablePoints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (x != i && i < 10) {
                aviablePoints.add(new Point(i, y));
                if (y != i) {
                    aviablePoints.add(new Point(x, i));
                }
            }
        }
        return aviablePoints;
    }
}
