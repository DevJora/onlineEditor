package org.devweb.onlineeditor.controllers;

import org.devweb.onlineeditor.model.utilisateur;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.io.StringWriter;

public class MyEncoder implements Encoder.Text<utilisateur> {
    @Override
    public String encode(utilisateur utilisateur) throws EncodeException {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = Json.createGenerator(writer);
        generator.writeStartObject()
                .write("nom", utilisateur.getNom())
                .write("prenom", utilisateur.getPrenom())
                .write("pseudo", utilisateur.getPseudo())
                .write("mail", utilisateur.getMail())
                .writeEnd();
        generator.close();
        return writer.toString();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
