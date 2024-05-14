package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.document;

public interface ICollaborationDAO {
    boolean ajouterCollaboration(document doc, int id);
}
