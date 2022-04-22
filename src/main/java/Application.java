package main.java;

import main.java.core.MouseRobot;
import main.java.ui.AppFrame;

public class Application {

    public static void main(String[] args) throws Exception {
        var window = new AppFrame();
        var robot = new MouseRobot();
        window.setVisible(true);

        window.getStartButton().addActionListener(event -> {
            robot.start();
            window.getStartButton().setEnabled(false);
            window.getStopButton().setEnabled(true);
            window.startTimer();
        });

        window.getStopButton().addActionListener(event -> {
            robot.stop();
            window.getStartButton().setEnabled(true);
            window.getStopButton().setEnabled(false);
            window.stopTimer();
        });
    }

}
