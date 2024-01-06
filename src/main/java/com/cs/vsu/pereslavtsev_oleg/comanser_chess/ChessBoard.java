package com.cs.vsu.pereslavtsev_oleg.comanser_chess;

import org.example.Figure.*;
import org.example.Game.*;
import org.example.Player.PlayerOnBoard;
import org.example.moving.MovingInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard extends JFrame {
    private final JPanel chessBoardPanel;
    private final Board board;
    private boolean clickedFlag;
    private FigureInterface movedFigure;
    private Coordinates clickedCoords;
    private List<Coordinates> variantsCoords;
    private MovingInterface clickedMoving;
    private GameState gs;

    public ChessBoard(GameState gs) {
        this.gs =gs;
        if(gs.getWhitePlayerInterface1().isPlayer()){
            ((PlayerOnBoard) gs.getWhitePlayerInterface1()).setBoard(this);
        }
        if(gs.getBlackPlayerInterface2().isPlayer()){
            ((PlayerOnBoard) gs.getBlackPlayerInterface2()).setBoard(this);
        }

        this.board = gs.getBoard();
        this.clickedFlag = false;
        setLayout(new BorderLayout());
        chessBoardPanel = new JPanel(new GridLayout(12, 12));
        add(chessBoardPanel, BorderLayout.CENTER);
        createChessBoard();
        chessBoardPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(gs.isGameWasFinished()){
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gs.stepBack();
                    resetChessBoard();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        gs.setStep();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    resetChessBoard();
                }
            }
        });
        setSize(480, 480);
        setLocationRelativeTo(null);
        chessBoardPanel.setFocusable(true);
        chessBoardPanel.requestFocusInWindow();
        setVisible(true);
    }
    private void createChessBoard() {
        Color lightSquareColor = new Color(255, 206, 158);
        Color darkSquareColor = new Color(209, 139, 71);
        for (int row = 0; row < 12; row++) {
            for (int col = 0 ; col < 12; col++) {
                if( isWizardSells(row, col)){
                    JPanel square = new JPanel();
                    square.setPreferredSize(new Dimension(40, 40));
                    chessBoardPanel.add(square);
                    continue;
                }
                JPanel square = new JPanel();
                square.setPreferredSize(new Dimension(40, 40));
                if ((row + col) % 2 == 0) {
                    square.setBackground(lightSquareColor);
                } else {
                    square.setBackground(darkSquareColor);
                }
                square.addMouseListener(new ChessBoardClickListener(row - 1, col - 1));
                addChessPiece(square, row, col);
                chessBoardPanel.add(square);
            }
        }
    }
    private void addChessPiece(JPanel square, int row, int col) {
        FigureInterface f = board.getCell(row  - 1 , col - 1).getFigure();
        if(f != null) {
            addPiece(square, f.getName(), f.getIsWhite());
        }
    }
    private void addPiece(JPanel square, String piece, boolean isWhite) {
        JLabel label = new JLabel(piece, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        if(isWhite){
            label.setForeground(Color.WHITE);
        }else{
            label.setForeground(Color.BLACK);
        }
        square.add(label);
    }
    private class ChessBoardClickListener implements java.awt.event.MouseListener {
        private final int row;
        private final int col;
        public ChessBoardClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if(gs.isGameWasFinished()){
                return;
            }
            if(clickedFlag  && board.getCell(row, col) != null){
                boolean flag = false;
                for(Coordinates coordinates : variantsCoords){
                    if (coordinates.getX() == row && coordinates.getY() == col) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    return;
                }
                Cell cell = board.getCell(clickedCoords.getX(), clickedCoords.getY());
                Cell cell2 = board.getCell(row, col);
                cell2.setFigure(movedFigure);
                movedFigure.setCell(cell2);
                cell.setFigure(null);
                clickedFlag = false;
                resetChessBoard();
                variantsCoords = null;
            }else{
                movedFigure = board.getCell(row, col).getFigure();
                clickedCoords = movedFigure.getCell().getCoordinates();
                MovingInterface[] coordinates = movedFigure.getMovingVariants();
                clickedFlag = true;
                variantsCoords = new ArrayList<>();
                for (MovingInterface moving : coordinates){
                    if(moving == null){
                        continue;
                    }
                    for (Coordinates coord : moving.getCoordinates()){
                        if(coord == null){
                            continue;
                        }
                        variantsCoords.add(coord);
                        clickedMoving = moving;
                        highlightSquare(coord.getX(), coord.getY());
                    }
                }
            }
        }
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        }
    }
    private void highlightSquare(int row, int col) {
        ((JPanel) chessBoardPanel.getComponent(( row + 1 ) * 12 + (col + 1))).setBackground(Color.GREEN);
    }
    private boolean isWizardSells(int row, int col){
        return (row == 11 || row == 0 || col == 0 || col == 11) && !((row == 0 && col == 0) ||(row == 11 && col == 0) ||(row == 0 && col == 11) ||(row == 11 && col == 11));
    }
    private void setStep(){
        try {
            gs.setStep();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void resetChessBoard() {
        chessBoardPanel.removeAll();
        createChessBoard();
        chessBoardPanel.revalidate();
        chessBoardPanel.repaint();
    }
    public MovingInterface getClickedMoving() {
        return clickedMoving;
    }
    public void setClickedMovingNull() {
        clickedMoving = null;
    }
}
