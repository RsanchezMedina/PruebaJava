package com.rsanchez.appareaseysjava.interfaces;

public interface BaseCallback {
    public interface OnSuccess<T> {
        void OnResponse(T response);
    }

    public interface OnError<E extends Throwable> {
        void OnError(Error error);
    }
}
