import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup gender = new ButtonGroup();
        gender.add(maleRadioButton);
        gender.add(femaleRadioButton);

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


        if (first_name.isEmpty() || middle_name.isEmpty() || last_name.isEmpty() || address.isEmpty() || phone_number.isEmpty() || email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter all fields","try again", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new_student = addUserToDatabase(first_name, middle_name, last_name, address, phone_number, email);
        if(new_student != null){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Failed to register new user", "Try again", JOptionPane.ERROR_MESSAGE);
        }

    }

    private User new_student;
    private User addUserToDatabase(String first_name, String middle_name, String last_name, String address, String phone_number, String email){
        User user = null;
        final String DB_URL = "";
        final String USERNAME = "JericXK";
        final String PASSWORD = "Access";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);

            Statement stmnt = conn.createStatement();
            String sql = "INSERT INTO new_student(first_name, middle_name, last_name, address, phone_number, email, gender) " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

        }
        return new_student;
    }

    public static void main(String[] args){
        Form register = new Form();
        User new_student = register.new_student;
        if (new_student != null){
            System.out.println("Successful Registration");
        }
    }
}


