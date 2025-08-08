import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static class Person {
        Scanner sc = new Scanner(System.in);
        String name;
        private int Age;

        public void setAge() {
            while (true) {
                try {
                    System.out.print("Enter age: ");
                    Age = sc.nextInt();
                    if (Age > 0){
                        break;
                    }
                    else {
                        System.out.println();
                        System.out.println("Age must be grater than zero"); 
                    }
                } catch (InputMismatchException  e) {
                    System.out.println();
                    System.out.println("Age must be an integer");
                    sc.nextLine();
                }
            }
        }

        public void namedisplayBasicDetails() {
            System.out.printf("%-15s %-1s %s\n","Name",":",name);
            System.out.printf("%-15s %-1s %s\n","Age",":", Age);
        }
        public Boolean isMinor() {
           return Age <= 18;
        }  
    }

    public static class Student extends Person{
        private double Gread1, Gread2, Gread3;

        public void setGrade() {
        while (true) {
            try {
                System.out.print("Enter Gread 1: ");
                Gread1 = sc.nextDouble();
                System.out.print("Enter gread 2: ");
                Gread2 = sc.nextDouble();
                System.out.print("Enter gread 3: ");
                Gread3 = sc.nextDouble();
                if (0 <= Gread1 && Gread1 <= 100 && 0 <= Gread2 && Gread2 <= 100 && 0 <= Gread3 && Gread3 <= 100 ){
                    break;
                }
                else {
                    System.out.println("Greads must be between 0 and 100"); 
                }
            } catch (InputMismatchException  e) {
                System.out.println("Gread must be an integer");
                sc.nextLine();
            }
       
        }
    }

        public double calculateAverage() {
            return Math.round(((Gread1 + Gread2 + Gread3) / 3) * 100.0) / 100.0;
        }
        public double getHighestGrade() {
            
            return Math.max(Gread1, Math.max(Gread2, Gread3));
            
        }
        public Boolean hasPassed() {
            return calculateAverage() >= 50; 
        }

        public void displayStudentDetails() {
            namedisplayBasicDetails();
            System.out.printf("%-15s : %.2f, %.2f, %.2f%n", "Grades", Gread1, Gread2, Gread3);
            System.out.printf("%-15s : %.2f%n", "Average", calculateAverage());
            System.out.printf("%-15s : %.2f%n", "Highest Grade", getHighestGrade());
            System.out.printf("%-15s : %s%n", "Status", hasPassed() ? "Passed" : "Failed");
            System.out.printf("%-15s : Student is a %s%n", "Note", isMinor() ? "Minor" : "Major");
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            try {
                System.out.print("Enter the number of students: ");
                count = sc.nextInt();
                if (count<= 0) {
                    System.out.println();
                    System.out.println("Number of the students must be greater than zero");
                }
                else{
                    sc.nextLine();
                    break;
                } 
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Number of the students must be an integer");
                sc.nextLine();
            }
        }

        for(int i = 1; i <= count; i++){
            System.out.println();
            System.out.print("Enter student's name: ");
            String name = sc.nextLine();
            Student Student = new Student();
            Student.name = name;
            Student.setAge();
            Student.setGrade();    
            System.out.println();
            System.out.println("--- Student details ---");
            Student.displayStudentDetails();
            System.out.println("");
        }
        sc.close();
    }
}

