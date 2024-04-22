package org.devweb.onlineeditor;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value = "/chatroom") // point de terminaison coté serveur
public class ChatRoom {

    private static Set<Session> sessions  = Collections.synchronizedSet(new HashSet<Session>());

    private void avertir(){
        String ListSession = "liste des session actuelles: ";
        try  {
            for(Session session: sessions) {
                System.out.println("Avertissement d'une session.");
                String bienvenu = String.valueOf(session.getId()) + " vient de se connecter. Actuellement" + ( sessions.size() == 1? "une personne": String.valueOf(sessions.size())+"personnes") + " dans le chat.";
                if (session.isOpen()) session.getBasicRemote().sendText(bienvenu);
                ListSession += String.valueOf(session.getId()) + ", ";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @OnOpen
    public void onOpen(Session session){
        sessions.add(session);
        System.out.println("ouverture de la session "+ session.getId());
        this.avertir();
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("le message recu de " + session.getId() + " : "+ message);
        try {
            session.getBasicRemote().sendText(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
        System.out.println("fermeture de la session "+ session.getId());
        this.avertir();
    }

    @OnError
    public void onError(Throwable t, Session session){

    }

}
