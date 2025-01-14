package maze;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 * A class that traverses a binary based
*  maze.
*  @author Katherine McCarthy
*  @version 1.0.0
*  */
public class MazeGame 
{
    final static public int HEIGHT = 19;
    final static public int WIDTH = 39;
    final static private int ROW = 0;
    final static private int COL = 1;
    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;
    private int[] player;
    private int[] goal;
    private int[] start;
    
    /**
     * One-arg constructor for the MazeGame class.
     * @throws FileNotFoundException
     * @param mazeFile 
     */ 
    public MazeGame(String mazeFile) throws FileNotFoundException
    {
        this(mazeFile, new Scanner(System.in)); 
    }
 
    /**
     * Two-arg constructor for the MazeGame class.
     * @throws FileNotFoundException
     * @param mazeFile
     * @param playerInput
     */ 
    public MazeGame(String mazeFile, Scanner playerInput) 
        throws FileNotFoundException
    {
        this.playerInput = playerInput;
        loadMaze(mazeFile);
    }
    /**
     * An accumulation of all of the helper methods
     * that were created throughout the class.
     * Runs the game in a do while loop.
     */
    public void playGame() 
    {
        do
        {
            prompt();
            String input = playerInput.nextLine();
            boolean playerWon = makeMove(input);
            if (playerWon)
            {
                break;
            }

            
        } while (true);
        if (playerAtGoal()) 
        {
            System.out.println("You Won!");
        }
        else 
        {
            System.out.println("Goodbye!");
        }

    }
    /**
     * Prints an output of the maze to the console.
    */
    public void printMaze() 
    {
        System.out.println("*" + "---------------------------------------" 
            + "*");
        for (int i = 0; i < HEIGHT; i++)
        {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++)
            {
                if (player[ROW] == i && player[COL] == j) 
                {
                    System.out.print("@"); 
                }
                else if (goal[ROW] == i && goal[COL] == j) 
                {
                    System.out.print("G");
                }
                else if (start[ROW] == i && start[COL] == j) 
                {
                    System.out.print("S");
                }
                else if (visited[i][j]) 
                {
                    System.out.print(".");
                }
                else if (blocked[i][j]) 
                {
                    System.out.print("X");
                }
                else 
                {
                    System.out.print(" ");
                }
                
            }
            System.out.print("|\n");
        }
        System.out.println("*" + "---------------------------------------" 
            + "*");
    }
    /**
     * Simple getter for the player row.
     * @return row value of player.
     **/
    public int getPlayerRow()
    {
        return this.player[ROW];
    }

    /**
     * Simple getter for the player column.
     * @return column value of player.
     **/
    public int getPlayerCol() 
    {
        return this.player[COL];
    }
    /**
     * Simple getter for the value of the goal's row.
     * @return row value of the goal.
     **/ 
    public int getGoalRow()
    {
        return this.goal[ROW];
    }
     
    /**
     * Simple getter for the value of the goal's column.
     * @return column value of the goal.
     **/ 
    public int getGoalCol()
    {
        return this.goal[COL];
    }
    
    /**
     * Simple getter for the value of the start row.
     * @return row value of the start.
     **/ 
    public int getStartRow()
    {
        return this.start[ROW];
    }

    /**
     * Simple getter for the value of the start column.
     * @return column value of the start.
     **/ 
    public int getStartCol()
    {
        return this.start[COL];
    }
    /**
     * Returns a copy of the blocked array using a helper method.
     * @return Copy of the blocked array.
     **/
    public boolean[][] getBlocked()
    {
        return copyTwoDimBoolArray(blocked); 
    }

    /**
     * Returns a copy of the visited array using a helper method.
     * @return Copy of the visited array.
     **/
    public boolean[][] getVisited()
    {
        return copyTwoDimBoolArray(visited);
    }

    /**
     * Simple getter for the playerInput scanner.
     * @return playerInput scanner.
     **/
    public Scanner getPlayerInput()
    {
        return this.playerInput; 
    }
    /**
     * Setter for the row of the player.
     * @param row
     **/
    public void setPlayerRow(int row)
    {
        if (row <= HEIGHT && row >= 0)
        {
            this.player[ROW] = row;
        }
    }

    /**
     * Setter for the column of the player.
     * @param col
     **/
    public void setPlayerCol(int col)
    {   if (col <= WIDTH && col >= 0)
        {
            this.player[COL] = col;
        }
    }

    /**
     * Setter for the row of the goal.
     * @param row
     **/
    public void setGoalRow(int row)
    {
        if (row <= HEIGHT && row >= 0)
        {
            this.goal[ROW] = row;
        }
    }

    /**
     * Setter for the column of the goal.
     * @param col
     **/
    public void setGoalCol(int col)
    {
        if (col <= WIDTH && col >= 0)
        {
            this.goal[COL] = col;
        }
    }

    /**
     * Setter for the row of the start mark.
     * @param row
     **/
    public void setStartRow(int row)
    {   
        if (row <= HEIGHT && row >= 0)
        { 
            this.start[ROW] = row;
        }
    }

    /**
     * Setter for the column of the start mark.
     * @param col
     **/
    public void setStartCol(int col)
    { 
        if (col <= WIDTH && col >= 0)
        { 
            this.start[COL] = col;
        }
    }
    /**
     * Sets the current blocked array to a copy of a new blocked array.
     * @param blocked
     **/
    public void setBlocked(boolean[][] blocked)
    {
        this.blocked = copyTwoDimBoolArray(blocked);
    }

    /**
     * Sets the current visited array to a copy of a new visited array.
     * @param visited 
     **/
    public void setVisited(boolean[][] visited)
    {
        this.visited = copyTwoDimBoolArray(visited);
    }
    /**
     * Sets the playerInput scanner to a new instance of the specified scanner.
     * @param playerInput
     **/
    public void setPlayerInput(Scanner playerInput)
    {
        this.playerInput = playerInput;
    }
    /**
     * A helper method that copies a 2 dimensional boolean array.
     * @param arrayToCopy
     * @return new 2 dimensional boolean array
     **/
    private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy)
    {
        int numberOfArrays = arrayToCopy.length;
        int lengthOfArrays = arrayToCopy[0].length;
        boolean[][] retArray = new boolean[numberOfArrays][lengthOfArrays];
        for (int i = 0; i < numberOfArrays; i++)
        {
            for (int j = 0; j < lengthOfArrays; j++)
            {
                retArray[i][j] = arrayToCopy[i][j];
            }
        }
        return retArray;
    }
    /**
     * A prompt for user input written to the terminal.
     * Also calls printMaze() to give the user context.
     **/
    private void prompt()
    {
        printMaze();
        System.out.print(
                "Enter your move (up, down, left, right, or q to quit): "
        );
    }
    /**
     * A helper method that checks whether the player 
     * coordinates are at the goal.
     * @return a boolean designating if the player has won or not.
     **/
    private boolean playerAtGoal()
    {
        return player[COL] == goal[COL] && player[ROW] == goal[ROW];
    }
    /**
     * A helper method that checks if a square is in bounds, 
     * or if it is blocked.
     * @param row
     * @param col
     * @return a boolean designaing a blocked location or an open location.
     * */
    private boolean valid(int row, int col)
    {
        return ((col >= 0 && row >= 0) 
            && (col < WIDTH && row < HEIGHT) && !blocked[row][col]);
    }
    /**
     * A helper method that sets a location to be visited by the player.
     * Used in makeMove()
     * @param row
     * @param col
     **/
    private void visit(int row, int col)
    {
        this.visited[row][col] = true;
    }
    /**
     * A large method that parses an input file and
     * loads an appropriate maze.
     * @param mazeFile
     * @throws FileNotFoundException
     **/
    private void loadMaze(String mazeFile) throws FileNotFoundException
    {
        visited = new boolean[HEIGHT][WIDTH];
        blocked = new boolean[HEIGHT][WIDTH];
        player = new int[2];
        goal = new int[2];
        start = new int[2];
        
        File file = new File(mazeFile);
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                String nextChar = scanner.next();                
                switch (nextChar) 
                {
                    case ("1"):
                        blocked[i][j] = true;
                        break;
                    case ("0"):
                        blocked[i][j] = false;
                        break;
                    case ("S"):
                        setStartRow(i);
                        setStartCol(j);
                        setPlayerRow(i);
                        setPlayerCol(j);
                        break;
                    case ("G"):
                        setGoalRow(i);
                        setGoalCol(j);
                        break; 
                    default:
                        continue;
                }
            }
        }
    
        File maze = new File(mazeFile);
        
    }
    
    private boolean makeMove(String move)
    {
        char moveDir = move.toLowerCase().charAt(0);
        switch (moveDir) 
        {
            case 'q':
                return true;
            case 'l':
                if (valid(player[ROW], player[COL] - 1))
                {
                    visit(player[ROW], player[COL] - 1);
                    setPlayerCol(player[COL] - 1);
                    return playerAtGoal();
                }
                break;
            case 'r':
                if (valid(player[ROW], player[COL] + 1))
                {
                    visit(player[ROW], player[COL] + 1);
                    setPlayerCol(player[COL] + 1);
                    return playerAtGoal();
                }
                break;
            case 'd':
                if (valid(player[ROW] + 1, player[COL]))
                {
                    visit(player[ROW] + 1, player[COL]);
                    setPlayerRow(player[ROW] + 1);
                    return playerAtGoal();
                }
                break;
            case 'u':
                if (valid(player[ROW] - 1, player[COL]))
                {
                    visit(player[ROW] - 1, player[COL]);
                    setPlayerRow(player[ROW] - 1);
                    return playerAtGoal();
                }
                break;
            default:
                System.out.println("Invalid move");
        }
        return false;
    }
}
