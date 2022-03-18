package mod4enrollment;
import java.sql.*;
import java.util.*;

/**
 * Process code for enrolling courses.
 * @author Ben Ong
 */
public class enroll {

    public students                 Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
 
    public enroll() { // perform all the necessary data loading from DB
        clearEnrollment();
        CourseList.clear();
    }             
    
    public int clearEnrollment ()   { // clears enrollment data of the student 
        EnrollmentList.clear();
        return 1;   
    }   
    
    public int loadCourses ()       {  // load valid courses into the course list
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement   sqlstatement = conn.prepareStatement("SELECT *\n" +
                                                                     "FROM coursedegree cd\n" +
                                                                     "WHERE cd.degree LIKE ? \n" +
                                                                     "AND cd.courseid NOT IN (SELECT e.courseid \n" +
                                                                                              "FROM enrollment e JOIN students s ON e.studentid=s.studentid\n" +
                                                                                              "WHERE s.studentid = ?)\n" +
                                                                     ";");
            sqlstatement.setString(1, Student.degreeID);
            sqlstatement.setLong(2, Student.studentID);
            ResultSet rs = sqlstatement.executeQuery();
            CourseList.clear();
            while (rs.next()) {
                coursedegree cd = new coursedegree();
                cd.courseID = rs.getString ("courseid");
                cd.degree = rs.getString ("degree");
                CourseList.add(cd);
            }
            for (int i = 0; i < EnrollmentList.size(); i++){
                for (int j = 0; j < CourseList.size(); j++){
                    if (EnrollmentList.get(i).courseID.equals(CourseList.get(j).courseID)){
                        CourseList.remove(j);
                        break;
                    }
                }
            }
            
            sqlstatement.close();
            conn.close();
            //for (int i = 0; i < EnrollmentList.size(); i++)
            //    CourseList.remove(EnrollmentList.get(i));
            return 1;    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }   
    
    public int confirmEnrollment()  {   // saves enrollment data into the Database
        for (int i = 0; i < EnrollmentList.size(); i++){
            EnrollmentList.get(i).addRecord();
        }
        return 1;   
    }   
}


/*
public class enroll {

    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList      = new ArrayList<> ();
 
    public enroll() {};                                 // perform all the necessary data loading from DB
    public int clearEnrollment ()   {   return 0;   }   // clears enrollment data of the student 
    public int loadCourses ()       {   return 0;   }   // load valid courses into the course list
    public int confirmEnrollment()  {   return 0;   }   // saves enrollment data into the Database
    
}*/
