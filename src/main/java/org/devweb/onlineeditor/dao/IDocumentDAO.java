package org.devweb.onlineeditor.dao;
import org.devweb.onlineeditor.model.*;

import java.util.List;

public interface IDocumentDAO {
    void ajouter(document doc);
    List<document> lister(int id);
}
