package main.java.ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

public class AppWindow extends Frame {

    private Button startButton;
    private Button stopButton;

    public AppWindow() {
        setSize(280, 200);
        setTitle("Time out");
        setLayout(null);

        addStartButton();
        addStopButton();
        addCloseButton();
        setLocationRelativeTo(null);
    }

    public Button getStartButton() {
        return Optional.ofNullable(startButton).orElseThrow();
    }

    public Button getStopButton() {
        return Optional.ofNullable(stopButton).orElseThrow();
    }

    private void addStartButton() {
        startButton = new Button("Start");
        startButton.setBounds(50, 100, 80, 30);
        add(startButton);
    }// 50 ___80 20 ___80 50

    private void addStopButton() {
        stopButton = new Button("Stop");
        stopButton.setBounds(150, 100, 80, 30);
        stopButton.setEnabled(false);

        add(stopButton);
    }

    private void addCloseButton() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
