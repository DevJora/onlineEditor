package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.utilisateur;

import java.util.List;

public interface IUtilisateurDAO {
    utilisateur getUtilisateur();
    List<utilisateur> getCollaborateur();
}
