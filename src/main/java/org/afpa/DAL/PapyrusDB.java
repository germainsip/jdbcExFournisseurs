package org.afpa.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class PapyrusDB {
    private final String URL_PAPYRUS = "jdbc:mysql://localhost:3306/papyrus";
    private final String USR_PAPYRUS = "root";
    private final String PWD_PAPYRUS = "Grm1";
    public Connection con = null;



    public PapyrusDB() throws SQLException {
    }

    public Connection getCon() throws SQLException {
        con = DriverManager.getConnection(URL_PAPYRUS, USR_PAPYRUS, PWD_PAPYRUS);

        return con;
    }
}
