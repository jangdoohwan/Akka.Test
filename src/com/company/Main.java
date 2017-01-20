package com.company;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = ActorSystem.create();
        ActorRef hello = system.actorOf(Props.create(Hello.class));
        hello.tell("make-hello-world", null);
        hello.tell("make-hello-world", null);
        hello.tell("make-hello-world", null);
        hello.tell("make-hello-world", null);
        Thread.sleep(1);
        system.shutdown();
    }
}
