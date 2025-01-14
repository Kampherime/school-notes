package maze;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * MazeSolver is a backtracking version of MazeGame.
 * 
 * @author Mitch Parry
 * @author Willow Sapphire
 * @version 11/02/2023
 */
public class MazeSolver
{
    /**
     * The height of game maps.
     */
    private final static int HEIGHT = 99;

    /**
     * The width of game maps.
     */
    private final static int WIDTH = 99;

    /**
     * The game map, as a 2D array of booleans.
     * True indicates the spot is blocked.
     */
    private boolean[][] wall;

    private boolean[][] visited = new boolean[HEIGHT][WIDTH];


    /**
     * Constructor sets up the maps and the path list.
     * 
     * @param mazeFile name of the file containing the map.
     */

    public MazeSolver(String mazeFile)
    {
        loadMaze(mazeFile);
    }

    /**
     * Loads the data from the maze file and creates the map
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        wall = new boolean[HEIGHT][WIDTH];
        Scanner mazeScanner;
        try
        {
            mazeScanner = new Scanner(new FileReader(mazeFile));
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    if (mazeScanner.next().equals("1"))
                    {
                        wall[i][j] = true;
                    }
                }
            }
            mazeScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + mazeFile);
        }
    }

    /**
     * Prints the map.
     */
    public void printMap()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (wall[i][j])
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public String findSolution()
    {
        return backtrack(0, 0, "");
    }

    private String backtrack(int row, int col, String foundPath)
    {

        // Row + 1 = down; Col + 1 = right; row - 1 = up; col - 1 = left;
        if (row == 98 && col == 98)
            return foundPath;

        visited[row][col] = true;
        
        if (valid(row, col+1))
        {
            String result = backtrack(row, col+1, foundPath + "right ");
            if (result != null) 
                return result;
        }
        if (valid(row+1, col))
        {
            String result = backtrack(row+1, col, foundPath + "down ");
            if (result != null) 
                return result;
        }
        if (valid(row-1, col))
        {
            String result = backtrack(row-1, col, foundPath + "up ");
            if (result != null) 
                return result;
        }
        if (valid(row, col-1))
        {
            String result = backtrack(row, col-1, foundPath + "left ");
            if (result != null) 
                return result;
        }
        return null;
    }

    private boolean valid(int row, int col)
    {
        if((row < 0 || col < 0) || (row > 98 || col > 98))
            return false; 
        if (!visited[row][col] && !wall[row][col])
            return true;
        return false;
    }
}
