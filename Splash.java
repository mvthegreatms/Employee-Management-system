import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Splash extends JFrame implements ActionListener {


    Splash() {


        getContentPane().setBackground(new Color(52, 36, 72)); //getContentpane--to select whole frame and then background color white
        setLayout(null);


        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/homepage5.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 20, 1050, 550);
        add(image);


        //heading
        JLabel heading = new JLabel("Employee Management System");//the object of Jlabel class is a component for placing text in a container.
        heading.setBounds(200, 30, 1200, 60); //to set heading location
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.white); //font foreground color
        image.add(heading);  //to add heading in frame

        JLabel tag = new JLabel("MANAGE YOUR EMPLOYEE");//the object of Jlabel class is a component for placing text in a container.
        tag.setBounds(50, 230, 1200, 60); //to set heading location
        tag.setFont(new Font("telegraf", Font.PLAIN, 30));
        tag.setForeground(Color.white); //font foreground color
        image.add(tag);

        JLabel tagline1 = new JLabel("Efficiency, Empowerment, Excellence: ");//the object of Jlabel class is a component for placing text in a container.
        tagline1.setBounds(50, 270, 1500, 60); //to set heading location
        tagline1.setFont(new Font("telegraf", Font.PLAIN, 15));
        tagline1.setForeground(Color.white); //font foreground color
        image.add(tagline1);

        JLabel tagline2 = new JLabel("Streamlining Workforce Management Together");//the object of Jlabel class is a component for placing text in a container.
        tagline2.setBounds(50, 300, 1500, 60); //to set heading location
        tagline2.setFont(new Font("telegraf", Font.PLAIN, 15));
        tagline2.setForeground(Color.white); //font foreground color
        image.add(tagline2);

        //button
        JButton addBtn = new JButton("Click here to Continue");
        addBtn.setBounds(730, 370, 230, 40);
        image.add(addBtn); //to add button with respect to image
        addBtn.setForeground(Color.white);
        addBtn.setBackground(Color.black);
        addBtn.setFont(new Font("serif", Font.PLAIN, 15));
        addBtn.addActionListener(this); // on clicking button this will tell that some function has to be performed which is in the ActionPerformed method


        setSize(1170, 650); //to set size of frame
        setLocation(200, 50); //to set location of frame where to display
        setVisible(true); // to make frame visible
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }



        }
    @Override
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {

        new Splash();
    }
}

