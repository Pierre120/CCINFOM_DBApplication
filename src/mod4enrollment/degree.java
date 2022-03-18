package mod4enrollment;
import java.sql.*;

/**
 * Data Management Code for `degree` table in `enrolldb`.
 * @author Pierre Vincent C. Hernandez
 */
public class degree {
    public String degreeID;    // PK
    public String degreeName;
    
    /**
     * Initializes a degree object.
     */
    public degree () {
        degreeID = "";
        degreeName = "";
    }
    
    /**
     * Adds a new record.
     * @return 1 if adding of record is successful, otherwise 0
     */
    public int addRecord()  {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare INSERT Statement
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO degree VALUES (?,?)");
            // Supply values for statement
            pStmt.setString(1, degreeID);
            pStmt.setString(2, degreeName);
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
    public int modRecord()  {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare UPDATE Statement
            PreparedStatement pStmt = conn.prepareStatement("UPDATE degree         " +
                                                            "SET    degreename = ? " +
                                                            "WHERE  degreeid   = ? ");
            // Supply values for statement
            pStmt.setString(1, degreeName);
            pStmt.setString(2, degreeID);
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
    public int delRecord()  {
        try {
            Connection conn;     
            // Connect to enrolldb
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolldb?user=root&password=12345678&useTimezone=true&serverTimezone=UTC&useSSL=false");
            // Prepare DELETE Statement
            PreparedStatement pStmt = conn.prepareStatement("DELETE FROM degree WHERE degreeid = ?");
            // Supply values for statement
            pStmt.setString(1, degreeID);
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
            PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM degree WHERE degreeid = ?");
            // Supply values for statement
            pStmt.setString(1, degreeID);
            // Execute prepared statement and store the result
            ResultSet rs = pStmt.executeQuery();
            // Get the results
            while (rs.next()) {
                degreeID = rs.getString("degreeid");
                degreeName = rs.getString("degreename");
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
        degree d1 = new degree();
        
        // Test for addRecord() [SUCCESS]
        ///*
        System.out.println("Testing addRecord()...");
        d1.degreeID = "BSCS-CSE";
        d1.degreeName = "BSCS Major in Computer Systems Engineering";
        int res1 = d1.addRecord();
        System.out.println("Return code: " + res1);
        //*/
       
        // Test for modRecord() [SUCCESS]
        /*
        System.out.println("Testing modRecord()...");
        d1.degreeID = "BSCS-CSE";
        d1.degreeName = "BSCS Major in Comp Sys Eng";
        int res2 = d1.modRecord();
        System.out.println("Return code: " + res2);
        */
        
        // Test for delRecord() [SUCCESS]
        /*
        System.out.println("Testing delRecord()...");
        d1.degreeID = "BSCS-CSE";
        int res3 = d1.delRecord();
        System.out.println("Return code: " + res3);
        */
        
        // Test for getRecord() [SUCCESS]
        /*
        System.out.println("Testing getRecord()...");
        d1.degreeID = "BSCS";
        int res4 = d1.getRecord();
        System.out.println("Return code: " + res4);
        System.out.println("ID: " + d1.degreeID); // BSCS
        System.out.println("Name: " + d1.degreeName); // Bachelor of Science in Computer Science
        */
    }
}



/*
public class degree {
     
    public degree () {};
    public int modRecord()  { return 0; };
    public int delRecord()  { return 0; };
    public int addRecord()  { return 0; };
    public int viewRecord() { return 0; };
    
    public static void main(String args[]) {
        
    }
}*/
