package de.unidue.inf.is.stores;

import java.util.List;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.utils.DBUtil;

public class Anzeigen {

    private Connection connection;
    private boolean complete;


    public Anzeigen() throws StoreException {
        try {
            connection = DBUtil.getConnection("project");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }

    public ArrayList<String> getKategories(int id){
    	ArrayList<String> kategories = new ArrayList<>();
    	try (
    		PreparedStatement ps = connection.prepareStatement("select * from dbp71.hatkategorie where anzeigeid = ?")){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			    kategories.add(rs.getString("kategorie"));
				}
    	}catch (SQLException e) {
            throw new StoreException(e);
    	}
    	
    	return kategories;
    }
    
    public  ArrayList <Anzeige> getAnzeige() {
            Anzeige zeig= new Anzeige();
            ArrayList<Anzeige> results = new ArrayList<>();
			try (PreparedStatement ps = connection.prepareStatement("select * from dbp71.anzeige")){
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String titel = rs.getString("titel");
					String text = rs.getString("text");
					float preis = rs.getFloat("preis");
					Date erstellungsdatum = rs.getTimestamp("erstellungsdatum");
					String ersteller = rs.getString("ersteller");
					String status = rs.getString("status");
                    ArrayList<String> kategories = getKategories(id);
					results.add(new Anzeige( id, titel, kategories,preis,text,
    		  erstellungsdatum,  ersteller,status));
				}
			}catch (SQLException e) {
            throw new StoreException(e);
        }
			return results;
    }
    
    /*public static List<Anzeige> getAnzeige(String sortParam) {

		List<Anzeige> results = new ArrayList<>();
		String sqlSelect;
		if (sortParam.equals("Titel")) {
			sqlSelect = "select * from dbp71.anzeige order by titel";
		} else if (sortParam.equals("Erstellungsdatum")){
			sqlSelect = "select * from dbp71.anzeige order by erstellungsdatum";
		} else {
			return new ArrayList<>();
		}
		Connection conn = null;
		try{
			conn = DBUtil.getConnection("project"); 
			try (PreparedStatement ps = conn.prepareStatement(sqlSelect)){
				System.out.println(sortParam);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("id");
					String titel = rs.getString("titel");
					String text = rs.getString("text");
					double preis = rs.getDouble("preis");
					Date erstellungsdatum = rs.getTimestamp("erstellungsdatum");
					String ersteller = rs.getString("ersteller");
					String status = rs.getString("status");
					 ArrayList<String> kategories = getKategories(id);
						results.add(new Anzeige( id, titel, kategories,preis,text,
	    		  erstellungsdatum, ersteller, status));
					}		
				ps.close();
				rs.close();

			}catch (SQLException e) {
	            throw new StoreException(e);
	        }
		return results;
		}
    } */
	


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
