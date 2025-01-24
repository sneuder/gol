package com.gol;

import com.gol.gol.GOL;
import com.gol.gol.Params;

public class App {
    public static void main(String[] args) {
        Params params = new Params(6, 6, 3, new int[]{6, 7, 8});
        GOL gol = new GOL(params);
        gol.liveGenerations();
    }
}