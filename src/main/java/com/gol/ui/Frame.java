package com.gol.ui;

import javax.swing.JFrame;

public class Frame {
    private JFrame frame = new JFrame();
    
    public Frame(Integer width, Integer height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setVisible() {
        frame.setVisible(true);
    }
}
