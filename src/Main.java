import interfaces.Observer;
import models.YoutubeChannel;
import models.ChannelMember;

/**
 * @author Lhouceine OUHAMZA
 */

public class Main {
    public static void main(String[] args){

        YoutubeChannel myChannel = new YoutubeChannel();

        //create observers
        Observer observer1 = new ChannelMember("Member 1");
        Observer observer2 = new ChannelMember("Member 2");
        Observer observer3 = new ChannelMember("Member 3");

        // Register them...
        myChannel.register(observer1);
        myChannel.register(observer2);
        myChannel.register(observer3);
        // Attaching observers to subject...
        observer1.setSubject(myChannel);
        observer2.setSubject(myChannel);
        observer3.setSubject(myChannel);

        //check for update...
        observer1.update();

        // Brodcasting
        myChannel.postMessage("Hello subscribers!");

        // Unsubscribe member
        myChannel.unregister(observer2);

        // Brodcasting
        myChannel.postMessage("Again, Hello subscribers!");






    }
}
