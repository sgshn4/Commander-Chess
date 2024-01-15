package com.cs.vsu.pereslavtsev_oleg.comander_chess.display;

import com.cs.vsu.pereslavtsev_oleg.comander_chess.figure.Figure;
import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Board;
import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Game;
import com.cs.vsu.pereslavtsev_oleg.comander_chess.game.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawPanel extends JPanel {

    private GameMap gameMap;
    private Board board;

    public DrawPanel() {
        gameMap = new GameMap(0, 0);
        String[][] map =  {{"", "", "", "", "", "", "c", "", "", "", ""},
                            {"", "s", "", "", "p", "b", "", "b", "p", "", ""},
                            {"", "", "", "a", "", "", "m", "", "", "a", ""},
                            {"", "", "s", "", "ad", "t", "", "t", "ad", "", ""},
                            {"", "", "i", "e", "", "", "mi", "", "", "e", "i"},
                            {"", "", "", "", "", "w", "", "w", "", "", ""},
                            {"", "", "", "", "", "W", "", "W", "", "", ""},
                            {"", "", "I", "E", "", "", "MI", "", "", "E", "I"},
                            {"", "", "S", "", "AD", "T", "", "T", "AD", "", ""},
                            {"", "", "", "A", "", "", "M", "", "", "A", ""},
                            {"", "S", "", "", "P", "B", "", "B", "P", "", ""},
                            {"", "", "", "", "", "", "C", "", "", "", ""}};
        board = new Board(map);
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        gameMap.draw(g);
        drawFigures(g);
    }

    private void drawFigures(Graphics2D g) {
        g.setFont(new Font("Times", Font.PLAIN, 12));
        for (Figure i : board.getFigures()) {
            if (i.getIsRed()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.GREEN);
            }
            int x = 60 * i.getPoint().getX();
            int y = 60 * i.getPoint().getY();
            g.fillOval(x - 20, y - 20, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString(i.getName(), x, y);
        }
    }

}
