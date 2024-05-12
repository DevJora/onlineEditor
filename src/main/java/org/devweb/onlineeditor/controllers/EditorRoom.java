package org.devweb.onlineeditor.controllers;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;

@ServerEndpoint(
        value = "/editor",
       // encoders = MyEncoder.class,
        decoders = MyDecoder.class
)
public class EditorRoom {
    String contenuDocument = "D:-<h1 contenteditable=\"true\">Titre du document</h1>";
    private static final Set<Session> sessionActives = Collections.synchronizedSet(new HashSet<Session>());

    //
    private void avertir(Boolean connected, Session session){
        List<String> ListSession = new ArrayList<>();
        ListSession.add("liste des session actuelles:");
        System.out.println("Avertissement d'une session.");
        try  {
            for(Session sess: sessionActives) {
                if(connected){
                    String bienvenu = "C:-" + String.valueOf(session.getId()) + " vient de se connecter. Actuellement" + ( sessionActives.size() == 1? " une personne ": String.valueOf(sessionActives.size())+"personnes") + " dans le chat.";
                    if (session.isOpen()) sess.getBasicRemote().sendText(bienvenu);
                    ListSession.add(String.valueOf(session.getId()));
                }else {
                    sess.getBasicRemote().sendText(session.getId()+ " s'est déconnecté.");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @OnOpen
    public void onOpen(Session session, @PathParam(value="page") String page){
        //document
        session.getAsyncRemote().sendText(contenuDocument);
        //dee
        sessionActives.add(session);
        System.out.println("Ouverture de la session");
        this.avertir(true,session);
    }
    @OnMessage
    public void onMessage(String messageRecu, Session session){
        if(messageRecu.contains("C:-")){
            for(Session ses : sessionActives)
            {
                if(ses != session) ses.getAsyncRemote().sendText(messageRecu);
            }
        }else if(messageRecu.contains("D:-")){
            contenuDocument = messageRecu;
            for(Session ses : sessionActives)
            {
                if(ses != session) ses.getAsyncRemote().sendText(contenuDocument);
            }
        }


    }

    @OnClose
    public void onClose(Session session){
        sessionActives.remove(session);
        System.out.println("Fermeture de la session");
        this.avertir(false ,session);
    }

    @OnError
    public void onError(Throwable t, Session session){
    }
}
