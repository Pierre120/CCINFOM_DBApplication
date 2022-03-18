package mod4enrollment;
import java.sql.*;

/**
 * Data Management Code for `courses` table in `enrolldb`.
 * @author Pierre Vincent C. Hernandez
 */
public class courses {
    public String courseID;   // PK
    public String courseName;
    public String department;
    
    /**
     * Initializes a courses object.
     */
    public courses() {
        courseID   = "";
        courseName = "";
        department = "";
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
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO courses VALUES (?,?,?)");
            // Supply values for statement
            pStmt.setString(1, courseID);
            pStmt.setString(2, courseName);
            pStmt.setString(3, department);
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
    public int modRecord() {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare UPDATE Statement
            PreparedStatement pStmt = conn.prepareStatement("UPDATE courses          " +
                                                            "SET    coursename = ? , " +
                                                            "       department = ?   " + 
                                                            "WHERE  courseid   = ?   ");
            // Supply values for statement
            pStmt.setString(1, courseName);
            pStmt.setString(2, department);
            pStmt.setString(3, courseID);
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
            PreparedStatement pStmt = conn.prepareStatement("DELETE FROM courses WHERE courseid = ?");
            // Supply values for statement
            pStmt.setString(1, courseID);
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
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM courses WHERE courseid = ?");
            // Supply values for statement
            pStmt.setString(1, courseID);
            // Execute prepared statement and store the result
            ResultSet rs = pStmt.executeQuery();   
            
            // Clear up most recent values.
            courseID = "";
            courseName = ""; 
            department = "";
            // This is to see if the result set contains some results,
            // which makes it easier to determine if a specifc student
            // record exixsts in the `courses` table.

            // Get the results
            while (rs.next()) {
                courseID = rs.getString("courseid");
                courseName = rs.getString("coursename");
                department = rs.getString("department");
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
        courses c1 = new courses();
        
        // Test for addRecord() [SUCCESS]
        /*
        System.out.println("Testing addRecord()...");
        c1.courseID = "CSNETWK"; //
        c1.courseName = "Introduction to Computer Networks";
        c1.department = "Computer Technology";
        int res1 = c1.addRecord();
        System.out.println("Return code: " + res1);
        */
       
        // Test for modRecord() [SUCCESS]
        /*
        System.out.println("Testing modRecord()...");
        c1.courseID = "CSNETWK";
        c1.courseName = "Intro to Comp Net";
        c1.department = "Comp Tech";
        int res2 = c1.modRecord();
        System.out.println("Return code: " + res2);
        */
        
        // Test for delRecord() [SUCCESS]
        /*
        System.out.println("Testing delRecord()...");
        c1.courseID = "CSNETWK"; //
        int res3 = c1.delRecord();
        System.out.println("Return code: " + res3);
        */
        
        // Test for getRecord() [SUCCESS]
        ///*
        System.out.println("Testing getRecord()...");
        c1.courseID = "CCINFOM"; // CCINFOM
        int res4 = c1.getRecord();
        if(c1.courseID.equals("")) {
            System.out.println("Course record doesn't exist.");
        }
        else {
            System.out.println("Return code: " + res4);
            System.out.println("ID: " + c1.courseID);
            System.out.println("Name: " + c1.courseName); // Introduction to Databases
            System.out.println("Department: " + c1.department); // Information Technology
        }
        //*/
    }
}



/*
public class courses {
    
    public courses () {};
    public int modRecord()  { return 0; };
    public int delRecord()  { return 0; };
    public int addRecord()  { return 0; };
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
        
    }
}
*/