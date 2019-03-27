package de.unidue.inf.is.stores;

import java.io.IOException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.utils.DBUtil;

public class EdditierenStore {

    private static Connection connection;
    private boolean complete;


    public EdditierenStore() throws StoreException {
        try {
            connection = DBUtil.getConnection("project");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }

    public boolean checkErsteller(String benutzername, int id) {
    	//String sqlSelect = "select * from dbp69.anzeige where ersteller  = ? AND id = ? ";
    	ResultSet rs;
   	 try {
           PreparedStatement preparedStatement = connection
                           .prepareStatement("\"select * from dbp71.anzeige where ersteller  = ? AND id = ? \"");
          rs=preparedStatement.executeQuery();
          
           return rs.next();
       }
   	 catch (SQLException e) {
         throw new StoreException(e);
     }
   	 
     }
    
   
    public void eddAnzeige(Anzeige anzeigeToEdd) throws StoreException {
    	
    	 //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		int id;
    	ResultSet rs;
    	 try {
            PreparedStatement ps = connection
                            .prepareStatement("update dbp71.anzeige set titel = ?, text = ?,preis = ? where id = ?");
            //preparedStatement.setInt(1, anzeigeToAdd.getId_Anzeige());
            ps.setString(1, anzeigeToEdd.getTitel());
            ps.setString(2, anzeigeToEdd.getText());
            ps.setBigDecimal(3, BigDecimal.valueOf(anzeigeToEdd.getPreis()));
            ps.setInt(4, anzeigeToEdd.getId());
           
        
           ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }

    public static int getLastAnzeigeID(Timestamp intialTime, String ersteller) {
		String sqlSelect = "SELECT id FROM dbp71.Anzeige WHERE ersteller = ? AND erstellungsdatum > ?";
		//Connection conn = null;
		int id = 0;
		
			try {PreparedStatement ps = connection.prepareStatement(sqlSelect);
				ps.setString(1,ersteller);
				ps.setTimestamp(2, intialTime);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				ps.close();
				rs.close();
			}catch (SQLException e) {
			            throw new StoreException(e);
			        }
			return id;
			}
    public static boolean insertAnzeige(String ersteller, String titel, String text, double preis) {
		String sqlInsert = "insert into dbp71.anzeige (titel, text,preis,ersteller,status) values (?,?,?,?,?)";
		Connection conn = null;
		BigDecimal decimalpreis = BigDecimal.valueOf(preis);
		Boolean bool = false;
		try{
			//conn = DBUtil.getConnection("project");
			try (PreparedStatement ps = connection.prepareStatement(sqlInsert)){
				ps.setString(1, titel);
				ps.setString(2, text);
				ps.setBigDecimal(3, decimalpreis);
				ps.setString(4, ersteller);
				ps.setString(5, "aktiv");
				ps.executeUpdate();
				bool = true;
				ps.close();
			}catch (SQLException e) {
	            throw new StoreException(e);
	        }
		} finally {
			if (conn != null ) {
			try {
					conn.close();
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
    	}
			
		
		return bool;
    }
    public static boolean addAnzeige(String ersteller, String titel, String text, String[] kategories, double preis) {
		Timestamp initialTime = new Timestamp(System.currentTimeMillis());
		
		boolean anzeige = insertAnzeige(ersteller, titel, text, preis);
		if (anzeige) {
			int id = getLastAnzeigeID(initialTime, ersteller);
			boolean hatkat = false;
			for (String kategorie: kategories) {
				hatkat = AnzeigeUpdate.insertHatKategorie(kategorie, id);
			}
			return hatkat;
		}
		return false;
	}

    public void complete() {
        complete = true;
    }


    public void close() throws IOException {
        if (connection != null) {
            try {
                if (complete) {
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }
            catch (SQLException e) {
                throw new StoreException(e);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    throw new StoreException(e);
                }
            }
        }
    }
}
