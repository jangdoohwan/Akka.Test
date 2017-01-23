package com.company.http;

import akka.actor.*;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.ActorMaterializerSettings;
import akka.stream.Materializer;
import com.company.Hello;
import com.company.util.ActorSysContainer;
import scala.concurrent.duration.Duration;
import scala.concurrent.java8.FuturesConvertersImpl;

import java.util.concurrent.CompletionStage;

/**
 * Created by icent on 2017. 1. 23..
 */
public class ClientSingleRequestExample {

    public static void main(String[] args) throws InterruptedException {
//        final ActorSystem system = ActorSystem.create("MySystem1");
//        final Materializer materializer = ActorMaterializer.create(system);

        ActorSystem system = ActorSysContainer.getInstance().getSystem();

//        CompletionStage<HttpResponse> responseFuture =
//                Http.get(system)
//                        .singleRequest(HttpRequest.create("http://172.16.110.200"), materializer);
//
//
//        System.out.println(((FuturesConvertersImpl.CF) responseFuture).get().toString());
//
//        System.out.println(((FuturesConvertersImpl.CF) responseFuture).getNumberOfDependents());


        ActorRef hello = system.actorOf(Props.create(MyRecvTimeOutAcor.class));

        hello.tell("Hello", null);

        Thread.sleep(1);

        system.shutdown();
    }

}

class MyRecvTimeOutAcor extends UntypedActor {

    public MyRecvTimeOutAcor() {

        // To set an initial delay
//        getContext().setReceiveTimeout(Duration.create("5 seconds"));
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message.equals("Hello")) {

            ActorSystem system = ActorSysContainer.getInstance().getSystem();
            HttpRequest complexRequest = HttpRequest.GET("http://172.16.110.200:8800");


            // To set in a response to a message
//            getContext().setReceiveTimeout(Duration.create("10 seconds"));
//            getSender().tell("Hello world", getSelf());

            System.out.println("");
        } else if (message == ReceiveTimeout.getInstance()) {
            // To turn it off
            getContext().setReceiveTimeout(Duration.Undefined());
            throw new RuntimeException("received timeout");
        } else {
            unhandled(message);
        }
    }
}
