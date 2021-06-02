package counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class counterapp extends JFrame {
    private int value;
    public counterapp(int initial) {
        setBounds(500,400,300,120);
        setTitle("Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 32);

        JTextField counterValue = new JTextField();
        counterValue.setFont(font);
        counterValue.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValue, BorderLayout.CENTER);

        value = initial;
        counterValue.setText(String.valueOf(value));





        JButton decreaseButton = new JButton("<");
        JButton incrementButton = new JButton(">");
        decreaseButton.setFont(font);
        incrementButton.setFont(font);
        add(decreaseButton, BorderLayout.WEST);
        add(incrementButton, BorderLayout.EAST);

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValue.getText();
                int a = Integer.parseInt(counterValue.getText());
                if (a != value) {
                    a--;
                    counterValue.setText(String.valueOf(a));
                } else {
                    value--;
                    counterValue.setText(String.valueOf(value));
                }
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValue.getText();
                int a = Integer.parseInt(counterValue.getText());
                if (a != value) {
                    a++;
                    counterValue.setText(String.valueOf(a));
                } else {
                    value++;
                    counterValue.setText(String.valueOf(value));
                }
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {

        new counterapp(0);
    }
}
