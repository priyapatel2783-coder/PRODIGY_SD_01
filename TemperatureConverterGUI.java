import javax.swing.*;
import java.awt.event.*;

class TemperatureConverterGUI extends JFrame implements ActionListener {

    JTextField inputField, resultField;
    JComboBox<String> options;
    JButton convertBtn, clearBtn;

    // Constructor (GUI setup)
    TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label
        JLabel title = new JLabel("Temperature Converter");
        title.setBounds(120, 10, 200, 25);
        add(title);

        // Input field
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(30, 50, 150, 25);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(180, 50, 150, 25);
        add(inputField);

        // Dropdown options
        String[] choices = {
            "Celsius → Fahrenheit",
            "Celsius → Kelvin",
            "Fahrenheit → Celsius",
            "Kelvin → Celsius"
        };

        options = new JComboBox<>(choices);
        options.setBounds(100, 90, 200, 25);
        add(options);

        // Buttons
        convertBtn = new JButton("Convert");
        convertBtn.setBounds(70, 130, 100, 30);
        add(convertBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(200, 130, 100, 30);
        add(clearBtn);

        // Result field
        resultField = new JTextField();
        resultField.setBounds(100, 170, 200, 25);
        resultField.setEditable(false);
        add(resultField);

        // Action listeners
        convertBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    // Conversion methods (same as your code)
    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn) {
            try {
                double temp = Double.parseDouble(inputField.getText());
                int choice = options.getSelectedIndex();
                double result = 0;

                switch (choice) {
                    case 0:
                        result = celsiusToFahrenheit(temp);
                        resultField.setText(result + " °F");
                        break;
                    case 1:
                        result = celsiusToKelvin(temp);
                        resultField.setText(result + " K");
                        break;
                    case 2:
                        result = fahrenheitToCelsius(temp);
                        resultField.setText(result + " °C");
                        break;
                    case 3:
                        result = kelvinToCelsius(temp);
                        resultField.setText(result + " °C");
                        break;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid number!");
            }
        }

        if (e.getSource() == clearBtn) {
            inputField.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        TemperatureConverterGUI app = new TemperatureConverterGUI();
        app.setVisible(true);
    }
}