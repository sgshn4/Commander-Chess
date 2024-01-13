package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends Figure {

    private static class ShipFabric implements FabricInterface {
        @Override
        public String getSymbol() {
            return null;
        }

        @Override
        public Figure createFigure(Point p, boolean isRed) {
            return new Ship(p, isRed);
        }
    }

    public Ship(Point point, boolean isRed) {
        super(point, isRed);
    }

    @Override
    public List<Point> getAvailableMovements() {
        int x = getPoint().getX();
        int y = getPoint().getY();
        List<Point> aviablePoints = new ArrayList<>(Arrays.asList(
                new Point(x, y - 4), //up
                new Point(x, y + 4), // down
                new Point(x - 4, y), // left
                new Point(x + 4, y), //right
                new Point(x - 4, y - 4), //up-left
                new Point(x - 4, y + 4), // down-left
                new Point(x - 4, y - 4), // up-right
                new Point(x + 4, y + 4) // down-right
        ));
        return aviablePoints;
    }

    @Override
    public String getName() {
        return "S";
    }
}
