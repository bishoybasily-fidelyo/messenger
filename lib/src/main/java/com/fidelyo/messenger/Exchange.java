package com.fidelyo.messenger;

/**
 * Created by bishoy on 2/22/18.
 */

public class Exchange {

    private final Matcher matcher = new Matcher();

    public void register(Subscriber subscriber) {
        matcher.add(subscriber);
    }

    public void publish(Object object, String key) {

        matcher.publish(key).forEach(subscriber -> subscriber.publish(object));

    }


    public void unregister(Subscriber subscriber) {
        matcher.remove(subscriber);
    }

}
