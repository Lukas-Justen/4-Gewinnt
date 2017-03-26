package de.thbingen.hiwi.lukas.a4gewinnt;
 
import android.graphics.Point;
 
/**
 * Created by Martin on 06.03.2017.
 */
 
class Game {
    enum Player {P1, P2};
 
    private final int COLUMNS = 7;
    private final int ROWS = 6;
    private Player turn = Player.P1;
    private Player[][] positions = new Player[COLUMNS][ROWS];
    private Point[] winPositions = new Point[4];
 
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
            for(int x = 0; x < 7; x++)
            {
                Player[] p = positions[x];
                if( p[i] == turn )
                {
                    winPositions[c] = new Point(x,i);
                    c++;
                }
                else
                    c = 0;
 
                if( c >= 4 )
                    return true;
            }
        }
 
        // Vertikal
        for(int x = 0; x < 7; x++)
        {
            Player[] pc = positions[x];
            int c = 0;
            for(int y = 0; y < 6; y++)
            {
                Player p = pc[y];
                if( p == turn )
                {
                    winPositions[c] = new Point(x, y);
                    c++;
                }
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
                {
                    winPositions[c] = new Point(x, y);
                    c++;
                }
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
                {
                    winPositions[c] = new Point(x, y);
                    c++;
                }
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
                {
                    winPositions[c] = new Point(x, 5-y);
                    c++;
                }
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
                {
                    winPositions[c] = new Point(x, 5-y);
                    c++;
                }
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
 
    public Point[] getWinPositions()
    {
        return winPositions;
    }
}
