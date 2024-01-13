package com.cs.vsu.pereslavtsev_oleg.comander_chess.figure;

public abstract class AbstractFabricInterface implements FabricInterface {
    private boolean isRed;
    private String symbol;

    public AbstractFabricInterface(boolean isRed, String symbol) {
        this.isRed = isRed;
        this.symbol = symbol;
    }
    @Override
    public String getSymbol() {
        return symbol;
    }

    protected boolean isRed() {
        return isRed;
    }
}
