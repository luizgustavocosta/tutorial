package com.guga.behavioral.observer;

public interface Subject extends CustomObserver {

    void attach(CustomObserver observer);
    void detach(CustomObserver observer);

}
