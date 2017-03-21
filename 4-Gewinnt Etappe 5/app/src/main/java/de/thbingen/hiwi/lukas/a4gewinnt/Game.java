package de.thbingen.hiwi.lukas.a4gewinnt;

/**
 * Created by Martin on 06.03.2017.
 */

class Game {
    enum Player {P1, P2};

    private final int COLUMNS = 7;
    private final int ROWS = 6;
    private Player turn = Player.P1;
    private Player[][] positions = new Player[COLUMNS][ROWS];

    int insert(int column) {
        int row = 0;
        while (row + 1 < ROWS && positions[column][row + 1] == null)
            row++;

        if (positions[column][row] == null) {
            positions[column][row] = turn;
            return row;
        }

        return -1;
    }

    boolean checkWin() {
        // Horizontal
        for(int i = 0; i < positions[0].length; i++)
        {
            int c = 0;
            for(Player[] p : positions)
            {
                if( p[i] == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }

        // Vertikal
        for(Player[] pc : positions)
        {
            int c = 0;
            for(Player p : pc)
            {
                if( p == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }
        // Diagonal - top left to bottom right
        for(int i = 0; i < 3; i++)
        {
            int c = 0;
            for(int x = 0; x <= 5-i; x++)
            {
                int y = i+x;
                if( positions[x][y] == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }
        for(int i = 1; i <= 3; i++)
        {
            int c = 0;
            for(int y = 0; y <= 6-i; y++)
            {
                int x = i+y;
                if( positions[x][y] == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }
        // Diagonal - bottom left to top right
        for(int i = 0; i < 3; i++)
        {
            int c = 0;
            for(int x = 0; x <= 5-i; x++)
            {
                int y = i+x;
                if( positions[x][5-y] == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }
        for(int i = 1; i <= 3; i++)
        {
            int c = 0;
            for(int y = 0; y <= 6-i; y++)
            {
                int x = i+y;
                if( positions[x][5-y] == turn )
                    c++;
                else
                    c = 0;

                if( c >= 4 )
                    return true;
            }
        }
        return false;
    }

    void nextPlayer() {
        turn = turn == Player.P1 ? Player.P2 : Player.P1;
    }

    Player getPlayerTurn() {
        return turn;
    }

}