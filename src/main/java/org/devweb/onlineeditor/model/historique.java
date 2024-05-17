package org.devweb.onlineeditor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class historique {
    private int id;
    private document document;
    private utilisateur utilisateur;
    private String contenu_document;
    private String date;
}