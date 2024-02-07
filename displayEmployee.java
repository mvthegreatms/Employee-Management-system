import net.proteanit.sql.DbUtils;

import javax.naming.ContextNotEmptyException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class displayEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,Back;
    displayEmployee(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading=new JLabel("Search by Employee Id");
        heading.setBounds(350,10,400,35);
        heading.setFont(new Font("sens-serif",Font.BOLD,30));
        add(heading);


        JLabel searchlbl =new JLabel("Search🔍: ");
        searchlbl.setBounds(20,70,100,20);
        searchlbl.setFont(new Font("sens-serif",Font.BOLD,20));
        add(searchlbl);

        cemployeeId=new Choice();
        cemployeeId.setBounds(150,70,150,20);
        cemployeeId.setFont(new Font("sens-serif",Font.BOLD,15));
        add(cemployeeId);

        table= new JTable();
        try{
            conn c=new conn();
            ResultSet res=c.s.executeQuery("SELECT * FROM employee ");
            while(res.next()){
                cemployeeId.add(res.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();  //trace at which line the exception occurs

        }
        try{
          conn c=new conn();
          ResultSet res=c.s.executeQuery("SELECT * FROM employee ");
          table.setModel(DbUtils.resultSetToTableModel(res));

         // table.setBackground(new Color(52,36,72));
         // table.setForeground(Color.white);


          while(res.next()){
             cemployeeId.add(res.getString("empId"));

          }



        }catch(Exception e){
           e.printStackTrace();  //trace at which line the exception occurs

        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,200,1200,1000);

        add(jsp);

       search=new JButton("Search");
       search.setBounds(20,150,80,20);
       search.setBackground(Color.black);
       search.setSize(100,25);
       search.setForeground(Color.white);
       search.addActionListener(this);
       add(search);

        print=new JButton("Print");
        print.setBounds(200,150,80,20);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.setSize(100,25);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(380,150,80,20);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setSize(100,25);
        update.addActionListener(this);
        add(update);

        Back=new JButton("Back");
        Back.setBounds(560,150,80,20);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setSize(100,25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/display1.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1215, 200);
        add(image);



        setSize(1215,700);
        setLocation(150,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
           String query="select * from employee where empId='"+cemployeeId.getSelectedItem()+"'";
           try{
              conn c=new conn();
              ResultSet rs=c.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
            e.printStackTrace();
           }
        }else if(ae.getSource()==print){
          try{
             table.print();
          }catch(Exception e){
              e.printStackTrace();
          }
        }else if(ae.getSource()==update){
            setVisible(false);
          new UpdateEmployee(cemployeeId.getSelectedItem());
        }else{
            setVisible(false);
            new HomePage();
        }
    }
    public static void main(String[] args) {
        new displayEmployee();
    }
}
