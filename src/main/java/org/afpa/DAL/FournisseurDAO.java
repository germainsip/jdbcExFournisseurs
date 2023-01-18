package org.afpa.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDAO extends PapyrusDB implements DaoInterface<Fournisseur>{
   // PapyrusDB papyrusDB = new PapyrusDB();


    public FournisseurDAO() throws SQLException {

    }

    public List<Fournisseur> ListAllForBox(){
        List<Fournisseur> list = new ArrayList<>();
        try {
            Statement stm = getCon().createStatement();
            ResultSet res = stm.executeQuery("SELECT numfou,nomfou FROM fournis");
            while (res.next()){
                Fournisseur f = new Fournisseur(
                        res.getInt("numfou"),
                        res.getString("nomfou"));
                list.add(f);
            }
            stm.close();
            closeCon();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public Fournisseur find(int id) throws SQLException {
        Fournisseur fournisseur =null;

        try (PreparedStatement pstm = getCon().prepareStatement("SELECT * FROM fournis WHERE numfou=?")) {
            pstm.setInt(1,id);
            ResultSet res = pstm.executeQuery();
            while (res.next()){
                fournisseur=new Fournisseur(
                        res.getInt("numfou"),
                        res.getString("nomfou"),
                        res.getString("ruefou"),
                        res.getString("posfou"),
                        res.getString("vilfou"),
                        res.getString("confou"),
                        res.getInt("satisf")
                        );
            }
        }

        return fournisseur;
    }

    @Override
    public List<Fournisseur> listAll() {
        return null;
    }

    @Override
    public Fournisseur searchById(int id) {
        return null;
    }

    @Override
    public Fournisseur save(Fournisseur obj) {
        return null;
    }

    @Override
    public void delete(Fournisseur obj) {

    }

    @Override
    public Fournisseur update(Fournisseur obj) {
        return null;
    }
}
