package org.devweb.onlineeditor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class document implements Serializable {
    private int id;
    private int user_id;
    private String titre;
    private String contenu;
    private String code_collab;
    public document(String titre){
        this.titre = titre;
        this.contenu = "D:-<h1 contenteditable=\"true\">"+titre+"</h1>";
        this.code_collab = getRandomStr(10);
    }

    public static String getRandomStr(int n)
    {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder s = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(str.length() * Math.random());
            s.append(str.charAt(index));
        }
        return s.toString();
    }
}
