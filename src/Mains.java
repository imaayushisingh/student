import java.util.Scanner;
public class Mains {
    static Scanner input = new Scanner(System.in);
    static StudentDetails[] students = new StudentDetails[0];
    static void addStudent() {
        StudentDetails[] tempArr = new StudentDetails[students.length + 1];
        System.out.println("enter reg. num, branch and name: ");
        String regNum = input.next();
        String branch = input.next();
        String name = input.next();
        StudentDetails temStudent = new StudentDetails(regNum, branch, name);
        for (int i = 0; i < students.length; i++) {
            tempArr[i] = students[i];
        }
        tempArr[students.length] = temStudent;
        students = tempArr;
        System.out.println("student successfully added!");
    }

    static void getStudentDetails(String regNum) {
        System.out.printf("%10s %5s %10s %5s %10s %5s %4s %10s %4s %10s %4s", "Reg.num", "|", "Branch", "|", "Name", "|", "Phy", "|", "Chem", "|", "Math");
        System.out.println();
        System.out.print("------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            if (regNum.equals(students[i].getRegNum())){
                System.out.println();
                System.out.printf("%10s %5s %10s %5s %10s %5s %4f %5s %4f %5s %4f", students[i].getRegNum(), "|", students[i].getBranch(), "|", students[i].getName(), "|", students[i].getMarksPhy(), "|", students[i].getMarksChem(), "|", students[i].getMarksMaths());
                System.out.println();
            }
        }
    }

    static void getFailedStudents() {
        System.out.printf("%10s %5s %10s %5s %10s %5s %4s %10s %4s %10s %4s", "Reg.num", "|", "Branch", "|", "Name", "|", "Phy", "|", "Chem", "|", "Math");
        System.out.println();
        System.out.print("------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getPercentage() < 33.0) {
                System.out.println();
                System.out.printf("%10s %5s %10s %5s %10s %5s %4f %5s %4f %5s %4f", students[i].getRegNum(), "|", students[i].getBranch(), "|", students[i].getName(), "|", students[i].getMarksPhy(), "|", students[i].getMarksChem(), "|", students[i].getMarksMaths());
                System.out.println();
            }
        }
    }

    static void getToppers() {
        System.out.printf("%10s %5s %10s %5s %10s %5s %4s %10s %4s %10s %4s", "Reg.num", "|", "Branch", "|", "Name", "|", "Phy", "|", "Chem", "|", "Math");
        System.out.println();
        System.out.print("------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getPercentage() >= 90.0) {
                System.out.println();
                System.out.printf("%10s %5s %10s %5s %10s %5s %4f %5s %4f %5s %4f", students[i].getRegNum(), "|", students[i].getBranch(), "|", students[i].getName(), "|", students[i].getMarksPhy(), "|", students[i].getMarksChem(), "|", students[i].getMarksMaths());
                System.out.println();
            }
        }
    }

    static void getClassAverage() {
        System.out.printf("%10s %5s %10s %5s %10s %5s %4s %10s %4s %10s %4s", "Reg.num", "|", "Branch", "|", "Name", "|", "Phy", "|", "Chem", "|", "Math");
        System.out.println();
        System.out.print("------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println();
            System.out.printf("%10s %5s %10s %5s %10s %5s %4f %5s %4f %5s %4f", students[i].getRegNum(), "|", students[i].getBranch(), "|", students[i].getName(), "|", students[i].getMarksPhy(), "|", students[i].getMarksChem(), "|", students[i].getMarksMaths());
        }
        double classAveragePhy,classAverageChem,classAverageMath;
        double totalMarksPhy = 0,totalMarksChem=0 ,totalMarksMath=0;
        for (int i = 0; i < students.length; i++) {
            double phyMarks = students[i].getMarksPhy();
            totalMarksPhy=totalMarksPhy+phyMarks;
            double chemMarks = students[i].getMarksChem();
            totalMarksChem=totalMarksChem+chemMarks;
            double mathMarks = students[i].getMarksMaths();
            totalMarksMath = totalMarksMath+mathMarks;
        }
        classAveragePhy = (totalMarksPhy) / (students.length);
        classAverageChem = (totalMarksChem) / (students.length);
        classAverageMath = (totalMarksMath) / (students.length);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %39s %4f %5s %4f %5s %4f","class avg:","|",classAveragePhy,"|",classAverageChem,"|",classAverageMath);
        System.out.println();
    }
    public static void main(String[] args){
        boolean flag = true;
        while(flag){
            System.out.print("enter 1. adding student, 2. getting student details, 3. getting failed students, 4. getting toppers, 5. getting class average, 6. exit: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> {
                    System.out.print("enter registration number: ");
                    String regNum = input.next();
                    getStudentDetails(regNum);
                }
                case 3 -> getFailedStudents();
                case 4 -> getToppers();
                case 5 -> getClassAverage();
                case 6 -> flag=false;
                default -> System.out.println("Invalid Choice! ");
            }
        }
    }
}





