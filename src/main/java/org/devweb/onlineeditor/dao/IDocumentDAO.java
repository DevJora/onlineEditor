package org.devweb.onlineeditor.dao;
import org.devweb.onlineeditor.model.*;

import java.util.List;

public interface IDocumentDAO {
    boolean ajouter(document doc, int id);
    document modifier(document doc);
    boolean supprimer(int id);

    document getDocument(int d);
    document getDocumentByCode(String code);
    List<document> lister(int id);

    List<document> listerCollab(int id);
}
