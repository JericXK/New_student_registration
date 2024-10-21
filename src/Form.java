import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton SAVEButton;
    private JPanel MainForm;

    public Form(){
        setTitle("Create Account");
        setContentPane(MainForm);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);


        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationUser();
            }
        });

        setVisible(true);
    }

    private void registrationUser(){
        String first_name = textField1.getText();
        String middle_name = textField2.getText();
        String last_name = textField3.getText();
        String address = textField4.getText();
        String phone_number = textField5.getText();
        String email = textField6.getText();
    }

    public static void main(String[] args){
        new Form();
    }
}


