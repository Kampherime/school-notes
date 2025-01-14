package client;

import maze.MazeSolver;

/**
 * Demo used to manually test the program.
 * 
 * @author 
 * @version 
 */
public class Demo
{
	/**
     * Runs the demo.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {
        MazeSolver t = new MazeSolver("data/maze1.txt");
        t.printMap();
        String solution = t.findSolution();
        if (solution != null)
        {
            System.out.println(solution);
        }
        else
        {
            System.out.println("There is no solution.");
        }
        MazeSolver m = new MazeSolver("data/maze2.txt");
        m.printMap();
        String solution2 = m.findSolution();
        if (solution2 != null)
        {
            System.out.println(solution2);
        }
        else
        {
            System.out.println("There is no solution.");
        }
    }
}
