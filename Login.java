import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername,tfpassword;
    Login() {
        getContentPane().setBackground(new Color(52,36,72));
        setLayout(null);

        JLabel lblusrname = new JLabel("Username    :");
        lblusrname.setBounds(40, 20, 100, 30);
        lblusrname.setForeground(Color.white);
        add(lblusrname);
         tfusername = new JTextField();
        tfusername.setBounds(150, 25, 120, 28);
        add(tfusername);


        JLabel password = new JLabel("Password    :");
        password.setBounds(40, 60, 100, 30);
        password.setForeground(Color.white);
        add(password);
         tfpassword = new JTextField();
        tfpassword.setBounds(150, 65, 120, 30);
        add(tfpassword);

        JButton addBtn = new JButton("Login");
        addBtn.setBounds(150, 125, 120, 30);

        add(addBtn);
        addBtn.setForeground(Color.white);
        addBtn.setBackground(Color.black);
        addBtn.setFont(new Font("serif", Font.PLAIN, 15));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        image.setForeground(new Color(52,36,72));
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);


        addBtn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the login button click
//        setVisible(false);
//        new HomePage();
        try{
         String username=tfusername.getText();
         String password=tfpassword.getText();
         conn c=new conn();
         String query="select * from login where username='"+username+"' and password ='"+password+"'";

       ResultSet rs= c.s.executeQuery(query);
       // .next() method returns the boolean whether the rows exists or not
        if(rs.next()){
          setVisible(false);
          new HomePage();
        }
        else{

            JOptionPane.showMessageDialog(null,"Invalid username or password");
           // setVisible(false);
        }
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Login();
    }
}

