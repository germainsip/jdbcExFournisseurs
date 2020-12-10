package org.afpa.DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandeDAO {
    PapyrusDB papyrusDB = new PapyrusDB();

    public CommandeDAO() throws SQLException {
    }

    public List<Commande> ListAll() throws SQLException {
        List<Commande> listeCommande = new ArrayList();


        try {
            Statement stm = papyrusDB.getCon().createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM entcom");
            while (res.next()) {
                Commande c = new Commande(res.getInt("numcom"),res.getString("obscom"), res.getString("datcom"),res.getInt("numfou"));

                listeCommande.add(c);

            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("c'est dans CommandeDAO que ça se passe!!!");
        }


        return listeCommande;
    }

    public List<Commande> listCommandeByFournisseur(int numfou){
        List<Commande> listeCommande = new ArrayList();
        try {
            PreparedStatement preparedStatement = papyrusDB.getCon().prepareStatement("SELECT*  FROM entcom WHERE numfou = ?");
            preparedStatement.setInt(1, numfou);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Commande c = new Commande(res.getInt("numcom"),res.getString("obscom"), res.getString("datcom"),res.getInt("numfou"));

                listeCommande.add(c);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listeCommande;
    }
}
