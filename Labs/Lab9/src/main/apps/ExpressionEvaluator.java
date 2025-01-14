package apps;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    public static String toPostfix(String expression) 
    {
        Stack<Character> stack = new Stack<>();
        String retString = "";
        Scanner scanner = new Scanner(expression);

        do {
            if (scanner.hasNext(UNSIGNED_DOUBLE))
            {
                retString += scanner.findInLine(UNSIGNED_DOUBLE) + " ";
            }
            else {
                char token = scanner.findInLine(CHARACTER).charAt(0);

                if (token == '(')
                {
                    stack.push('(');
                }

                else if (token == ')') {
                    while (stack.peek() != '(') {
                        retString += (stack.pop() + " ");
                    }
                    stack.pop(); 
                }

                else {
                    while (!stack.isEmpty() && higherPrecedence(token, stack.peek())) {
                        retString += (stack.pop() + " ");
                    }
                    stack.push(token);
                }

            }
        } while (scanner.hasNext());

        while (!stack.isEmpty()) {
            retString += (stack.pop() + " ");
        }
        scanner.close();
        return retString;
    }

    public static double evaluate(String postfixExpression) 
    {
        Stack<Double> stack = new Stack<>();
        Scanner scanner = new Scanner(postfixExpression);
        do  
        {
            if (scanner.hasNext(UNSIGNED_DOUBLE))
                stack.push(Double.parseDouble(scanner.findInLine(UNSIGNED_DOUBLE)));
            else {
                char op = scanner.findInLine(CHARACTER).charAt(0);
                double b = stack.pop();
                double a = stack.pop();
                stack.push(performOperation(a, b, op));
            }
        } while (scanner.hasNext());
        scanner.close();
        return stack.pop();
    }
    
    private static boolean higherPrecedence(char current, char top) 
    {
        return (operatorPrecedence(current) <= operatorPrecedence(top));
    }

    private static double performOperation(double a, double b, char c)
    {
        switch(c)
        {
            case('+'):
                return a + b;
            case('-'):
                return a - b;
            case('*'):
                return a * b;
            case('/'):
                return a / b;
            case('^'):
                return Math.pow(a, b);
        }
        return -1;
    }

    private static int operatorPrecedence(char op)
    {
        switch(op)
        {
            case('+'):
            case('-'):
                return 1;
            case('*'):
            case('/'):
                return 2;
            case('^'):
                return 3;
        }
        return -1;
    }
}
