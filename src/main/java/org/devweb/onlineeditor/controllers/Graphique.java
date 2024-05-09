package org.devweb.onlineeditor.controllers;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

@ServerEndpoint("/echo")
public class Graphique {
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();
    public static  void send(int valeur){
        String message = String.valueOf(valeur);
        try {
            for( Session session: queue) {
                session.getBasicRemote().sendText(message);
                System.out.println("envoie : "+ valeur );
            }
        }catch (IOException e){}
    }

    @OnOpen
    public void open(Session session){
        queue.add(session);
    }

    @OnClose
    public void close(Session session){
        queue.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable t){
        queue.remove(  session);
    }

}
