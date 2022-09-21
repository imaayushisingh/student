import java.util.Scanner;
public class StudentDetails {
    private String regNum;
    private String branch;
    private String name;
    private double[] marks = new double[3];
    Scanner input = new Scanner(System.in);
    StudentDetails(String regNum,String branch,String name){
        this.regNum = regNum;
        this.branch = branch;
        this.name = name;
        System.out.print("enter marks for physics, chemistry and maths: ");
        for(int i=0; i<3; i++){
            this.marks[i]=input.nextDouble();
        }
    }

    String getRegNum(){
        return this.regNum;
    }
    String getBranch(){
        return this.branch;
    }
    String getName(){
        return this.name;
    }
    double getMarksPhy(){
        return this.marks[0];
    }
    double getMarksChem(){
        return this.marks[1];
    }
    double getMarksMaths(){
        return this.marks[2];
    }

    double getPercentage(){
        double totalMarks=0;
        for(int i=0;i<3;i++){
            totalMarks=totalMarks+this.marks[i];
        }
        double percentage = (totalMarks/300.0)*100.0;
        return percentage;

    }


}
