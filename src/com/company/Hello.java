package com.company;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by jangdoohwan on 2017. 1. 20..
 */
public class Hello extends UntypedActor {

    ActorRef world = getContext().actorOf(Props.create(World.class));


    @Override
    public void onReceive(Object message) throws Throwable {
        if (message == "make-hello-world") {
            String hello = makeHello();
            world.tell(hello, getSelf());
        } else {
            unhandled(message);
        }
    }

    public String makeHello() {
        return "hello";
    }

}
