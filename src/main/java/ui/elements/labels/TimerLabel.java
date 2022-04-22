package main.java.ui.elements.labels;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class TimerLabel extends JLabel {

    private Timer timer;
    private long startTimeInMillis = 0L;
    private static final String TIMER_TEMPLATE = "%02d:%02d:%02d";
    private static final String ZERO_TIME = String.format(TIMER_TEMPLATE, 0, 0, 0);

    public TimerLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        initTimer();
    }

    public TimerLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        initTimer();
    }

    public TimerLabel(String text) {
        super(text);
        initTimer();
    }

    public TimerLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        initTimer();
    }

    public TimerLabel(Icon image) {
        super(image);
        initTimer();
    }

    public TimerLabel() {
        initTimer();
    }

    public void startTimer() {
        startTimeInMillis = System.currentTimeMillis();
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
        setText(ZERO_TIME);
    }

    private void initTimer() {
        setFont(getFont().deriveFont(25f));
        setText(ZERO_TIME);
        setBounds(280 - 190, 50, 150, 30);
        setForeground(Color.WHITE);
        timer = new Timer(100, action -> {
            var runningTime = System.currentTimeMillis() - startTimeInMillis;
            var duration = Duration.ofMillis(runningTime);
            var hours = duration.toHours();
            duration = duration.minusHours(hours);
            var minutes = duration.toMinutes();
            duration = duration.minusMinutes(minutes);
            var millis = duration.toMillis();
            var seconds = millis / 1000;
            setText(String.format(TIMER_TEMPLATE, hours, minutes, seconds));
        });
    }
}
