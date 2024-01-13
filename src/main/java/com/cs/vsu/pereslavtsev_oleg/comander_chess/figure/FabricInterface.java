package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.Figure;
import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

public interface FabricInterface {
    public String getSymbol();
    public Figure createFigure(Point p, boolean isRed);
}
