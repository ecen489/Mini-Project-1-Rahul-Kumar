package com.example.rahulkumar.connectfour;

public class board {
    private int numCols;
    private int numRows;
    public boolean hasWinner;
    public cell[][] cells;

    public enum Turn {
        FIRST, SECOND
    }

    public Turn turn;

    public board(int cols, int rows) {
        numCols = cols;
        numRows = rows;
        cells = new cell[cols][rows];
        reset();
    }

    public void reset() {
        hasWinner = false;
        turn = Turn.FIRST;
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                cells [col][row] = new cell();
            }
        }
    }

    public int lastRow(int col) {
        for (int row = numRows - 1; row >= 0; row--) {
            if (cells[col][row].empty) {
                return row;
            }
        }
        return -1;
    }

    public void fillCell(int col, int row) {
        cells[col][row].setPlayer(turn);
    }

    public void toggleTurn() {
        if (turn == Turn.FIRST) {
            turn = Turn.SECOND;
        } else {
            turn = Turn.FIRST;
        }
    }

    public boolean checkWin(int c, int r) {
        for (int col = 0; col < numCols; col++) {
            if (isSame(turn, 0, 1, col, 0, 0) || isSame(turn, 1, 1, col, 0, 0) || isSame(turn, -1, 1, col, 0, 0)) {
                hasWinner = true;
                return true;
            }
        }
        for (int row = 0; row < numRows; row++) {
            if (isSame(turn, 1, 0, 0, row, 0) || isSame(turn, 1, 1, 0, row, 0) || isSame(turn, -1, 1, numCols - 1, row, 0)) {
                hasWinner = true;
                return true;
            }
        }
        return false;
    }

    private boolean isSame(Turn player, int dirX, int dirY, int col, int row, int count) {
        if (count >= 4) {
            return true;
        }
        if (col < 0 || col >= numCols || row < 0 || row >= numRows) {
            return false;
        }
        cell cell = cells[col][row];
        if (cell.player == player) {
            return isSame(player, dirX, dirY, col + dirX, row + dirY, count + 1);
        } else {
            return isSame(player, dirX, dirY, col + dirX, row + dirY, 0);
        }
    }

}
