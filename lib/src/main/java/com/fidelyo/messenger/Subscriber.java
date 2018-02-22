package com.fidelyo.messenger;

import android.os.Handler;

import java.util.UUID;

/**
 * Created by bishoy on 2/22/18.
 */

public class Subscriber<T> {

    private final UUID uuid;
    private final String key;
    private final Handler handler;
    private Callback<T> callback = t -> {
    };

    public Subscriber(String key, Handler handler) {
        this.key = key;
        this.handler = handler;

        uuid = UUID.randomUUID();

    }

    public String getKey() {
        return key;
    }

    public void handle(Callback<T> callback) {
        this.callback = callback;
    }

    public void publish(Object o) {
        handler.post(() -> callback.onMessage((T) o));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber<?> that = (Subscriber<?>) o;

        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
