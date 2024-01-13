package com.cs.vsu.pereslavtsev_oleg.comander_chess.display;

import java.awt.*;

public class GameMap {

    private int x;
    private int y;

    public GameMap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 1 || (j == 5 && i != 0 && i != 1)) g.setPaint(Color.CYAN);
                else g.setPaint(Color.WHITE);
                g.fillRect(i * 80, j * 80, 80, 80);
                g.setPaint(Color.BLACK);
                g.drawRect(i * 80, j * 80, 80, 80);
            }
        }
    }
}
