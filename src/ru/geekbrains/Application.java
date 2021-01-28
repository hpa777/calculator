package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application extends JFrame {


    private JPanel panel1;
    private JButton plusButton;
    private JButton minusButton;
    private JButton timesButton;
    private JButton equalsButton;
    private JPanel numPanel;
    private JTextField textField1;
    private JButton divideButton;
    private JButton sqrButton;
    private JButton clearButton;

    private boolean operatePress;
    private boolean dotPress;
    private boolean sqrPress;

    private void initFlags() {
        operatePress = true;
        dotPress = true;
        sqrPress = false;
    }

    public Application() {
        setTitle("Calc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 250, 280);
        setResizable(false);
        setVisible(true);
        setContentPane(panel1);
        initFlags();

        ActionListener pressOperateButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!operatePress) {
                    if (!e.getActionCommand().equals("sqr")) {
                        operatePress = true;
                        sqrPress = false;
                    } else {
                        if (sqrPress) {
                            return;
                        }
                        sqrPress = true;
                    }
                    textField1.setText(textField1.getText().concat(e.getActionCommand()));
                }
            }
        };
        plusButton.addActionListener(pressOperateButton);
        minusButton.addActionListener(pressOperateButton);
        timesButton.addActionListener(pressOperateButton);
        divideButton.addActionListener(pressOperateButton);
        sqrButton.addActionListener(pressOperateButton);

        ActionListener pressNumButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sqrPress) {
                    return;
                }
                textField1.setText(textField1.getText().concat(e.getActionCommand()));
                if (operatePress) {
                    dotPress = false;
                }
                operatePress = false;

            }
        };
        String btnText = "7894561230";
        for (int i = 0; i < btnText.length(); i++) {
            JButton button = new JButton(String.valueOf(btnText.charAt(i)));
            button.addActionListener(pressNumButton);
            numPanel.add(button);
        }
        JButton dotButton = new JButton(".");
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dotPress) {
                    textField1.setText(textField1.getText().concat(e.getActionCommand()));
                    dotPress = true;
                }
            }
        });
        numPanel.add(dotButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                initFlags();
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern pattern = Pattern.compile("(\\d+[.]?\\d*)(sqr)?(([\\+\\-\\*\\/]))?");
                Matcher matcher = pattern.matcher(textField1.getText());
                double result = 0;
                String operator = null;
                while (matcher.find()) {
                    double operand = Double.valueOf(matcher.group(1));
                    if (matcher.group(2) != null) {
                        operand *= operand;
                    }
                    if (operator == null) {
                        result = operand;
                    } else {
                        switch (operator) {
                            case "+": {
                                result += operand;
                                break;
                            }
                            case "-": {
                                result -= operand;
                                break;
                            }
                            case "*": {
                                result *= operand;
                                break;
                            }
                            case "/": {
                                result /= operand;
                                break;
                            }
                        }
                    }
                    if (matcher.group(3) != null) {
                        operator = matcher.group(3);
                    }
                }
                textField1.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        Application myWindow = new Application();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, BorderLayout.NORTH);
        textField1 = new JTextField();
        textField1.setEditable(false);
        panel2.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, BorderLayout.EAST);
        plusButton = new JButton();
        plusButton.setText("+");
        panel3.add(plusButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        minusButton = new JButton();
        minusButton.setText("-");
        panel3.add(minusButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        timesButton = new JButton();
        timesButton.setText("*");
        panel3.add(timesButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        equalsButton = new JButton();
        equalsButton.setText("=");
        panel3.add(equalsButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        divideButton = new JButton();
        divideButton.setText("/");
        panel3.add(divideButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sqrButton = new JButton();
        sqrButton.setText("sqr");
        panel3.add(sqrButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearButton = new JButton();
        clearButton.setText("C");
        panel3.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numPanel = new JPanel();
        numPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(numPanel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
