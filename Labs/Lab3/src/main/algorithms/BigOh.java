package algorithms;

import java.util.Random;

/**
 * Class to represent algorithmic complexity
 * and compute it based on estimates.
 * @author Katherine McCarthy
 * @version 1.0.0
 * */
public class BigOh 
{
    private final static double MILLISECONDS_PER_SECOND = 1000;
    private final static int NUM_TRIALS = 5;
    private Random rand;

    /**
     * Zero arg constructor that sets a new random for the time complexity
    * analysis.
    * */
    public BigOh()
    {
        this.rand = new Random();
    }

    /**
     * One arg constructor that sets a rand to the provided random for time 
     * complexity analysis.
     * @param rand
    * */
    public BigOh(Random rand) 
    {
        this.rand = rand;
    }
    
    /**
     * Simple method that picks an algorithm to run based on the provided
     * choice and then runs it.
     * @param choice
     * @param numElements
     * @return the result of the algorithm.
     * */
    public int runAlgorithm(int choice, int numElements)
    {
        switch (choice)
        {
            case (1):
                return MysteryAlgorithms.alg1(numElements, rand);
            case (2):
                return MysteryAlgorithms.alg2(numElements, rand);
            case (3):
                return MysteryAlgorithms.alg3(numElements, rand);
            case (4):
                return MysteryAlgorithms.alg4(numElements, rand);
            case (5):
                return MysteryAlgorithms.alg5(numElements, rand);
            case (6):
                return MysteryAlgorithms.alg6(numElements, rand);
            default:
                return -1;
        }
    }
    /**
     * This method represents my interpretations of how long I expect
     * the algorithms to take to run.
     * @param choice
     * @param n
     * @return A double representing big O notation for the algorithm.
     * */
    public double bigOhFunc(int choice, double n)
    {
        switch (choice)
        {
            case (1):
                return n;
            case (2):
                return Math.pow(n, 3);
            case (3):
                return Math.pow(n, 2);
            case (4):
                return Math.pow(n, 2);
            case (5):
                return Math.pow(n, 5);
            case (6):
                return Math.pow(n, 4);
            default:
                return -1;
        }
    }

    /**
     * A procedure that runs one instance of an algorithm for timing.
     * @param choice
     * @param n
     * @return A double that represents the time it took for one instance of 
     * the algorithm to run.
     * */
    public double timeAlgorithm(int choice, int n)
    {
        System.gc();
        double startTime = System.currentTimeMillis();
        runAlgorithm(choice, n);
        double endTime = System.currentTimeMillis();
        return (endTime - startTime) / MILLISECONDS_PER_SECOND;
    }
    
    /**
     * Runs the above procedure NUM_TRIALS times for more accurate sampling.
     * @param choice
     * @param n
     * @return A double that represents the fastest time out of 5 trials.
     * */
    public double robustTimeAlgorithm(int choice, int n)
    {
        double minTime = Double.MAX_VALUE;
        for (int i = 0; i < NUM_TRIALS; i++) 
        {
            double algTime = timeAlgorithm(choice, n);
            if (algTime < minTime) 
            {
                minTime = algTime;
            }
        }
        return minTime;
    }
    
    /**
     * Using my estimate, this procedure calculates how long the algorithm
     * should realistically take to run.
     * @param choice
     * @param n1
     * @param t1
     * @param n2
     * @return double representing the estimated time the algorithm
     * will take to run.
     * */
    public double estimateTiming(int choice, int n1, double t1, int n2)
    {
        // estimates based on the function
        // should use the choice to determine the algorithm
        // and the provided parameters to determine the constant
        // then should return the constant*algorithm time complexity
        double param = bigOhFunc(choice, n1);
        double constant = t1 / param;
        return bigOhFunc(choice, n2) * constant;
    }

    /**
     * This simply serves as a helper method to abstract the error calculation.
     * @param correct
     * @param estimate
     * @return the percent error as a double
     * */
    public double percentError(double correct, double estimate)
    {
        return (estimate - correct) / correct;
    }

    /**
     * Using the data collected from robustTimeAlgorithm, this method
     * calculates the percent error based on my predictions, and the
     * actual time it took to run the algorithm.
     * @param choice
     * @param n1
     * @param n2
     * @return double representing the percent error of my prediction compared
     * with the actual runtime of the algorithm.
     * */
    public double computePercentError(int choice, int n1, int n2)
    {
        double bestTime = robustTimeAlgorithm(choice, n1);
        double secondAlgTimeEstimate = estimateTiming(choice, n1, bestTime, n2);
        double secondAlgActualTime = robustTimeAlgorithm(choice, n2);
        return percentError(secondAlgActualTime, secondAlgTimeEstimate);

    }
}
