package baseball;

import java.util.ArrayList;

public class BaseballGame {
    final int STRIKE = 0;
    final int BALL = 1;


    public void startGame() {
        Model baseballModel = new Model();
        View baseballView = new View();
        baseballModel.initComputerAnswer();
        baseballView.outputGameStart();

        String answerPlayer;
        boolean isPlaying=true;
        Integer[] score;

        do {
            answerPlayer = baseballView.inputPlayerAnswer();
            baseballModel.validateCheckInputAnswer(answerPlayer);


            score = baseballModel.countStrikeBallHits(answerPlayer);
            baseballView.outputGameScore(score[STRIKE], score[BALL]);


            //answer player
            if (score[STRIKE] == 3) {
                String playerInput = baseballView.inputPlayerRestart();
                baseballModel.validateCheckInputRestart(playerInput);
                isPlaying = baseballModel.restartGame(playerInput);
            }


        } while (isPlaying);
    }



}