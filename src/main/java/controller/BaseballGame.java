package controller;

import static service.GameService.*;
import static service.PrintService.*;

public class BaseballGame {

    public static void run() {
        printStartApplication();

        do {
            playOneGame();
        } while(isRestart());

        printCloseApplication();
    }
}
