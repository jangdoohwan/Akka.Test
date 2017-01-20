package com.company;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by jangdoohwan on 2017. 1. 20..
 */
public class World extends UntypedActor {

    ActorRef printer = getContext().actorOf(Props.create(Printer.class));

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            String hello = (String) message;
            String world = makeWorld();
            String result = makeHelloWorld(hello, world);
            printer.tell(result, getSelf());
        } else {
            unhandled(message);
        }
    }

    public String makeWorld() {
        return "world";
    }

    String makeHelloWorld(String hello, String world) {
        return hello + " " + world;
    }
}
