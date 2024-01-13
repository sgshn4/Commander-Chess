package com.cs.vsu.pereslavtsev_oleg.comander_chess.player;

public class Player implements PlayerInterface {

    private String name;
    private boolean isRed;

    public Player(String name, boolean isRed) {
        this.name = name;
        this.isRed = isRed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getIsRed() {
        return isRed;
    }


}
