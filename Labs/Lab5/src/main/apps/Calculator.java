package apps;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Calculator 
{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String NAME = "calculator!!!";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;

    public Calculator() 
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    private void createFrame() 
    {
        frame = new JFrame(NAME);

        frame.setSize(WIDTH, HEIGHT);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() 
    {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    private void displayFrame() 
    {
        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame()
    {
        return this.frame;
    }

    private void initializeInputs()
    {
        JPanel panel = new JPanel();
        leftOpField = new JTextField(10);
        leftOpField.setName("leftOperand");
        rightOpField = new JTextField(10);
        rightOpField.setName("rightOperand");

        panel.add(leftOpField, BorderLayout.LINE_START);
        panel.add(rightOpField, BorderLayout.LINE_END);


        frame.add(panel, BorderLayout.PAGE_START);
    }
    
    private void initializeResults()
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

        JButton add = new JButton("ADD");
        add.setName("addButton");
        JButton sub = new JButton("SUB");
        sub.setName("subButton");
        JButton mult = new JButton("MULT");
        mult.setName("multButton");
        JButton div = new JButton("DIV");
        div.setName("divButton");

        add.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });
        sub.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });
        mult.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });
        div.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (getRightNum() == 0) 
                {
                    updateResult(Double.NaN);
                }
                else 
                {
                    double result = getLeftNum() / getRightNum();
                    updateResult(result);
                }
            }
        });

        panel.add(add);
        panel.add(sub);
        panel.add(mult);
        panel.add(div);
        frame.add(panel, BorderLayout.SOUTH);
    }

    private void updateResult(double result)
    {
        if (Double.isNaN(result))
        {
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        }
        else
        {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }

    private double getLeftNum()
    {
        try
        {
            double result = Double.parseDouble(leftOpField.getText());
            return result;
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return Double.NaN;
        }
    }
    
    private double getRightNum()
    {
        try
        {
            double result = Double.parseDouble(rightOpField.getText());
            return result;
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return Double.NaN;
        }
    }
}
