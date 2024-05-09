package org.devweb.onlineeditor.controllers;

import java.util.Random;
import java.util.logging.Logger;

public class ValeursBean {
    private static final Logger logger = Logger.getLogger(ValeursBean.class.getName());

    public void timout(){
        int random_int = (int)Math.floor(Math.random() * (100 + 1));

        Graphique.send(random_int);
    }
}
