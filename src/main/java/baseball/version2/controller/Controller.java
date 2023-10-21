package baseball.version2.controller;


import static baseball.Constants.CONTINUE_NUMBER;
import static baseball.Constants.STOP_NUMBER;

import baseball.version2.service.Service;
import java.util.ArrayList;

public class Controller {

    private final Service service;
    public Controller() {
        this.service = new Service();
    }

    public void run() {  // 게임 실행

        int continueDecision = 1;
        while (continueDecision==CONTINUE_NUMBER){
            settingGame();
            boolean threeStrike =false;
            while (!threeStrike) {
                startGame();
                threeStrike = checkStrike();
                initScore();
            }
            if(isNotContinue())
                continueDecision=STOP_NUMBER;
        }
    }

    private void initScore() {
        service.initScoreRepository();
    }

    private void settingGame() {
        ArrayList<Integer> computerAnswer = service.getComputerAnswer();
        service.saveComputerAnswer(computerAnswer);
    }

    private void startGame() {
        int[] playerAnswer = service.getPlayerAnswer();
        service.compareTwoAnswer(playerAnswer);
        service.printResult();
    }

    public boolean checkStrike(){
        if(service.getStrike()==3)
            return true;
        return false;
    }

    private boolean isNotContinue() {
        int playerDecision = service.getPlayerDecision();
        if (playerDecision==STOP_NUMBER){
            return true;
        }
        return false;
    }

}
