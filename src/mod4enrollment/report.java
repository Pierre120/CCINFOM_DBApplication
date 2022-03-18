package mod4enrollment;
import java.sql.*;
import java.util.*;

/**
 * Process code for generating report.
 * @author Cyril Reyes
 */
public class report {
    public ArrayList<courses> courseArr = new ArrayList<> ();
    public ArrayList<Integer> countArr = new ArrayList<> ();
    public int repTerm;
    public int repSchoolYear;
  
    public report() {
        courseArr.clear();
        countArr.clear();
        repTerm = 0;
        repSchoolYear = 0;
    }

    public void resetReport() {
        courseArr.clear();
        countArr.clear();
    }

    public int generateReport() { 
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement sqlstatement = conn.prepareStatement("SELECT c.courseid, c.coursename, c.department, COUNT(e.studentid) AS numstudents                                                          FROM courses c    JOIN enrollment e on                                                c.courseid = e.courseid WHERE term =?                                            AND schoolyear =? GROUP BY e.courseid ORDER                                                          BY e.courseid");
            sqlstatement.setInt(1, repTerm);
            sqlstatement.setInt(2, repSchoolYear);
            ResultSet rs = sqlstatement.executeQuery();
            resetReport();
            
            while (rs.next()) {
                courses c = new courses();
                c.courseID = rs.getString("c.courseid");
                c.courseName = rs.getString("c.coursename");
                c.department = rs.getString("c.department");
                courseArr.add(c);
                countArr.add(rs.getInt("numstudents"));
            }
            sqlstatement.close();
            conn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
            return 0;
        } 
    }  
}

