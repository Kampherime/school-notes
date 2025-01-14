package apps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import apps.ExpressionEvaluator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
    private static final int X_LOC = 50;
    private static final int Y_LOC = 50;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final String NAME = "Calculator";
    private static final String RESULT_PREAMBLE = "Result: ";
    private static final String ERROR_MESSAGE = "ERROR: ";
    private JFrame frame;
    private JTextField infixExpression;
    private JLabel resultLabel;

    public Calculator() 
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    public JFrame getFrame()
    {
        return this.frame;
    }

    private void createFrame() 
    {
        frame = new JFrame(NAME);

        frame.setSize(WIDTH, HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() 
    {
        initializeInput();
        initializeResult();
        initializeButtons();
    }

    private void displayFrame() 
    {
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeInput()
    {
        JPanel panel = new JPanel();
        infixExpression = new JTextField(10);
        infixExpression.setName("infixExpression");

        panel.add(infixExpression, BorderLayout.LINE_START);


        frame.add(panel, BorderLayout.PAGE_START);
    }
    
    private void initializeResult()
    {
        JPanel panel = new JPanel();

        resultLabel = new JLabel(RESULT_PREAMBLE);
        resultLabel.setName("resultLabel");


        panel.add(resultLabel, BorderLayout.LINE_END);
        frame.add(panel, BorderLayout.LINE_END);
    }

    private void initializeButtons() 
    {
        JPanel panel = new JPanel();

        JButton calculateButton= new JButton("calculateButton");
        calculateButton.setName("calculateButton");
        JButton clearButton= new JButton("clearButton");
        clearButton.setName("clearButton");

        calculateButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = calculate();
                updateResult(result);
            }
        });

        clearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                infixExpression.setText("");
            }
        });
        panel.add(calculateButton);
        panel.add(clearButton);
        frame.add(panel, BorderLayout.SOUTH);
    }
    private String calculate()
    {
        String postfixExpression = ExpressionEvaluator.toPostfix(infixExpression.getText());
        Double ans = ExpressionEvaluator.evaluate(postfixExpression);
        return ans.toString();
    }
    private void updateResult(String result)
    {
            resultLabel.setText(RESULT_PREAMBLE + result);
    }
}
