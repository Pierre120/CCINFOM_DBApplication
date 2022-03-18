package mod4enrollment;
import java.sql.*;

/**
 * Data Management code for `enrollment` table in `enrolldb`.
 * @author Ben Ong
 */
public class enrollment {
    public long studentID;
    public String courseID;
    public int term;
    public int schoolyear;
    
    public enrollment () {
        studentID = 0;
        courseID = "";
        term = 0;
        schoolyear = 0;
    }
    
    public int modRecord(int newStudentID, String newCourseID, int newTerm, int newSchoolYear)  { 
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement sqlstatement = conn.prepareStatement("UPDATE enrollment SET " +
            "studentid = ?, courseid = ?, term = ?, schoolyear = ? " + 
            "WHERE studentid = ? AND courseid = ? AND term = ? AND schoolyear = ?;");
            sqlstatement.setInt(1, newStudentID);
            sqlstatement.setString(2, newCourseID);
            sqlstatement.setInt(3, newTerm);
            sqlstatement.setInt(4, newSchoolYear);
            sqlstatement.setLong(5, studentID);
            sqlstatement.setString(6, courseID);
            sqlstatement.setInt(7, term);
            sqlstatement.setInt(8, schoolyear);
            sqlstatement.executeUpdate();
            sqlstatement.close();
            conn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int delRecord()  { 
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement sqlstatement = conn.prepareStatement("DELETE FROM enrollment WHERE studentid=? AND courseid = ? AND term = ? AND schoolyear = ?;");
            sqlstatement.setLong(1, studentID);
            sqlstatement.setString(2, courseID);
            sqlstatement.setInt(3, term);
            sqlstatement.setInt(4, schoolyear);
            sqlstatement.executeUpdate();
            sqlstatement.close();
            conn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int addRecord()  {  
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement sqlstatement = conn.prepareStatement("INSERT INTO enrollment(studentid,courseid,term,schoolyear) VALUES (?,?,?,?)");
            sqlstatement.setLong(1, studentID);
            sqlstatement.setString(2, courseID);
            sqlstatement.setInt(3, term);
            sqlstatement.setInt(4, schoolyear);
            sqlstatement.executeUpdate();
            sqlstatement.close();
            conn.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int getRecord() { 
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            PreparedStatement sqlstatement = conn.prepareStatement("SELECT * FROM enrollment WHERE studentid=? AND courseID=? AND term=? AND schoolyear=?;");
            sqlstatement.setLong(1, studentID);
            sqlstatement.setString(2, courseID);
            sqlstatement.setInt(3, term);
            sqlstatement.setInt(4, schoolyear);
            ResultSet rs = sqlstatement.executeQuery();
            while (rs.next()) {
                studentID   = rs.getInt("studentid");
                courseID = rs.getString("courseid");
                term = rs.getInt("term");
                schoolyear = rs.getInt("schoolyear");
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


/*
public class enrollment {
    
    public enrollment () {};
    public int modRecord()  { return 0; };
    public int delRecord()  { return 0; };
    public int addRecord()  { return 0; };
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
       
    }
}*/
