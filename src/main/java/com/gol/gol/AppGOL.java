package com.gol.gol;

import java.awt.Color;
import java.util.function.BiConsumer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class AppGOL {
    public Integer rows = 50;
    public Integer columns = 50;
    public Integer generations = 30;

    public Params params = new Params(rows, columns, generations, new int[]{266, 267, 268});
    public GOL gol = new GOL(params);

    public void start() {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window(this.rows, this.columns);
            JFrame frame = window.getFrame();
            
            BiConsumer<Integer, CellState> buttonEvent = this.gol::changeCellStateById;
            window.setUpGrid(rows, columns, buttonEvent);
            frame.setVisible(true);
    
            var grid = gol.getGrid();
            var buttons = window.getButtons();
    
            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < params.getGenerations(); i++) {
                        var copyGrid = grid.getCopyGrid();
                        gol.liveGeneration(copyGrid);
                        var originalGrid = grid.getGrid();
    
                        for (Integer key : originalGrid.keySet()) {
                            Cell cell = originalGrid.get(key);
                            Color color = cell.isAlive() ? Color.WHITE : Color.BLACK;
                            SwingUtilities.invokeLater(() -> window.changeButtonState(buttons.get(key), color));
                        }

                        Thread.sleep(500);
                    }
                    return null;
                }
            }.execute();
        });
    }
    
}
