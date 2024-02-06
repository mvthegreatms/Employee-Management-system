import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class AddEmployee extends JFrame implements ActionListener {
    Random ran= new Random();
    int number=ran.nextInt(999999);
    JButton addBtn,backBtn;
    JDateChooser dcdob;
    JComboBox chosepost,jc;
    JLabel Id;

    JTextField tfname,tffname,tfaddress,tfphone,tfAadhar,tfsalary,tfemail;
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading =new JLabel("👨‍Add Employee Detail👨");
        heading.setBounds(250,30,600,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,40));
        heading.setForeground(Color.black);
        add(heading);

        JLabel labelname= new JLabel("Name :");
        labelname.setBounds(50,150,150,30);
        labelname.setFont( new Font("serif",Font.PLAIN,20));
        labelname.setForeground(Color.black);
        add(labelname);

         tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel labelfname= new JLabel("Father Name :");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont( new Font("serif",Font.PLAIN,20));
        labelfname.setForeground(Color.black);
        add(labelfname);

         tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob= new JLabel("Date of Birth :");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont( new Font("serif",Font.PLAIN,20));
        labeldob.setForeground(Color.black);
        add(labeldob);

        dcdob=new JDateChooser();
       dcdob.setBounds(200,200,150,30);
       add(dcdob);

        JLabel choseType= new JLabel("Type of Employee :");
        choseType.setBounds(400,200,170,30);
        choseType.setFont( new Font("serif",Font.PLAIN,20));
        choseType.setForeground(Color.black);
        add(choseType);

       jc=new JComboBox();
       jc.addItem("Chose");
       jc.addItem("Full type Employee");
        jc.addItem("Part type Employee");
        jc.setBounds(600,200,150,30);
        add(jc);

        JLabel salary= new JLabel("Salary :");
        salary.setBounds(50,250,150,30);
        salary.setFont( new Font("serif",Font.PLAIN,20));
        salary.setForeground(Color.black);
        add(salary);

         tfsalary=new JTextField();
        tfsalary.setBounds(200,250,150,30);
        add(tfsalary);



        JLabel address= new JLabel("Address :");
        address.setBounds(400,250,150,30);
        address.setFont( new Font("serif",Font.PLAIN,20));
        address.setForeground(Color.black);
        add(address);

         tfaddress=new JTextField();
        tfaddress.setBounds(600,250,150,30);
        add(tfaddress);


        JLabel phone= new JLabel("Phone :");
        phone.setBounds(50,300,150,30);
        phone.setFont( new Font("serif",Font.PLAIN,20));
        phone.setForeground(Color.black);
        add(phone);

         tfphone=new JTextField();
        tfphone.setBounds(200,300,150,30);
        add(tfphone);

        JLabel email= new JLabel("Email :");
        email.setBounds(400,300,150,30);
        email.setFont( new Font("serif",Font.PLAIN,20));
        email.setForeground(Color.black);
        add(email);

         tfemail=new JTextField();
        tfemail.setBounds(600,300,150,30);
        add(tfemail);

        JLabel designation= new JLabel("Designation :");
        designation.setBounds(50,350,150,30);
        designation.setFont( new Font("serif",Font.PLAIN,20));
        designation.setForeground(Color.BLACK);
        add(designation);


        String posts[]= {"SDE","Data Analyst","Full-Stack Developer","Frontend Developer","Data Scientists","Java Developer"};
         chosepost=new JComboBox(posts);
       chosepost.setBackground(Color.WHITE);
        chosepost.setBounds(200,350,150,30);
        add(chosepost);

        JLabel Aadhar= new JLabel("Aadhar Number :");
        Aadhar.setBounds(400,350,150,30);
        Aadhar.setFont( new Font("serif",Font.PLAIN,20));
        Aadhar.setForeground(Color.black);
        add( Aadhar);

         tfAadhar=new JTextField();
        tfAadhar.setBounds(600,350,150,30);
        add(tfAadhar);

        JLabel EmployeeId= new JLabel("Employee Id :");
        EmployeeId.setBounds(50,400,150,30);
        EmployeeId.setFont( new Font("serif",Font.PLAIN,20));
        EmployeeId.setForeground(Color.BLACK);
        add( EmployeeId);

         Id= new JLabel(""+number);
        Id.setBounds(200,400,150,30);
        Id.setFont( new Font("serif",Font.PLAIN,20));
        Id.setForeground(Color.BLACK);
        add(Id);

        addBtn = new JButton("Add Details");
        addBtn.setBounds(250, 500, 120, 30);

        add(addBtn);
        addBtn.setForeground(Color.white);
        addBtn.setBackground(Color.black);
        addBtn.setFont(new Font("serif", Font.PLAIN, 15));
        addBtn.addActionListener(this);

         backBtn = new JButton("Back");
        backBtn.setBounds(450, 500, 120, 30);
        add(backBtn);
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.black);
        backBtn.setFont(new Font("serif", Font.PLAIN, 15));
        backBtn.addActionListener(this);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 700);
        add(image);


        setSize(1200,700);
        setLocation(300,50);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addBtn){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String TypeofEmp=(String) jc.getSelectedItem();
            String salary=tfsalary.getText();
            String address= tfaddress.getText();
            String phone=tfphone.getText();
            String email= tfemail.getText();
            String designation= (String)chosepost.getSelectedItem();
            String aadhar=tfAadhar.getText();
            String empId=Id.getText();
            try{
            conn c=new conn();
            String query ="Insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+TypeofEmp+"','"+address+"','"+phone+"','"+email+"','"+designation+"','"+aadhar+"','"+empId+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details added successfully");
            setVisible(false);
            new HomePage();
            }catch(Exception e){
             e.printStackTrace();
            }
        }else{
            setVisible(false);
            new HomePage();

        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
