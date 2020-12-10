package org.afpa.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDAO {
    PapyrusDB papyrusDB = new PapyrusDB();


    public FournisseurDAO() throws SQLException {

    }

    public List<Fournisseur> ListAll(){
        List<Fournisseur> list = new ArrayList<>();
        try {
            Statement stm = papyrusDB.getCon().createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM fournis");
            while (res.next()){
                Fournisseur f = new Fournisseur(
                        res.getInt("numfou"),
                        res.getString("nomfou"));
                list.add(f);
            }
            stm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
