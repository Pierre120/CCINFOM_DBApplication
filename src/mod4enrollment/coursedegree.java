package mod4enrollment;
import java.sql.*;

/**
 * Data Management Code for `coursedegree` table in `enrolldb`.
 * @author Pierre Vincent C. Hernandez
 */
public class coursedegree {
    public String courseID;
    public String degree;
    
    /**
     * Initializes a coursedegree object.
     */
    public coursedegree () {
        courseID = "";
        degree = "";
    }
    
    /**
     * Adds a new record.
     * @return 1 if adding of record is successful, otherwise 0
     */
    public int addRecord() {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare INSERT Statement
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO coursedegree VALUES (?,?)");
            // Supply values for statement
            pStmt.setString(1, courseID);
            pStmt.setString(2, degree);
            // Execute prepared SQL Statement
            pStmt.executeUpdate();   
            pStmt.close();
            conn.close(); // Close connection
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    }
    
    /**
     * Modifies an existing record.
     * @return 1 if modification of a record is successful, otherwise 0
     */
    public int modRecord(String newCourseID, String newDegree) {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare UPDATE Statement
            PreparedStatement pStmt = conn.prepareStatement("UPDATE coursedegree  " +
                                                            "SET    courseid = ?, " +
                                                            "       degree   = ?  " +
                                                            "WHERE  courseid = ? AND degree = ? ");
            // Supply values for statement
            pStmt.setString(1, newCourseID);
            pStmt.setString(2, newDegree);
            pStmt.setString(3, courseID);
            pStmt.setString(4, degree);
            // Execute prepared SQL Statement
            pStmt.executeUpdate();   
            pStmt.close();
            conn.close(); // Close connection
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    }
    
    /**
     * Deletes a record.
     * @return 1 if record deletion is successful, otherwise 0
     */
    public int delRecord() {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare DELETE Statement
            PreparedStatement pStmt = conn.prepareStatement("DELETE FROM coursedegree WHERE courseid = ? AND degree = ?");
            // Supply values for statement
            pStmt.setString(1, courseID);
            pStmt.setString(2, degree);
            // Execute prepared statement
            pStmt.executeUpdate();   
            pStmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    }
    
    /**
     * Retrieves a record.
     * @return 1 if retrieval of a record is successful, otherwise 0 
     */
    public int getRecord() {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare SELECT Statement
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM coursedegree WHERE courseid = ? AND degree = ?");
            // Supply values for statement
            pStmt.setString(1, courseID);
            pStmt.setString(2, degree);
            // Execute prepared statement and store the result
            ResultSet rs = pStmt.executeQuery();
            // Get the results
            while (rs.next()) {
                courseID = rs.getString("courseid");
                degree = rs.getString("degree");
            }
            rs.close();
            pStmt.close();
            conn.close(); // Close the connection
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
            return 0;
        }
    }
    
    public static void main(String args[]) {
       coursedegree cd = new coursedegree();
       
       // Test for addRecord() [SUCCESS]
       /*
       System.out.println("Testing addRecord()...");
       cd.courseID = "CCPROG3";
       cd.degree = "BSCS";
       int res1 = cd.addRecord();
       System.out.println("Return code: " + res1);
       */
       
       // Test for modRecord() [SUCCESS]
       /*
       System.out.println("Testing modRecord()...");
       // Set 1
       //cd.courseID = "CCPROG3";
       //cd.degree = "BSCS";
       //int res21 = cd.modRecord(cd.courseID, "BSIT");
       //System.out.println("Return code: " + res21);
       // Set 2
       //cd.courseID = "CCPROG3";
       //cd.degree = "BSIT";
       //int res22 = cd.modRecord("ISINFOM", cd.degree);
       //System.out.println("Return code: " + res22);
       // Set 3
       //cd.courseID = "ISINFOM";
       //cd.degree = "BSIT";
       //int res23 = cd.modRecord("CCPROG2", "BSIS");
       //System.out.println("Return code: " + res23);
       */
        
       // Test for delRecord() [SUCCESS]
       /*
       System.out.println("Testing delRecord()...");
       cd.courseID = "CCPROG2";
       cd.degree = "BSIS";
       int res3 = cd.delRecord();
       System.out.println("Return code: " + res3);
       */
        
       // Test for getRecord() [SUCCESS]
       ///*
       System.out.println("Testing getRecord()...");
       cd.courseID = "CCPROG1";
       cd.degree = "BSCS";
       int res4 = cd.getRecord();
       System.out.println("Return code: " + res4);
       System.out.println("Course ID: " + cd.courseID); // CCPROG1
       System.out.println("Degree: " + cd.degree); // BSCS
       //*/
    }
}



/*
public class coursedegree {
    
    public coursedegree () {};
    public int modRecord()  { return 0; };
    public int delRecord()  { return 0; };
    public int addRecord()  { return 0; };
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
       
    }
}*/
