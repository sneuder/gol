package com.gol;

import javax.swing.*;
import com.gol.gol.Window;

public class App {
    public static void main(String[] args) {
        // Params params = new Params(6, 6, 5, new int[]{6, 7, 8});
        // GOL gol = new GOL(params);
        // gol.liveGenerations();

        setUpWindow();
    }

    public static void setUpWindow() {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();
            JFrame frame = window.getFrame();
            frame.setVisible(true);
        });
    } 
}