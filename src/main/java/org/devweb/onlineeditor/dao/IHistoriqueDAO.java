package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.*;

import java.util.List;

public interface IHistoriqueDAO {
    boolean ajouterHistorique(document doc, int id);
    List<historique> afficherHistorique(document doc, utilisateur user);

    historique getHistorique(String date, utilisateur user);
}