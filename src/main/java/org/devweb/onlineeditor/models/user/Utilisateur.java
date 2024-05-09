package org.devweb.onlineeditor.models.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    private int id;
    @Getter
    private String nom;
    private String prenom;
    private String mail;

    private String pseudo;
    private String pwd;
}
