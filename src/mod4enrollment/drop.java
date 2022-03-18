package mod4enrollment;
import java.sql.*;
import java.util.*;

/**
 * Process code for dropping courses.
 * @author Ben Ong
 */
public class drop {
  
    public students                 Student             = new students();
    public ArrayList<enrollment>    DropEnrollmentList  = new ArrayList<> ();
    public ArrayList<coursedegree>  CourseList          = new ArrayList<> ();

    public drop() { // perform all the necessary data loading from DB
        CourseList.clear();
        clearDrop();
    }
    
    public int clearDrop ()         { // clears dropping data of the student
        DropEnrollmentList.clear();
        return 1;   
    }   
    
    public int loadEnrollment (int term, int schoolyear)    {   // load enrollment data of the student
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement   sqlstatement = conn.prepareStatement("SELECT *\n" +
                                                                     "FROM coursedegree cd\n" +
                                                                     "WHERE cd.degree LIKE ? \n" +
                                                                     "AND cd.courseid IN (SELECT e.courseid \n" +
                                                                                              "FROM enrollment e JOIN students s ON e.studentid=s.studentid\n" +
                                                                                              "WHERE s.studentid = ? AND e.term = ? AND e.schoolyear = ?)\n" +
                                                                     ";");
            sqlstatement.setString(1, Student.degreeID);
            sqlstatement.setLong(2, Student.studentID);
            sqlstatement.setInt(3, term);
            sqlstatement.setInt(4, schoolyear);
            ResultSet rs = sqlstatement.executeQuery();
            CourseList.clear();
            while (rs.next()) {
                coursedegree cd = new coursedegree();
                cd.courseID = rs.getString ("courseid");
                cd.degree = rs.getString ("degree");
                CourseList.add(cd);
            }
            for (int i = 0; i < DropEnrollmentList.size(); i++){
                for (int j = 0; j < CourseList.size(); j++){
                    if (DropEnrollmentList.get(i).courseID.equals(CourseList.get(j).courseID)){
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
    
    public int confirmDrop()        {   // saves dropping data into the Database
        for (int i = 0; i < DropEnrollmentList.size(); i++){
            DropEnrollmentList.get(i).delRecord();
        }
        return 1;    
    }   
}

/*
public class drop {
  
    students                        Student         = new students();
    public ArrayList<enrollment>    EnrollmentList  = new ArrayList<> ();
    public ArrayList<enrollment>    DropList        = new ArrayList<> ();

    public drop() {};                                   // perform all the necessary data loading from DB
    public int clearDrop ()         {   return 0;   }   // clears dropping data of the student
    public int loadEnrollment ()    {   return 0;   }   // load enrollment data of the student 
    public int confirmDrop()        {   return 0;   }   // saves dropping data into the Database
    
}*/
