package baseball.version2;

import baseball.version2.controller.Controller;

public class Game {

    private final Controller controller;

    public Game() {
        this.controller = new Controller();
    }

    public void run(){
        int continueDecision = 1;
        while (continueDecision==1){
            controller.settingGame();
            boolean isCorrect = false;
            while(!isCorrect){
                isCorrect=controller.startGame();
            }
            continueDecision=controller.isContinue();
        }
    }
}
