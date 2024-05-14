package org.devweb.onlineeditor.controllers;
import jakarta.servlet.http.HttpSession;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.model.*;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;

@ServerEndpoint(
        value = "/editor",
        configurator = EditorRoomConfig.class

)
public class EditorRoom {
    DaoFactory df = DaoFactory.getInstance();
    DocumentDAO documentDAO = df.getDocumentDAO();

    document document = null;
    utilisateur utilisateur = null;

    String contenuDocument = "D:-<h1 contenteditable=\"true\">Titre du document</h1>";
    private static final Set<Session> sessionActives = Collections.synchronizedSet(new HashSet<Session>());


    private void avertir(Boolean connected, Session session, utilisateur utilisateur){
        List<String> ListSession = new ArrayList<>();
        ListSession.add("liste des session actuelles:");
        System.out.println("Avertissement d'une session.");
        try  {
            for(Session sess: sessionActives) {
                if(connected){
                    String bienvenu = "C:-" + utilisateur.getPseudo() + " vient de se connecter. Actuellement" + ( sessionActives.size() == 1? " une personne ": String.valueOf(sessionActives.size())+"personnes") + " dans le chat.";
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
        // Récupérer la session HTTP
        HttpSession httpSession = (HttpSession) session.getUserProperties().get(HttpSession.class.getName());

        document = (document) httpSession.getAttribute("document");
        utilisateur = (utilisateur) httpSession.getAttribute("utilisateur");


        System.out.println("document "+ document.getTitre() + " de " + utilisateur.getPseudo());
        contenuDocument = document.getContenu();
        //document
        session.getAsyncRemote().sendText(contenuDocument);
        //dee
        sessionActives.add(session);
        System.out.println("Ouverture de la session");
        this.avertir(true,session, utilisateur);
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
            document.setContenu(contenuDocument);
            document = documentDAO.modifier(document);
            for(Session ses : sessionActives)
            {
                if(ses != session) ses.getAsyncRemote().sendText(messageRecu);
            }
        }
    }

    @OnClose
    public void onClose(Session session){
        sessionActives.remove(session);
        System.out.println("Fermeture de la session");
        this.avertir(false ,session, utilisateur);
    }

    @OnError
    public void onError(Throwable t, Session session){
    }
}
