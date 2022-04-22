package main.java.ui;

import main.java.ui.elements.buttons.CloseButton;
import main.java.ui.elements.buttons.MinimizeButton;
import main.java.ui.elements.labels.TimerLabel;
import main.java.ui.styles.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class AppFrame extends JFrame {

    private TimerLabel timerLabel;
    private JButton startButton;
    private JButton stopButton;

    public AppFrame() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize(280, 160);
        setTitle("Time out");
        setLayout(null);
        getContentPane().setBackground(new Color(38, 38, 38));

        addTimer();
        addStartButton();
        addStopButton();
        addMinimizeButton();
        addCloseButton();

        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
    }

    public JButton getStartButton() {
        return Optional.ofNullable(startButton).orElseThrow();
    }

    public JButton getStopButton() {
        return Optional.ofNullable(stopButton).orElseThrow();
    }

    public void startTimer() {
        timerLabel.startTimer();
    }

    public void stopTimer() {
        timerLabel.stopTimer();
    }

    private void addStartButton() {
        startButton = new JButton("Start");
        startButton.setBounds(50, 100, 80, 30);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(38, 38, 38));
        startButton.setBorder(new RoundedBorder(10));
        startButton.setForeground(Color.WHITE);
        add(startButton);
    }

    private void addStopButton() {
        stopButton = new JButton("Stop");
        stopButton.setBounds(150, 100, 80, 30);
        stopButton.setEnabled(false);
        stopButton.setFocusable(false);
        stopButton.setBackground(new Color(38, 38, 38));
        stopButton.setBorder(new RoundedBorder(10));
        stopButton.setForeground(Color.WHITE);
        add(stopButton);
    }

    private void addCloseButton() {
        var closeButton = new CloseButton();
        closeButton.addActionListener(event -> {
            dispose();
            System.exit(0);
        });
        add(closeButton);
    }

    private void addMinimizeButton() {
        var minimizeButton = new MinimizeButton();
        minimizeButton.addActionListener(event -> setState(ICONIFIED));
        add(minimizeButton);
    }

    private void addTimer() {
        timerLabel = new TimerLabel();
        add(timerLabel);
    }

}
