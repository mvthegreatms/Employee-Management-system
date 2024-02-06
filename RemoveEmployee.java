import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener  {
    Choice cEmpId;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(new Color(52,36,72));
        setLayout(null);
        JLabel heading =new JLabel("Remove");
        heading.setBounds(320,30,100,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,25));
        heading.setForeground(Color.white);
        add(heading);

        JLabel heading1 =new JLabel("Employee Details");
        heading1.setBounds(430,30,500,50);
        heading1.setFont(new Font("SAN_SERIF", Font.BOLD,25));
        heading1.setForeground(Color.black);
        add(heading1);

        JLabel labelempId =new JLabel("Employee Id:");
        labelempId.setBounds(100,100,100,30);
        labelempId.setForeground(Color.white);
        labelempId.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(labelempId);
        cEmpId=new Choice();
        cEmpId.setBounds(250,100,150,30);
        add(cEmpId);
        try{
          conn c=new conn();
          String query="Select * from employee";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               cEmpId.add(rs.getString("empId"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel labelname =new JLabel("Name:");
        labelname.setBounds(100,150,100,30);
        labelname.setForeground(Color.white);
        labelname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(labelname);
        JLabel lblname =new JLabel();
        lblname.setBounds(250,150,100,30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(lblname);


        JLabel labelphone =new JLabel("Phone:");
        labelphone.setBounds(100,200,100,30);
        labelphone.setForeground(Color.white);
        labelphone.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(labelphone);

        JLabel lblphone =new JLabel();
        lblphone.setBounds(250,200,100,30);
        lblphone.setForeground(Color.white);
        lblphone.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add( lblphone);

        JLabel labelemail =new JLabel("Email:");
        labelemail.setBounds(100,250,100,30);
        labelemail.setForeground(Color.white);
        labelemail.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add(labelemail);

        JLabel lblemail =new JLabel();
        lblemail.setBounds(250,250,200,30);
        lblemail.setForeground(Color.white);
        lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,15));
        add( lblemail);

        try{
            conn c=new conn();
            String query="Select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c=new conn();
                    String query="Select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("Name"));
                        lblphone.setText(rs.getString("Phone"));
                        lblemail.setText(rs.getString("Email"));
                    }
                }catch(Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(100, 300, 120, 30);

        add(delete);
        delete.setForeground(Color.white);
        delete.setBackground(Color.black);
        delete.setFont(new Font("serif", Font.PLAIN, 15));
        delete.addActionListener(this);

        back= new JButton("Back");
        back.setBounds(250, 300, 120, 30);

        add(back);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setFont(new Font("serif", Font.PLAIN, 15));
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(425, 0, 600, 400);
        add(image);

        setSize(1000,430);
        setLocation(300,150);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==delete){
        try{
            conn c=new conn();
            String query="delete from employee where empId='"+cEmpId.getSelectedItem()+"'";
            c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Employee information deleted");
          setVisible(false);
          new HomePage();
        } catch(Exception e){
            e.printStackTrace();
        }
     }
     else{
         setVisible(false);
         new HomePage();
     }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
