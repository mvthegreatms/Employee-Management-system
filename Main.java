import java.awt.*;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
abstract class Employee{
    private final String name;
    private final int id;
    public Employee(String name,int id){
        this.name=name;  //this keyword refers to the current object in a method or constructor.
        this.id=id;
    }
    public String getName(){
      return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return  "Employee [name="+name+",id="+id+" , salary="+calculateSalary()+"]";
    }
}

  class FullTimeEmployee extends Employee{
         private double monthlySalary;

         public FullTimeEmployee(String name,int id,double monthlySalary){
             super(name,id);
             this.monthlySalary=monthlySalary;
         }
  @Override
 public double  calculateSalary(){
   return   monthlySalary;

}
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;

    }
    @Override
    public double calculateSalary(){
     return hoursWorked*hourlyRate;
    }

}

class PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList=new ArrayList<>();

    }
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
          if(employee.getId()==id){
              employeeToRemove=employee;
              break;
          }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}




public class Main {

    public static void main(String[] args) {
        PayRollSystem payrollSystem=new PayRollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Vikas",1,70000);
        PartTimeEmployee emp2=new PartTimeEmployee("manoj",2,40,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employee");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployee();



    }
}