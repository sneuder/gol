package com.gol;

import com.gol.globalException.GlobalException;
import com.gol.gol.GOL;
import com.gol.params.Params;

public class App {
    
    public static void main(String[] args) {
        Params params = new Params();

        try {
            params.setParamFromArgs( new String[]{"10", "6", "10", "1000", "(2,2)(2,3)(2,4)"} );
        } catch(GlobalException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        
        GOL gol = new GOL(params);
        gol.liveGenerations();
    }
}