import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true){

            System.out.println("\n1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Update Student");
            System.out.println("4 Delete Student");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if(choice == 1){

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student s = new Student(name, age, course);

                dao.addStudent(s);

            }

            else if(choice == 2){

                dao.viewStudents();

            }

            else if(choice == 3){

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                dao.updateStudent(id, name, age, course);

            }

            else if(choice == 4){

                System.out.print("Enter Student ID to delete: ");
                int id = sc.nextInt();

                dao.deleteStudent(id);

            }

            else if(choice == 5){

                System.out.println("Program Ended");
                break;

            }

        }

    }

}
