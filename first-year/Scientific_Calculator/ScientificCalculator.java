// Created by Russel Pardillo Quinto
// https://github.com/aurus-official/college-projects
// Built by creating a frame, application of encapsulation,
// and my own implementation.
// Usage of factory design pattern and recursion.

// NOTES :
// Fix / Refactor spaghetti code especially on calculation.
// Implement other buttons such as square root, percent and etc.
// Fixed zero division error.
// Fixed bug on floating point calculations.
// Fixed bug on negative numbers.
// Fixed recursion problem for multiple numbers.
// Fixed subtraction in multiple numbers.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ScientificCalculator {
    private final int INNER_PADDING = 10;
    private final int FRAME_HEIGHT = 340;
    private final int FRAME_WIDTH = 300;
    private final int OUTER_PADDING = 15;
    private String digitButtonText[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "." };
    private String operatorButtonText[] = { "/", "sqrt", "*", "%", "-", "1/X", "+", "=" };
    private String memoryButtonText[] = { "MC", "MR", "MS", "M+" };
    private String specialButtonText[] = { "CE", "AC" };
    private ArrayList<String> buffer = new ArrayList<String>();
    private Label currentLabel;
    private Label bufferLabel;
    private Frame main;
    private int max_digit_input = 4;
    private boolean isNegative = false;
    private boolean hasDecimalOnBuffer = false;

    ScientificCalculator() {
        main = new Frame();
        main.setTitle("Scientific Calculator");
        main.setVisible(true);
        main.setLayout(null);
        main.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        bufferLabel = new Label("", Label.RIGHT);
        bufferLabel.setBounds(OUTER_PADDING, 20, 270, 20);
        bufferLabel.setBackground(Color.BLACK);
        bufferLabel.setForeground(Color.WHITE);
        main.add(bufferLabel);

        currentLabel = new Label("0", Label.RIGHT);
        currentLabel.setBounds(OUTER_PADDING, 50, 270, 30);
        currentLabel.setBackground(Color.BLACK);
        currentLabel.setForeground(Color.WHITE);
        main.add(currentLabel);

        ArrayList<ButtonInfo> digitButtonList = new DigitButtonFactory(digitButtonText, INNER_PADDING, 50, 160)
                .getDigitButtonList();
        for (ButtonInfo i : digitButtonList) {
            Button tempButton = i.getValue();
            int[] tempCoords = i.getCoords();
            tempButton.setBounds(tempCoords[0], tempCoords[1], 40, 40);
            main.add(tempButton);

            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String tempLabelValue = currentLabel.getText();
                    boolean hasDecimal = tempLabelValue.contains(".");

                    if (hasDecimal) {
                        max_digit_input = 5;
                    } else {
                        max_digit_input = 4;
                    }

                    if (tempButton.getLabel().compareTo("+/-") == 0) {
                        isNegative = !isNegative;
                        if (isNegative && tempLabelValue.compareTo("0") != 0) {
                            currentLabel.setText(String.join("", "-", tempLabelValue));
                        } else if (tempLabelValue.compareTo("0") != 0) {
                            currentLabel.setText(tempLabelValue.substring(1, tempLabelValue.length()));
                        }

                    } else if (tempButton.getLabel().compareTo(".") == 0 && !hasDecimal) {
                        currentLabel.setText(tempLabelValue.concat("."));
                    } else if (tempLabelValue.compareTo("0") == 0) {
                        currentLabel.setText(tempButton.getLabel());
                    } else if (tempButton.getLabel().compareTo(".") != 0 && tempLabelValue.length() < max_digit_input) {
                        currentLabel.setText(tempLabelValue.concat(tempButton.getLabel()));
                    }
                }
            });
        }

        ArrayList<ButtonInfo> operatorButtonList = new OperatorButtonFactory(operatorButtonText, INNER_PADDING, 190,
                160).getOperatorButtonList();
        for (ButtonInfo i : operatorButtonList) {
            Button tempButton = i.getValue();
            int[] tempCoords = i.getCoords();
            tempButton.setBounds(tempCoords[0], tempCoords[1], 40, 40);
            main.add(tempButton);

            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String tempLabelValue = currentLabel.getText();
                    buffer.add(tempLabelValue);

                    switch (tempButton.getLabel()) {
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            if (tempLabelValue.contains(".")) {
                                hasDecimalOnBuffer = true;
                            }
                            buffer.add(String.format("%s", tempButton.getLabel()));
                            break;
                        case "=":
                            if (tempLabelValue.contains(".")) {
                                hasDecimalOnBuffer = true;
                            }
                            bufferLabel.setText("");
                            for (String i : buffer) {
                                bufferLabel.setText(String.join(" ", bufferLabel.getText(), i));
                            }
                            evaluateEquation();
                            try {
                                bufferLabel
                                        .setText(bufferLabel.getText().concat(String.format(" = %s", buffer.get(0))));
                            } catch (IndexOutOfBoundsException iee) {
                                System.out.println("NO DIVISION!");
                            }
                            buffer.clear();
                            isNegative = false;
                            hasDecimalOnBuffer = false;
                            break;
                    }

                    currentLabel.setText("0");
                }
            });
        }

        ArrayList<ButtonInfo> memoryButtonList = new MemoryButtonFactory(memoryButtonText, INNER_PADDING, 10, 160)
                .getMemoryButtonList();
        for (ButtonInfo i : memoryButtonList) {
            Button tempButton = i.getValue();
            int[] tempCoords = i.getCoords();
            tempButton.setBounds(tempCoords[0], tempCoords[1], 40, 40);
            main.add(tempButton);
        }

        ArrayList<ButtonInfo> specialButtonList = new SpecialButtonFactory(specialButtonText, INNER_PADDING, 10, 110)
                .getSpecialButtonList();
        for (ButtonInfo i : specialButtonList) {
            Button tempButton = i.getValue();
            int[] tempCoords = i.getCoords();
            tempButton.setBounds(tempCoords[0], tempCoords[1], 60, 40);
            main.add(tempButton);

            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String tempLabelValue = currentLabel.getText();
                    if (tempButton.getLabel().compareTo("AC") == 0 || tempLabelValue.length() < 2) {
                        currentLabel.setText("0");
                    } else if (tempButton.getLabel().compareTo("CE") == 0 && tempLabelValue.length() > 1) {
                        currentLabel.setText(tempLabelValue.substring(0, tempLabelValue.length() - 1));
                    }
                }
            });
        }
    }

    public void evaluateEquation() {
        String operatorPrecendence[] = { "*", "/", "+", "-" };

        for (String i : operatorPrecendence) {
            int opIndex = buffer.indexOf(i);

            if (opIndex == -1) {
                continue;
            }

            ArrayList<String> tempEqu = new ArrayList<>();
            tempEqu.add(buffer.remove(opIndex + 1));
            tempEqu.add(buffer.remove(opIndex));
            tempEqu.add(buffer.remove(opIndex - 1));

            switch (tempEqu.get(1)) {
                case "*":
                    if (hasDecimalOnBuffer) {
                        float num1 = Float.parseFloat(tempEqu.get(0));
                        float num2 = Float.parseFloat(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%.2f", num1 * num2));
                    } else {
                        int num1 = Integer.parseInt(tempEqu.get(0));
                        int num2 = Integer.parseInt(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%d", num1 * num2));
                    }
                    evaluateEquation();
                    break;

                case "/":
                    if (hasDecimalOnBuffer) {
                        float num1 = Float.parseFloat(tempEqu.get(0));
                        float num2 = Float.parseFloat(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%.2f", num1 / num2));
                    } else {
                        int num1 = Integer.parseInt(tempEqu.get(0));
                        int num2 = Integer.parseInt(tempEqu.get(2));
                        try {
                            buffer.add(opIndex - 1, String.format("%d", num1 / num2));
                        } catch (ArithmeticException e) {
                            bufferLabel.setText("Zero Division Error!");
                        }
                    }
                    evaluateEquation();
                    break;

                case "+":
                    if (hasDecimalOnBuffer) {
                        float num1 = Float.parseFloat(tempEqu.get(0));
                        float num2 = Float.parseFloat(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%.2f", num1 + num2));
                    } else {
                        int num1 = Integer.parseInt(tempEqu.get(0));
                        int num2 = Integer.parseInt(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%d", num1 + num2));
                    }
                    evaluateEquation();
                    break;

                case "-":
                    if (hasDecimalOnBuffer) {
                        float num1 = Float.parseFloat(tempEqu.get(0));
                        float num2 = Float.parseFloat(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%.2f", num2 - num1));
                    } else {
                        int num1 = Integer.parseInt(tempEqu.get(0));
                        int num2 = Integer.parseInt(tempEqu.get(2));
                        buffer.add(opIndex - 1, String.format("%d", num2 - num1));
                    }
                    evaluateEquation();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ScientificCalculator sc = new ScientificCalculator();
    }
}

class DigitButtonFactory {
    private ArrayList<ButtonInfo> digitButtonList = new ArrayList<ButtonInfo>();

    DigitButtonFactory(String digitArrayText[], int padding, int x, int y) {
        for (int i = 0; i < digitArrayText.length; ++i) {
            Button tempButton = new Button(digitArrayText[i]);
            if (i % 3 == 0 && i != 0) {
                x = 50;
                y += 40;
            }
            ButtonInfo tempDigitButton = new ButtonInfo(x + padding, y, tempButton);
            digitButtonList.add(tempDigitButton);
            x += 40;
        }
    }

    public ArrayList<ButtonInfo> getDigitButtonList() {
        return digitButtonList;
    }
}

class OperatorButtonFactory {
    private ArrayList<ButtonInfo> operatorButtonList = new ArrayList<ButtonInfo>();

    OperatorButtonFactory(String operatorArrayText[], int padding, int x, int y) {
        for (int i = 0; i < operatorArrayText.length; ++i) {
            Button tempButton = new Button(operatorArrayText[i]);
            if (i % 2 == 0 && i != 0) {
                x = 190;
                y += 40;
            }

            ButtonInfo tempDigitButton = new ButtonInfo(x + padding, y, tempButton);
            operatorButtonList.add(tempDigitButton);
            x += 40;
        }
    }

    public ArrayList<ButtonInfo> getOperatorButtonList() {
        return operatorButtonList;
    }
}

class MemoryButtonFactory {
    private ArrayList<ButtonInfo> memoryButtonList = new ArrayList<ButtonInfo>();

    MemoryButtonFactory(String memoryArrayText[], int padding, int x, int y) {
        for (int i = 0; i < memoryArrayText.length; ++i) {
            Button tempButton = new Button(memoryArrayText[i]);
            ButtonInfo tempDigitButton = new ButtonInfo(x + padding, y, tempButton);
            memoryButtonList.add(tempDigitButton);
            y += 40;
        }
    }

    public ArrayList<ButtonInfo> getMemoryButtonList() {
        return memoryButtonList;
    }
}

class SpecialButtonFactory {
    private ArrayList<ButtonInfo> specialButtonList = new ArrayList<ButtonInfo>();

    SpecialButtonFactory(String specialArrayText[], int padding, int x, int y) {
        for (int i = 0; i < specialArrayText.length; ++i) {
            Button tempButton = new Button(specialArrayText[i]);
            ButtonInfo tempDigitButton = new ButtonInfo(x + padding, y, tempButton);
            specialButtonList.add(tempDigitButton);
            x += 60;
        }
    }

    public ArrayList<ButtonInfo> getSpecialButtonList() {
        return specialButtonList;
    }
}

class ButtonInfo {
    private int x;
    private int y;
    private Button value;

    ButtonInfo(int x, int y, Button value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int[] getCoords() {
        int[] coords = { x, y };
        return coords;
    }

    public Button getValue() {
        return value;
    }
}
