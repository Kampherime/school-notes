package client;

import apps.Calculator;

import apps.ExpressionEvaluator;

/**
 * Demo used to manually test the program.
 * 
 * @author Willow Sapphire
 * @version 5/20/2019
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
        System.out.println(ExpressionEvaluator.toPostfix("1+2+3+45"));
        System.out.println(ExpressionEvaluator.toPostfix("(1+2)+(3+45)"));
    }
}
