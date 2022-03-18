package mod4enrollment;
import java.sql.*;

/**
 * Data Management Code for `students` table in `enrolldb`.
 * @author Pierre Vincent C. Hernandez
 */
public class students {
    public long   studentID;    // PK
    public String fullName;
    public String degreeID;
    
    /**
     * Initializes a students object.
     */
    public students() {
        studentID = 0;
        fullName = "";
        degreeID = "";
    }
    
    /**
     * Adds a record.
     * @return 1 if adding of record is successful, otherwise 0
     */
    public int addRecord() { 
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare INSERT Statement
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO students VALUES (?,?,?)");
            // Supply values for statement
            pStmt.setLong(1, studentID);
            pStmt.setString (2, fullName);
            pStmt.setString (3, degreeID);
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
            PreparedStatement pStmt = conn.prepareStatement("UPDATE students           " +
                                                            "SET    completename = ? , " +
                                                            "       degreeid     = ?   " + 
                                                            "WHERE  studentid    = ?   ");
            // Supply values for statement
            pStmt.setString(1, fullName);
            pStmt.setString(2, degreeID);
            pStmt.setLong(3, studentID);
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
            PreparedStatement pStmt = conn.prepareStatement("DELETE FROM students WHERE studentid = ?");
            // Supply values for statement
            pStmt.setLong(1, studentID);
            // Execute prepared statement
            pStmt.executeUpdate();   
            pStmt.close();
            conn.close(); // Close the connection
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
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM students WHERE studentid = ?");
            // Supply values for statement
            pStmt.setLong(1, studentID);
            // Execute prepared statement and store the result
            ResultSet rs = pStmt.executeQuery();
            
            // Clear up most recent values.
            studentID = 0;
            fullName = "";
            degreeID = "";
            // This is to see if the result set contains some results,
            // which makes it easier to determine if a specifc student
            // record exixsts in the `students` table.
            
            // Get the results
            while (rs.next()) {
                studentID = rs.getLong("studentid");
                fullName = rs.getString("completename");
                degreeID = rs.getString("degreeid");
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
        students s1 = new students();
        
        // Test for addRecord() [SUCCESS]
        /*
        System.out.println("Testing addRecord()...");
        s1.studentID = 12345678; // 10100011
        s1.fullName = "Layla Clapton"; // Kathleen Bulag
        s1.degreeID = "BSCS-NIS"; // BSIT
        int res1 = s1.addRecord();
        System.out.println("Return code: " + res1);
        */
        
        // Test for modRecord() [SUCCESS]
        /*
        System.out.println("Testing modRecord()...");
        s1.studentID = 12345678;
        s1.fullName = "Pierre Hernandez";
        s1.degreeID = "BSCS-CSE";
        int res2 = s1.modRecord();
        System.out.println("Return code: " + res2);
        */
        
        // Test for delRecord() [SUCCESS]
        /*
        System.out.println("Testing delRecord()...");
        s1.studentID = 12345678;
        int res3 = s1.delRecord();
        System.out.println("Return code: " + res3);
        */
        
        // Test for getRecord() [SUCCESS]
        ///*
        System.out.println("Testing getRecord()...");
        s1.studentID = 10100008; // 10100008
        int res4 = s1.getRecord();
        if(s1.studentID == 0) {
            System.out.println("Student record doesn't exist.");
        }
        else {
            System.out.println("Return code: " + res4);
            System.out.println("ID: " + s1.studentID);
            System.out.println("Name: " + s1.fullName);   // Henrietta Ong
            System.out.println("Degree: " + s1.degreeID); // BSCS
        }
        //*/
    }
}



/*
public class students {
    
    public students () {};
    public int modRecord()  { return 0; };
    public int delRecord()  { return 0; };
    public int addRecord()  { return 0; };
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
        
    }
}
*/