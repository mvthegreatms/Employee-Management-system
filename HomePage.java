import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
    JButton addBtn,deleteBtn,displayBtn,updateBtn;
    HomePage() {
        getContentPane().setBackground(new Color(52,36,72)); //getContentpane--to select whole frame and then background color white
        setLayout(null);



        JLabel heading = new JLabel("MANAGE EMPLOYEE");//the object of Jlabel class is a component for placing text in a container.
        heading.setBounds(350, 0, 1200, 60); //to set heading location
        heading.setFont(new Font("TELEGRAF", Font.BOLD, 40));
        heading.setForeground(Color.black); //font foreground color
        add(heading);  //to add heading in frame

        JLabel subheading = new JLabel("choose category");//the object of Jlabel class is a component for placing text in a container.
        subheading.setBounds(450, 380, 1200, 60); //to set heading location
        subheading.setFont(new Font("TELEGRAF", Font.BOLD, 15));
        subheading.setForeground(Color.black); //font foreground color
        add(subheading);

        //icons
        ImageIcon add1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-user.png"));
        Image add2 = add1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon add3 = new ImageIcon(add2);
        JLabel image1 = new JLabel(add3);
        image1.setBounds(100, 190, 110, 110);
        add(image1);

        ImageIcon delete1 = new ImageIcon(ClassLoader.getSystemResource("icons/removed.png"));
        Image delete2 = delete1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon delete3 = new ImageIcon(delete2);
        JLabel image2 = new JLabel(delete3);
        image2.setBounds(330, 190, 110, 110); // Corrected to image2
        add(image2);

        ImageIcon view1 = new ImageIcon(ClassLoader.getSystemResource("icons/monitor-screen.png"));
        Image view2 = view1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon view3 = new ImageIcon(view2);
        JLabel image3 = new JLabel(view3);
        image3.setBounds(580, 190, 110, 110); // Corrected to image3
        add(image3);

        ImageIcon update1 = new ImageIcon(ClassLoader.getSystemResource("icons/reload.png"));
        Image update2 = update1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon update3 = new ImageIcon(update2);
        JLabel image4 = new JLabel(update3);
        image4.setBounds(810, 190, 110, 110); // Corrected to image4
        add(image4);

        addBtn = new JButton("Add");
        addBtn.setBounds(110, 300, 90, 25);
        add(addBtn); //to add button with respect to image
        addBtn.setBackground(Color.black);
        addBtn.setForeground(Color.white);
        addBtn.setFont(new Font("serif", Font.PLAIN, 15));
        addBtn.addActionListener(this);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(350, 300, 90, 25);
        add(deleteBtn); //to add button with respect to image
        deleteBtn.setBackground(Color.black);
        deleteBtn.setForeground(Color.white);
        deleteBtn.setFont(new Font("serif", Font.PLAIN, 15));
        deleteBtn.addActionListener(this);

        displayBtn = new JButton("View");
        displayBtn.setBounds(600, 300, 90, 25);
        add(displayBtn); //to add button with respect to image
        displayBtn.setBackground(Color.black);
        displayBtn.setForeground(Color.white);
        displayBtn.setFont(new Font("serif", Font.PLAIN, 15));
        displayBtn.addActionListener(this);

        updateBtn = new JButton("update");
        updateBtn.setBounds(820, 300, 90, 25);
        add(updateBtn); //to add button with respect to image
        updateBtn.setBackground(Color.black);
        updateBtn.setForeground(Color.white);
        updateBtn.setFont(new Font("serif", Font.PLAIN, 15));
        updateBtn.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/manage.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        setSize(1120, 630);
        setVisible(true);
        setLocation(200, 100);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            setVisible(false);
          new AddEmployee();
        } else if (ae.getSource() == updateBtn) {
            setVisible(false);
             new displayEmployee();

        } else if (ae.getSource() == displayBtn) {
            setVisible(false);
            new displayEmployee();
        }
        else{
          setVisible(false);
          new RemoveEmployee();
        }
    }
    public static void main(String[] args) {
        new HomePage();
    }
}

