package ie.yawer;

import org.apache.catalina.LifecycleException;

public class App {

    public static void main(String[] args) throws InterruptedException {

        new EmbeddedTomcat().start();

        new CursorCoordsChecker().checkCoords();
    }
}

