import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s){

        try{

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name,age,course) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.name);
            ps.setInt(2, s.age);
            ps.setString(3, s.Course);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    // VIEW STUDENTS
    public void viewStudents(){

        try{

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nID  Name  Age  Course");

            while(rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println(id + " " + name + " " + age + " " + course);

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    // UPDATE STUDENT
    public void updateStudent(int id, String name, int age, String course){

        try{

            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name=?, age=?, course=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Student Updated Successfully");
            }
            else{
                System.out.println("Student ID not found");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    // DELETE STUDENT
    public void deleteStudent(int id){

        try{

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Student Deleted Successfully");
            }
            else{
                System.out.println("Student ID not found");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}