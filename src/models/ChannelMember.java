package models;

import interfaces.Observer;
import interfaces.Subject;

/**
 * @author Lhouceine OUHAMZA
 */

public class ChannelMember implements Observer {

    private String name;

    // referece to our Subject class
    private Subject channel;

    public ChannelMember(String name) {
        this.name = name;
    }

    @Override
    public void update() {
         String msg = (String) channel.getUpdate(this);
         if(msg == null) System.out.println(name + " No message for this channel!");
         else System.out.println(name + " Retrieving message: " + msg);
    }

    @Override
    public void setSubject(Subject subject) {
        this.channel = subject;
    }
}
