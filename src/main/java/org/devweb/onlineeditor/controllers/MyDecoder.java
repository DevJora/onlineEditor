package org.devweb.onlineeditor.controllers;

import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;
import org.devweb.onlineeditor.models.user.Utilisateur;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class MyDecoder implements Decoder.Text<Utilisateur> {
    @Override
    public Utilisateur decode(String message) throws DecodeException {
        Utilisateur resultat = null;
        JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
        String nom = jsonObject.getJsonString("nom").getString();
        String prenom = jsonObject.getJsonString("prenom").getString();
        String pseudo = jsonObject.getJsonString("pseudo").getString();
        String mail = jsonObject.getJsonString("mail").getString();
        resultat = new Utilisateur(0,nom, prenom, mail, pseudo, null);
        return resultat;
    }

    @Override
    public boolean willDecode(String message) {
        return message.startsWith("{");
    }

    @Override
    public void init(EndpointConfig config) {
        Text.super.init(config);
    }

    @Override
    public void destroy() {
        Text.super.destroy();
    }
}
