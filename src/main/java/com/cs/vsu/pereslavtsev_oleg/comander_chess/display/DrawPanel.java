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
        board = new Board();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Game.getIsSelected()) {
                    for (int i = 0; i < board.getFigures().size(); i++) {
                        if (Math.pow(board.getFigures().get(i).getPoint().getX() - e.getX(), 2) +
                                Math.pow(board.getFigures().get(i).getPoint().getY() - e.getY(), 2) <
                                Math.pow(30, 2)) {
                            Game.setIsSelected(true);
                            Game.setSelectedFigure(i);
                            System.out.println(e.getX() + " " + e.getY());
                            break;
                        }
                        System.out.println("null");
                    }
                } else {
                    Figure temp = board.getFigures().get(Game.getSelectedFigure());
                    board.getFigures().remove(Game.getSelectedFigure());
                    board.editFigure(temp.setPoint(new Point(e.getX(), e.getY())), Game.getSelectedFigure());
                    Game.setIsSelected(false);
                }
                super.mouseClicked(e);
            }
        });
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        gameMap.draw(g);
        drawFigures(g);
    }

    private void drawFigures(Graphics2D g) {
        g.setFont(new Font("Times", Font.PLAIN, 16));
        for (Figure i : board.getFigures()) {
            if (i.getIsRed()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.GREEN);
            }
            int x = 80 * i.getPoint().getX();
            int y = 80 * i.getPoint().getY();
            g.fillOval(x - 30, y - 30, 60, 60);
            g.setColor(Color.BLACK);
            g.drawString(i.getName(), x, y);
        }
    }

}
