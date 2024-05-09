package org.devweb.onlineeditor.controllers;

import jakarta.websocket.*;
import jakarta.websocket.Decoder;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@ServerEndpoint(
        value = "/test"
        //decoders = MyDecoder.class,
        //encoders = MyEncoder.class
        )
public class test {

    private static final Logger LOGGER = Logger.getLogger(test.class.getName());
    private static final Set<Session> sessionActives = Collections.synchronizedSet(new HashSet<Session>());

    private test(){
        super();
        LOGGER.info("invocation du constructeur de l'endpoint test");
    }

    @OnOpen
    public void onOpen(Session session, @PathParam(value="page") String page){
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String text){
                try {
                    remote.sendText(new Date() + " endpoint Test: " + text);
                }catch (IOException e){
                    LOGGER.severe("Le msg ne peut pas être envoyé ");
                }
            }
        });
        sessionActives.add(session);
        System.out.println("Ouverture de la session");
    }
   /* @OnMessage
    public void onMessage(String messageRecu, Session session){
        System.out.println("le message recu: "+ messageRecu);

        for(Session ses : sessionActives)
        {
            if(ses != session) ses.getAsyncRemote().sendText(messageRecu);
        }

    }*/

    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        sessionActives.remove(session);
        System.out.println("Fermeture de la session pour : " + closeReason);
    }

    @OnError
    public void onError(Throwable t, Session session){
        t.printStackTrace();
    }
}
