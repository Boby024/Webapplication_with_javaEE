package de.unidue.inf.is.stores;

import java.io.Closeable;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;



public final class AnzeigeStore implements Closeable {

    private Connection connection;
    private boolean complete;


    public AnzeigeStore() throws StoreException {
        try {
            connection = DBUtil.getConnection("project");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    
    public void addAnzeige(Anzeige anzeigeToAdd) throws StoreException {
    	
   	 //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
   	 try {
           PreparedStatement preparedStatement = connection
                           .prepareStatement("insert into Dbp71.Anzeige (titel, text, preis, ersteller, status) values (?,?,?,?,?)");
                           		
           //preparedStatement.setInt(1, anzeigeToAdd.getId_Anzeige());
           preparedStatement.setString(1, anzeigeToAdd.getTitel());
           preparedStatement.setString(2, anzeigeToAdd.getText());
           preparedStatement.setBigDecimal(3, BigDecimal.valueOf(anzeigeToAdd.getPreis()));
          // preparedStatement.setString(5, anzeigeToAdd.getErsteller());
           preparedStatement.setString(4, anzeigeToAdd.getErsteller());
           preparedStatement.setString(5, anzeigeToAdd.getStatus());
           System.out.println(anzeigeToAdd.getTitel()+ anzeigeToAdd.getText()+ BigDecimal.valueOf(anzeigeToAdd.getPreis())
           + anzeigeToAdd.getErsteller()+ anzeigeToAdd.getErsteller()+ anzeigeToAdd.getStatus());
           preparedStatement.executeUpdate();
           
           
       }
       catch (SQLException e) {
           throw new StoreException(e);
       }
   }



   /* public Anzeige addAnzeige(Anzeige anzeigeToAdd) throws StoreException {
    	
    	 //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       
    	 try {
            PreparedStatement preparedStatement = connection
                            .prepareStatement("insert into Dbp71.Anzeige (titel, text, preis, ersteller, status) values (?,?,?,?,?)"
                            		,Statement.RETURN_GENERATED_KEYS);
            //preparedStatement.setInt(1, anzeigeToAdd.getId_Anzeige());
            preparedStatement.setString(1, anzeigeToAdd.getTitel());
            preparedStatement.setString(2, anzeigeToAdd.getText());
            preparedStatement.setBigDecimal(3, BigDecimal.valueOf(anzeigeToAdd.getPreis()));
           // preparedStatement.setString(5, anzeigeToAdd.getErsteller());
            preparedStatement.setString(4, anzeigeToAdd.getErsteller());
            preparedStatement.setString(5, anzeigeToAdd.getStatus());
            System.out.println(anzeigeToAdd.getTitel()+ anzeigeToAdd.getText()+ BigDecimal.valueOf(anzeigeToAdd.getPreis())
            + anzeigeToAdd.getErsteller()+ anzeigeToAdd.getErsteller()+ anzeigeToAdd.getStatus());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	
                	anzeigeToAdd.setId(generatedKeys.getInt(1));
                	return anzeigeToAdd;
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }
*/

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
