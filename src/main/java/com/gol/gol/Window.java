package com.gol.gol;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.BiConsumer;

import com.gol.ui.Frame;

public class Window {
    private Frame baseFrame;
    private JFrame frame;
    private ArrayList<JButton> buttons = new ArrayList<JButton>(); //

    public Window(Integer rows, Integer columns) {
        this.baseFrame = new Frame(rows, rows);
        this.frame = this.baseFrame.getFrame();
        this.frame.setResizable(false);
    }

    public JFrame getFrame() {
        
        return this.frame;
    }

    public void setUpGrid(Integer rows, Integer columns, BiConsumer<Integer, CellState> buttonEvent) {
        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
       
        gbc.weightx = 0;
        gbc.weighty = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                JButton button = this.getButton(buttonEvent);

                gbc.gridx = col;
                gbc.gridy = row;

                this.buttons.add(button);
                this.frame.add(button, gbc);
            }
        }
        this.frame.pack();
    }

    public ArrayList<JButton> getButtons() {
        return this.buttons;
    }

    public JButton getButton(BiConsumer<Integer, CellState> buttonEvent) {
        JButton button = new JButton();

        button.setBackground(Color.BLACK);
        button.setPreferredSize(new Dimension(16, 16));
        button.setBorder(null);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addActionListener(e -> {
            Color color = button.getBackground().equals(Color.BLACK) ? Color.WHITE : Color.BLACK;
            this.changeButtonState(button, color);
            buttonEvent.accept(buttons.indexOf(button), CellState.ALIVE);
        });

        return button;
    }

    public void changeButtonState(JButton button, Color color) {
        button.setBackground(color);
    }


}
