package org.afpa.DAL;

import java.util.List;

public interface DaoInterface<T> {

    /**
     * Méthode pour obtenir tous les éléments d'une table
     * @return liste des éléments de la table
     */
    public List<T> listAll();

    public T searchById(int id);

    public T save(T obj);

    public void delete(T obj);

    public T update(T obj);
}
