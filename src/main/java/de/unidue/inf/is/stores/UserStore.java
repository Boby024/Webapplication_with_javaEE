package de.unidue.inf.is.stores;

import java.io.Closeable;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;



public final class UserStore implements Closeable {

    private Connection connection;
    private boolean complete;


    public UserStore() throws StoreException {
        try {
            connection = DBUtil.getConnection("project");  //testdb
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }


    public void addUser(Benutzer userToAdd) throws StoreException {
    	/*Date date= new Date();
    	long time = date.getTime();
    	Timestamp ts = new Timestamp(time);
        //System.out.println(timestamp); */
    	  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	  //String d= timestamp.toString();
 
        try {
            PreparedStatement preparedStatement = connection
                            .prepareStatement("insert into Benutzer (benutzername , name, eintrittsdatum ) values (?, ?, ?)");
            preparedStatement.setString(1, userToAdd.getBenutzername ());
            preparedStatement.setString(2, userToAdd.getName());
            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.executeUpdate();
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
