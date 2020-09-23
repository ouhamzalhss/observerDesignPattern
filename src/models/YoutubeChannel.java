package models;

import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */

public class YoutubeChannel implements Subject {

    private String message;
    private List<Observer> observers;

    public YoutubeChannel() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(observer == null ) throw new NullPointerException("Object null");

        if(!this.observers.contains(observer))
            this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message){
        System.out.println("Massage posted to my youtube channel:  "+ message);
        this.message = message;
        this.notifyObservers();
    }
}
