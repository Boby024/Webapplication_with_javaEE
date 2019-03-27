package de.unidue.inf.is.stores;

import java.io.Closeable;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;



public final class AnzeigeUpdate implements Closeable {

    private  static Connection connection;
    private boolean complete;


    public AnzeigeUpdate() throws StoreException {
        try {
            connection = DBUtil.getConnection("project");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }

    public static boolean deleteKategorie(int anzeige_id) {
		String sqlUpdate = "delete from dbp71.hatkategorie where anzeigeid = ?";
		//Connection conn = null;
		Boolean bool = false;
		
			try {PreparedStatement ps = connection.prepareStatement(sqlUpdate);
				ps.setInt(1,anzeige_id);
				ps.executeUpdate();
				bool = true;
				ps.close();
		
			}catch (SQLException e) {
		        throw new StoreException(e);
		    }
		return bool;
		
	}
    
    public static boolean insertHatKategorie(String kategorie, int id) {
		//String sqlInsert = "insert into dbp71.hatkategorie(anzeigeid, kategorie) values (?,?)";
		//Connection conn = null;
		Boolean bool1 = false;
		
			try {
				 PreparedStatement ps = connection.prepareStatement("insert into dbp71.hatkategorie(anzeigeid, kategorie) values (?,?)");
				ps.setInt(1, id);
				ps.setString(2, kategorie);
				ps.executeUpdate();
				bool1 = true;
				ps.close();
	
	    }
	    catch (SQLException e) {
	        throw new StoreException(e);
	    }
			return bool1;
		
    }
  

    public void updateAnzeige(Anzeige anzeigeToAdd) throws StoreException {
    	
    	 //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       Boolean bool=false;
       //int id;
       String [] kategories=null;
    	 try {
            PreparedStatement ps = connection
                            .prepareStatement("update dbp71.anzeige set titel = ?, text = ?,preis = ? where id = ?");
            ps.setString(1, anzeigeToAdd.getTitel());
			ps.setString(2, anzeigeToAdd.getText());
			ps.setBigDecimal(3, BigDecimal.valueOf(anzeigeToAdd.getPreis()));
			ps.setInt(4, anzeigeToAdd.getId());
			ps.executeUpdate();
            bool = deleteKategorie(anzeigeToAdd.getId());
            for (String kategorie: kategories ){
                bool = insertHatKategorie(kategorie,anzeigeToAdd.getId());
            ps.executeUpdate();
            
            	}
    	 }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }


    public void complete() {
        complete = true;
    }


    @Override
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
