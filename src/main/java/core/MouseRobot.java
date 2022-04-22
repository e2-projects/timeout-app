package main.java.core;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

public class MouseRobot extends Robot {

    private static final int ONE_MINUTE = 1000 * 60;
    private boolean isRunning = false;

    private CompletableFuture<Boolean> asyncMethod;

    public MouseRobot() throws AWTException {
        super();
    }

    public MouseRobot(GraphicsDevice screen) throws AWTException {
        super(screen);
    }

    public void start() {
        isRunning = true;
        asyncMethod = CompletableFuture.supplyAsync(() -> {
            var keyNumber = 0;
            while (isRunning) {
                var mousePointer = MouseInfo.getPointerInfo().getLocation();
                delay(ONE_MINUTE);
                if (isRunning) {
                    keyNumber++;
                    int x = mousePointer.x;
                    int y = mousePointer.y;
                    if (keyNumber % 2 == 0 ) {
                        x = x + 10;
                        y = y + 10;
                    } else {
                        x = x - 10;
                        y = y - 10;
                    }
                    mouseMove(x, y);
                }
            }
            return false;
        });
    }

    public void stop() {
        isRunning = false;
        asyncMethod.complete(true);
    }

}
