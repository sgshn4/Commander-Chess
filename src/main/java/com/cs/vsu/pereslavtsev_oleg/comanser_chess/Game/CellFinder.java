package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Game;

import java.util.ArrayList;
import java.util.List;

public class CellFinder {
    private final List<Cell> listCells = new ArrayList<>();
    private final Cell findedCell;
    public CellFinder(Cell cellFromWhichSearch, int x, int y) {
        findedCell = findNullProtected(cellFromWhichSearch, x, y);
    }
    public Cell findNullProtected(Cell cellFromWhichSearch, int x, int y) {
        if (cellFromWhichSearch == null) {
            return null;
        }
        if(listCells.contains(cellFromWhichSearch)){
            return null;
        }
        listCells.add(cellFromWhichSearch);
        if (cellFromWhichSearch.getCoordinates().getX() == x && cellFromWhichSearch.getCoordinates().getY() == y) {
            return cellFromWhichSearch;
        }
        for(int i = 0; i < 8; i++){
            Cell res = findNullProtected(cellFromWhichSearch.getNeighbours(i), x, y);
            if (res != null) {return res;}
        }
        return null;
    }
    public Cell getFindedCell() {
        return findedCell;
    }
}