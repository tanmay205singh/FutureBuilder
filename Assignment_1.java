package ASSIGNMENT1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("welcome to future builder");
        System.out.println("press 1 to enter application");
        System.out.println("press 2 to exit the application");
        int proceed=sc.nextInt();
        if(proceed==1){
            System.out.println("choose th mode you want to enter");
            /*choose 1 for student mode
        choose 2 for comapny mode
        choose 3 for placement cell mode;
        choose 4 to return to main application
         */
            proceed=sc.nextInt();
            System.out.println("opening company reistration");
            ArrayList<Company>a=new ArrayList<>();
            for(int i=0;i<3;i++){
                String name=sc.nextLine();
                String role=sc.nextLine();
                int Package=sc.nextInt();
                double eligibiltycriteria=sc.nextDouble();
                String datetime=sc.nextLine();
                Company c1=new Company(name,role,Package,eligibiltycriteria,datetime);
                a.add(c1);

            }
            ArrayList<Student>b=new ArrayList<>();
            for(int i=0;i<3;i++){
                String name=sc.nextLine();
                int rollno=sc.nextInt();
                double cgpa=sc.nextDouble();
                String branch=sc.nextLine();
                Student s1=new Student(name,rollno,cgpa,branch,a);
                b.add(s1);

            }
            Placementcell p1=new Placementcell(b,a);
        }

    }
}
class Student{
    private String name;
    private int rollno;
    private double cgpa;
    private String branch;
    private String currentstat;
    private int Package;
    private ArrayList<Company> a;
    private Placementcell place;
    private String companyoffer;
    public Student(String name,int rollno,double cgpa,String branch,ArrayList<Company> companies){
        this.name=name;
        this.rollno=rollno;
        this.branch=branch;
        this.cgpa=cgpa;
        this.currentstat="not applied";
        this.Package=0;
        this.a=companies;
        this.companyoffer=null;
    }
    public void setstatus(String currentstat){
        this.currentstat=currentstat;
    }
    public String getstatus(){
        return currentstat;
    }
    public String getname(){
        return name;
    }
    public double getcgpa(){
        return cgpa;
    }
    public void getavailablecomapny(){
        if(this.currentstat=="blocked"){
            System.out.println("you are out from the campus");
        }
        else if (this.currentstat=="not applied"){
            for(int i=0;i<a.size();i++){
                if (this.cgpa>=a.get(i).geteligibilecriteria()){
                    System.out.println(a.get(i).getName());
                }
            }

        }
        else if(this.currentstat=="applied"){
            for(int i=0;i<a.size();i++){
                if(a.get(i).getPackage()>3*this.Package){
                    System.out.println(a.get(i).getName());
                }
            }

        }
    }
    public void registerforcompany(){
        if(this.currentstat=="blocked"){
            System.out.println("you can't register try next year");
        }

        else if(this.currentstat=="not applied"){
            for(int i=0;i<a.size();i++){
                if(a.get(i).geteligibilecriteria()<=this.cgpa){
                    this.companyoffer=a.get(i).getName();
                    this.currentstat="applied";
                }
            }
        }
        else if(this.currentstat=="applied"){
            for(int i=0;i<a.size();i++){
                if(a.get(i).getPackage()<=this.Package){
                    this.companyoffer=a.get(i).getName();
                    this.currentstat="applied";

                }
            }
        }
    }
    public int getRollno(){
        return rollno;
    }
    public int getPackage(){
        return Package;
    }
    public String getCompanyoffer(){
        return this.companyoffer;
    }
    public void setCgpa(double cgpa){
        this.cgpa=cgpa;
    }

}
class Company{
    private String name;
    private String role;
    private int Package;
    private ArrayList<Student>b;
    private double eligcriteria;
    private String Datetime;
    public Company(String name,String role,int Package,double eligcriteria,String Datetime){
        this.name=name;
        this.role=role;
        this.Package=Package;
        this.eligcriteria=eligcriteria;
        this.Datetime=Datetime;
    }
    public double geteligibilecriteria(){
        return eligcriteria;
    }
    public void updaterole(String role){
        this.role=role;
    }
    public void updatePackage(int Package){
        this.Package=Package;
    }
    public void updateeligcriteria(double eligcriteria){
        this.eligcriteria=eligcriteria;
    }
    public int getPackage(){
        return Package;
    }
    public String getName(){
        return this.name;
    }
    public void getselectstudents(ArrayList<Student> d){
        this.b=d;
        for(int i=0;i<b.size();i++){
            if(this.name==b.get(i).getCompanyoffer()){
                System.out.println(b.get(i).getname());
                System.out.println(b.get(i).getname()+"iiitd.ac.in");
                System.out.println(b.get(i).getRollno());
            }
        }
    }



}
class Placementcell{
    private ArrayList<Student> x;
    private ArrayList<Company> y;
    public Placementcell(ArrayList<Student> Students,ArrayList<Company> Companies){
        this.x=Students;
        this.y=Companies;
    }
    public void Opencompanyregistration(){
        System.out.println("the institute is open for company  registration");
        System.out.println("the start date is "+"23rd september 2022,18:06 PM");
        System.out.println("the end date for registration is "+"24th september 2022,18:04PM");
    }
    public void Openstudentregistration(){
        System.out.println("the institute is open for student-registration for the placement drive ");
        System.out.println("the start date is "+"25th september 2022,18:08 PM");
        System.out.println("the end date is "+"26th septmeber 2022,18:010PM");
    }
    public int getNumberofstudentregis(){
        return x.size();
    }
    public int getnumberofcompanyregis(){
        return y.size();
    }
    public void numofplacedstudents(){
        for(int i=0;i<x.size();i++){
            if(x.get(i).getstatus()=="applied"){
                System.out.println(x.get(i).getname());
                System.out.println(x.get(i).getRollno());
                System.out.println(x.get(i).getCompanyoffer());
            }
        }
    }
    public void getstudentdetails(String name,int rollno){
        for(int i=0;i<x.size();i++){
            if(x.get(i).getname()==name && x.get(i).getRollno()==rollno){
                System.out.println(x.get(i).getstatus());
                System.out.println(x.get(i).getCompanyoffer());
            }
        }

    }
    public void getcomdetails(String name){
        for(int i=0;i<y.size();i++){
            if(y.get(i).getName()==name){
                System.out.println(y.get(i).getName());
                System.out.println(y.get(i).getPackage());
                System.out.println(y.get(i).geteligibilecriteria());
                for(int j=0;j<x.size();j++){
                    if(x.get(j).getCompanyoffer()==name){
                        System.out.println(x.get(i).getname());
                        System.out.println(x.get(i).getRollno());
                    }
                }

            }
        }
    }
    public double getavgPackage(){
        int j=y.size();
        double d=0;
        for(int i=0;i<y.size();i++){
            d=d+y.get(i).getPackage();
        }
        return d/j;
    }
    public ArrayList<Student> getProcessreuslts(String name){
        ArrayList<Student> students=new ArrayList<>();
        for(int i=0;i<x.size();i++){
            if(x.get(i).getCompanyoffer()==name){
                students.add(x.get(i));
            }
        }
        return students;

    }
    public void changecgpa(String name,double newcgpa){
        for(int i=0;i<x.size();i++){
            if(x.get(i).getname()==name){
                x.get(i).setCgpa(newcgpa);
            }
        }
    }


}