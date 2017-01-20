package com.company;

import akka.actor.UntypedActor;

/**
 * Created by jangdoohwan on 2017. 1. 20..
 */
public class Printer extends UntypedActor{
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            System.out.println(message);
        } else {
            unhandled(message);
        }
    }
}
