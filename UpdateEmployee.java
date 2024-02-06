import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;



public class UpdateEmployee extends JFrame implements ActionListener {

    JButton addBtn,backBtn;

    JComboBox chosepost,jc;
    JLabel lblId;
    JDateChooser dcdob;
    JTextField tfname,tffname,tfaddress,tfphone,tfAadhar,tfsalary,tfemail,tfdesignation,tftypeofemp;
    String empId;
    UpdateEmployee(String empId){
        this.empId=empId;
        getContentPane().setBackground(new Color(52,36,72));
       // getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading =new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,30));
       // heading.setForeground(Color.white);
        add(heading);

        JLabel labelname= new JLabel("Name :");
        labelname.setBounds(50,150,150,30);
        labelname.setFont( new Font("serif",Font.PLAIN,20));
        //labelname.setForeground(Color.white);
        add(labelname);

       JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        //lblname.setForeground(Color.white);
        lblname.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(lblname);

        JLabel labelfname= new JLabel("Father Name :");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont( new Font("serif",Font.PLAIN,20));
        //labelfname.setForeground(Color.white);
        add(labelfname);

        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob= new JLabel("Date of Birth :");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont( new Font("serif",Font.PLAIN,20));
        //labeldob.setForeground(Color.white);
        add(labeldob);

        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        //lbldob.setForeground(Color.white);
        lbldob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(lbldob);

        JLabel choseType= new JLabel("Type of Employee :");
        choseType.setBounds(400,200,170,30);
        choseType.setFont( new Font("serif",Font.PLAIN,20));
        //choseType.setForeground(Color.white);
        add(choseType);

        tftypeofemp=new JTextField();
        tftypeofemp.setBounds(600,200,150,30);
        add(tftypeofemp);


//        jc=new JComboBox();
//        jc.addItem("Chose");
//        jc.addItem("Full type Employee");
//        jc.addItem("Part type Employee");
//        jc.setBounds(600,200,150,30);
//        add(jc);

        JLabel salary= new JLabel("Salary :");
        salary.setBounds(50,250,150,30);
        salary.setFont( new Font("serif",Font.PLAIN,20));
        //salary.setForeground(Color.white);
        add(salary);

        tfsalary=new JTextField();
        tfsalary.setBounds(200,250,150,30);
        add(tfsalary);



        JLabel address= new JLabel("Address :");
        address.setBounds(400,250,150,30);
        address.setFont( new Font("serif",Font.PLAIN,20));
        //address.setForeground(Color.white);
        add(address);

        tfaddress=new JTextField();
        tfaddress.setBounds(600,250,150,30);
        add(tfaddress);


        JLabel phone= new JLabel("Phone :");
        phone.setBounds(50,300,150,30);
        phone.setFont( new Font("serif",Font.PLAIN,20));
        //phone.setForeground(Color.white);
        add(phone);

        tfphone=new JTextField();
        tfphone.setBounds(200,300,150,30);
        add(tfphone);

        JLabel email= new JLabel("Email :");
        email.setBounds(400,300,150,30);
        email.setFont( new Font("serif",Font.PLAIN,20));
        //email.setForeground(Color.white);
        add(email);

        tfemail=new JTextField();
        tfemail.setBounds(600,300,150,30);
        add(tfemail);

        JLabel designation= new JLabel("Designation :");
        designation.setBounds(50,350,150,30);
        designation.setFont( new Font("serif",Font.PLAIN,20));
        //designation.setForeground(Color.white);
        add(designation);

        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

//        String posts[]= {"SDE","Data Analyst","Full-Stack Developer","Frontend Developer","Data Scientists","Java Developer"};
//        chosepost=new JComboBox(posts);
//        chosepost.setBackground(Color.white);
//        chosepost.setBounds(200,350,150,30);
//        add(chosepost);

        JLabel Aadhar= new JLabel("Aadhar Number :");
        Aadhar.setBounds(400,350,150,30);
        Aadhar.setFont( new Font("serif",Font.PLAIN,20));
        //Aadhar.setForeground(Color.white);
        add( Aadhar);

        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        //lblaadhar.setForeground(Color.white);
        lblaadhar.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(lblaadhar);

        JLabel EmployeeId= new JLabel("Employee Id :");
        EmployeeId.setBounds(50,400,150,30);
        EmployeeId.setFont( new Font("serif",Font.PLAIN,20));
        //EmployeeId.setForeground(Color.white);
        add( EmployeeId);

        lblId= new JLabel();
        lblId.setBounds(200,400,150,30);
        lblId.setFont( new Font("serif",Font.PLAIN,20));
        //lblId.setForeground(Color.white);
        add(lblId);

        try{
            conn c=new conn();
            String query="select * from employee where empId='"+empId+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("Fathername"));
                lblaadhar.setText(rs.getString("Aadhar"));
                lbldob.setText(rs.getString("DOB"));
                tftypeofemp.setText(rs.getString("TypeOfEmp"));
                tfsalary.setText(rs.getString("Salary"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                lblId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("Designation"));



            }
        }catch(Exception e){
            e.printStackTrace();
        }


        addBtn = new JButton("Update Details");
        addBtn.setBounds(250, 500, 150, 30);

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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update1.jpg"));
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

            String fname=tffname.getText();

            String TypeofEmp=tftypeofemp.getText();
            String salary=tfsalary.getText();
            String address= tfaddress.getText();
            String phone=tfphone.getText();
            String email= tfemail.getText();
            String designation=tfdesignation.getText();

            try{
                conn c=new conn();
                String query ="update employee set Fathername ='"+fname+"',TypeofEmp='"+TypeofEmp+"',Salary='"+salary+"',Address='"+address+"',Phone='"+phone+"',Email='"+email+"',Designation='"+designation+"' where EmpId='"+empId+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
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
        new UpdateEmployee("");
    }
}
