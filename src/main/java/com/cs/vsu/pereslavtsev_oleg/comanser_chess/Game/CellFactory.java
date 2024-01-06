package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game;
public class CellFactory{
    public static Cell createSell(int x, int y)  {
        return new Cell(new Coordinates(x, y));
    }
}
