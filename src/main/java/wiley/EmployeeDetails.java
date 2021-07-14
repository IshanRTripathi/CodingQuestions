package main.java.wiley;

import java.util.*;

public class EmployeeDetails {
    static Scanner sc= new Scanner(System.in);
    static Set<String> availableDesignations= new HashSet<>(Arrays.asList("Programmer", "Analyst", "Manager","programmer", "analyst", "manager"));

    public static void main(String[] args) {

        System.out.println("Enter\n1.Add employee\n2.Raise CTC\n3.Display\n4.Exit\n5.Remove employee");
        String input= sc.nextLine();
        List<Employee> employees= new ArrayList<>();

        Employee e= new Employee();
        while(!input.equals("4")){
            switch (input) {
                case "1" -> {
                    e.setName(getName());
                    e.setDesignation(getDesignation());
                    e.setSalary(getSalary(e.getDesignation()));
                    employees.add(e);
                    e = new Employee();
                }
                case "2" -> {
                    System.out.println("Enter % hike:");
                    String hikePercentage= validateSalaryAndHike();
                    double hike = Double.parseDouble(hikePercentage);
                    raiseCTC(employees, hike);
                }
                case "3" -> System.out.println(employees);
                case "5" -> {
                    System.out.println("Enter name of employee you want to remove:");
                    String employeeToRemove= sc.nextLine();
                    removeEmployee(employees, employeeToRemove);
                }
                default -> System.out.println("Invalid input!");
            }
            System.out.println("Enter\n1.Add employee\n2.Raise CTC\n3.Display\n4.Exit\n5.Remove employee");
            input= sc.nextLine();
        }
        System.out.println("Employee data: "+ employees);
    }

    private static String validateSalaryAndHike() {
        String hikePercentage= sc.nextLine();
        for(char c: hikePercentage.toCharArray()){
            if(c<'0' || c>'9')
            {
                if(c=='.')
                    continue;
                System.out.println("Invalid input, provide number!");
                return validateSalaryAndHike();
            }
        }
        return hikePercentage;
    }

    private static void removeEmployee(List<Employee> employees, String employeeToRemove) {
        int i=0;
        for(i=0; i<employees.size(); i++){
            if(employees.get(i).getName().equalsIgnoreCase(employeeToRemove))
                break;
        }
        if(i==employees.size()) {
            System.out.println("No such employee!");
            return;
        }
        employees.remove(i);
    }

    private static void raiseCTC(List<Employee> employees, double hike) {
        for(Employee e: employees){
            e.setSalary((int) (e.getSalary()+(e.getSalary()*hike/100)));
        }
    }

    private static int getSalary(String designation) {
//        System.out.println("Enter salary:");
        int salary =0;
        switch (designation){
            case "manager":
            case "Manager":
                salary= 250000;
                break;
            case "Analyst":
            case "analyst":
                salary= 150000;
                break;
            case "Programmer":
            case "programmer":
                salary= 100000;
            default:
                System.out.println("Wrong input");
        }
//        String salary= validateSalaryAndHike();
        System.out.println("Salary for this designation is: "+salary);
        return salary;
    }

    private static String getDesignation() {
        System.out.println("Enter designation:");
        String designation= sc.nextLine();
        if(!availableDesignations.contains(designation)){
            System.out.println("Invalid entry, try again");
            return getDesignation();
        }
        return designation;
    }

    private static String getName() {
        System.out.println("Enter name:");
        String name= sc.nextLine();
        int count=0;
        for(char c: name.toCharArray()){
            if(c==' '){
                count++;
            }
            if(count>2){
                System.out.println("Invalid name, name can have at most 2 spaces");
                return getName();
            }
        }
        return name;
    }

    static class Employee{
        String name, designation;
        int salary;

        public Employee() {
        }

        public Employee(String name, String designation, int salary) {
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString(){
            return this.name+", "+this.designation+", "+this.salary+"\n";
        }
    }
}
