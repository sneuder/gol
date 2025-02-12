package com.gol.gol;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;


import com.gol.ui.Frame;

public class Window {
    Frame baseFrame = new Frame(400, 400);
    JFrame frame = this.baseFrame.getFrame();
    

    public JFrame getFrame() {
        return this.frame;
    }

    public void setUpGrid(Integer rows, Integer columns) {
        this.frame.setLayout(new GridLayout(rows, columns, 0, 0));
    }

    public void setUpCells(Integer amountOfCells) {
        for (int i = 1; i <= amountOfCells; i++) {
            JButton button = new JButton();
            button.setBackground(Color.LIGHT_GRAY);
            frame.add(button);
        }
    }
}
