package org.afpa.DAL;

import org.afpa.App;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class PapyrusDB {
    private String URL_PAPYRUS ;
    private String USR_PAPYRUS ;
    private String PWD_PAPYRUS ;
    public Connection con = null;



    public PapyrusDB()  {
        try (InputStream input = App.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
           // System.out.println(prop.getProperty("db.url"));
            URL_PAPYRUS=prop.getProperty("db.url");
            //System.out.println(prop.getProperty("db.user"));
            USR_PAPYRUS=prop.getProperty("db.user");
            //System.out.println(prop.getProperty("db.password"));
            PWD_PAPYRUS= prop.getProperty("db.password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Permet de récupérer la connection à la base de donnée
     * @return connection
     */
    public Connection getCon() throws SQLException {
        con = DriverManager.getConnection(URL_PAPYRUS, USR_PAPYRUS, PWD_PAPYRUS);

        return con;
    }

    /**
     * permet de fermer la connection
     */
    public void closeCon() throws SQLException {
        con.close();
    }
}
