package com.gol;

import com.gol.globalException.GlobalException;
import com.gol.gol.GOL;
import com.gol.params.Params;

public class App {
    public static void main(String[] args) {
        try {
            Params params = new Params();
            params.setParamFromArgs(args);
            GOL gol = new GOL(params);
            gol.liveGenerations();
        } catch(GlobalException exception) {
            System.out.println(exception.getMessage());
            return;
        } catch(InterruptedException exception) {
            System.out.println(exception.getMessage());
            return;
        }
    }
}