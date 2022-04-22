package main.java.ui.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class MinimizeButton extends JButton {

    public MinimizeButton() {
        initButton();
    }

    public MinimizeButton(Icon icon) {
        super(icon);
        initButton();
    }

    public MinimizeButton(String text) {
        super(text);
        initButton();
    }

    public MinimizeButton(Action a) {
        super(a);
        initButton();
    }

    public MinimizeButton(String text, Icon icon) {
        super(text, icon);
        initButton();
    }

    private void initButton() {
        setText("_");
        setBounds(200, 0, 30, 30);
        setFocusable(false);
        setBackground(new Color(38, 38, 38));
        setBorder(null);
        setForeground(Color.GRAY);
    }
}
