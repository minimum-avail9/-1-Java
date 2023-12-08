import Javax.swing.*;
import Java.awt.*;
import  Java.awt.event.ActionEvent;
import  Java.awt.event.ActionListener;
import  Java.math.BigDecimal;
import  Java.math.RoundinMode


public class calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functions;
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, crlButton;
    JPannel panel = new JButton();
    Front myFont = new Font("Arial", Font.BOLD, 30);




    BigDecimal num1 = BigDecimal.valueOf(0), num2 = BigDecimal.valueOf(0), result = BigDecimal.valueOf(0)
            char operator;

    public calculator() {
        frame = new JFame("Мій калькулятор");
        frame.setDefaultCloseOpertation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);



        textField = new JTextField();
        textField.setBounds(50,25, 300, 50);

    }


}
