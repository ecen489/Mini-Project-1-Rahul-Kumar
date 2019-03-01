package com.example.rahulkumar.connectfour;

public class cell {
    public boolean empty;
    public board.Turn player;

    public cell() {
        empty = true;
    }

    public void setPlayer(board.Turn player) {
        this.player = player;
        empty = false;
    }
}
