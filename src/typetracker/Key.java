package typetracker;

import java.time.LocalDateTime;


public class Key<T> {
    private T key;
    LocalDateTime timeOfKeyPress;

    public Key(T keyPressed){
        key = keyPressed;
        timeOfKeyPress = LocalDateTime.now();
    }

    public T getKey() {
        return key;
    }

    public LocalDateTime getTimeOfKeyPress() {
        return timeOfKeyPress;
    }
}
