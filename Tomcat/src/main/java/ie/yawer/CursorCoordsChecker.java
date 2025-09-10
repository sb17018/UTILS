package ie.yawer;

import java.awt.*;

public class CursorCoordsChecker {

    // parameters of measuring cursor's location
    private final int MEASURED_PERIOD = 20000; // milliseconds
    private final int CONSECUTIVE_CHECKS = 5;

    // current mouse state
    static String isIdle;

    // stores collection of consecutive cursor's locations
    private final int[][] COORDS_IN_MEASURED_PERIOD = new int[CONSECUTIVE_CHECKS][2];

    void checkCoords() throws InterruptedException {

        int count = 0;

        while(true){

            // check cursor's current location
            if(count > COORDS_IN_MEASURED_PERIOD.length - 1) count = 0;
            int x = MouseInfo.getPointerInfo().getLocation().x;
            int y = MouseInfo.getPointerInfo().getLocation().y;
            COORDS_IN_MEASURED_PERIOD[count][0] = x;
            COORDS_IN_MEASURED_PERIOD[count++][1] = y;
            System.out.println(x + " " + y);

            // checks if all stored cursor's locations are the same
            for(int i = 1; i < COORDS_IN_MEASURED_PERIOD.length; i++){
                if(COORDS_IN_MEASURED_PERIOD[i][0] != COORDS_IN_MEASURED_PERIOD[i - 1][0] || COORDS_IN_MEASURED_PERIOD[i][1] != COORDS_IN_MEASURED_PERIOD[i - 1][1]) {
                    isIdle = "MOVING";
                    break;
                }
                isIdle = "IDLE";
            }
            Thread.sleep(MEASURED_PERIOD / CONSECUTIVE_CHECKS);
        }
    }
}
