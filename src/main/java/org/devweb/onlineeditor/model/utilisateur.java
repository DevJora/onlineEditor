package org.devweb.onlineeditor.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class utilisateur implements Serializable {
    private int id;
    private String mail;
    private String pseudo;
    private String pwd;
}
