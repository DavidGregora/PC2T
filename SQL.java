package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/* public class SQL {
	
	private Connection conn; 
	public boolean connect() { 
	       conn= null; 
	       try {
	              conn = DriverManager.getConnection("jdbc:sqlite:myDB.db");                       
	       } 
	      catch (SQLException e) { 
	            System.out.println(e.getMessage());
		    return false;
	      }
	      return true;
	}
	public void disconnect() { 
		if (conn != null) {
		       try {     conn.close();  } 
	               catch (SQLException ex) { System.out.println(ex.getMessage()); }
		}
	}
	
	
	public boolean createTable()
	{
	     if (conn==null)
	           return false;
	    String sql = "CREATE TABLE IF NOT EXISTS knihy (" + "nazov varchar(255) PRIMARY KEY," + "autori varchar(255),"+ "rokVydania integer, " + "jeDostupna varchar(50), " + "zaner varchar(100)" + ");";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public void insertRecord(String nazov, String autori, int rokVydania, int jeDostupna, String zaner ) {
        String sql = "INSERT INTO knihy(nazov,autori,rokVydania,jeDostupna, zaner) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, nazov);
            pstmt.setString(2, autori);
            pstmt.setInt(3, rokVydania);
            pstmt.setBoolean(jeDostupna, true);
            pstmt.setString(4, zaner);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void selectAll(){
        String sql = "SELECT nazov,autori,rokVydania,jeDostupna,zaner FROM knihy";
        try {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             while (rs.next()) {
                	System.out.println(rs.getString("nazov") +  "\t" +  
rs.getString("autori") + "\t" + 
rs.getInt("rokVydania") + "\t" + 
rs.getInt("jeDostupna") + "\t" + 
rs.getString("zaner"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}
	





}
*/