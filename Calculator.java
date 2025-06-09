import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;
    private boolean scientificMode = false;

    public Calculator() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        mainPanel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Boutons de base
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "√",
            "x²", "x^y", "C", "Mode"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
            button.addActionListener(new ButtonClickListener());
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (command.equals("Mode")) {
                scientificMode = !scientificMode;
                display.setText("Mode " + (scientificMode ? "Scientifique" : "Standard"));
                start = true;
                return;
            }
            if (start) {
                display.setText("");
                start = false;
            }
            if (command.equals("C")) {
                result = 0;
                display.setText("0");
                start = true;
                lastCommand = "=";
            } else if (command.equals("=")) {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = "=";
                start = true;
            } else if (command.equals("+") || command.equals("-") || 
                      command.equals("*") || command.equals("/")) {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            } else if (command.equals("sin") || command.equals("cos") || 
                      command.equals("tan") || command.equals("√") || 
                      command.equals("x²") || command.equals("x^y")) {
                if (scientificMode) {
                    handleScientificOperation(command);
                } else {
                    display.setText("Mode scientifique requis");
                    start = true;
                }
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    private void calculate(double x) {
        switch (lastCommand) {
            case "+": result += x; break;
            case "-": result -= x; break;
            case "*": result *= x; break;
            case "/": result /= x; break;
            case "=": result = x; break;
        }
        display.setText("" + result);
    }

    private void handleScientificOperation(String operation) {
        String displayText = display.getText().trim();
        if (displayText.isEmpty() || displayText.equals("0")) {
            display.setText("Erreur: Entrée vide");
            start = true;
            return;
        }

        double x = Double.parseDouble(displayText);
        switch (operation) {
            case "sin":
                result = Math.sin(Math.toRadians(x));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(x));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(x));
                break;
            case "√":
                if (x < 0) {
                    display.setText("Erreur: Nombre négatif");
                    start = true;
                    return;
                }
                result = Math.sqrt(x);
                break;
            case "x²":
                result = x * x;
                break;
            case "x^y":
                result = x;
                lastCommand = "^";
                start = true;
                return;
        }
        display.setText("" + result);
        start = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
} 