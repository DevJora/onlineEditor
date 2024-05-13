package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.utilisateur;

import java.util.List;

public class UtilisateurDao implements IUtilisateurDAO {
    private DaoFactory df;
    UtilisateurDao(DaoFactory df){
        this.df = df;
    }

    @Override
    public utilisateur getUtilisateur() {
        return null;
    }

    @Override
    public List<utilisateur> getCollaborateur() {
        return null;
    }
}
