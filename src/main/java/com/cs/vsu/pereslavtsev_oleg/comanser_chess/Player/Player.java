package com.cs.vsu.pereslavtsev_oleg.comanser_chess.Player;

import org.example.Figure.FigureInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class Player implements PlayerInterface {
    protected List<FigureInterface> figures;
    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Player(String name) { this.name = name; }
    public List<FigureInterface> getFigures() {
        return new ArrayList<>(figures);
    }
    public void setFigures(List<FigureInterface> figures) {
        this.figures = figures;
    }
}
