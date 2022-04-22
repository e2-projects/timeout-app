package main.java.ui.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class CloseButton extends JButton {

    public CloseButton() {
        initButton();
    }

    public CloseButton(Icon icon) {
        super(icon);
        initButton();
    }

    public CloseButton(String text) {
        super(text);
        initButton();
    }

    public CloseButton(Action a) {
        super(a);
        initButton();
    }

    public CloseButton(String text, Icon icon) {
        super(text, icon);
        initButton();
    }

    private void initButton() {
        setText("x");
        setBounds(230, 5, 30, 30);
        setFocusable(false);
        setBackground(new Color(38, 38, 38));
        setBorder(null);
        setForeground(Color.GRAY);
    }
}
