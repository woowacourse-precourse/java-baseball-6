package baseball;

import java.util.ArrayList;

public class BaseballGame {
    private String answerPlayer;
    private boolean isPlaying;
    final int STRIKE = 0;
    final int BALL = 1;


    public void startGame() {
        Model baseballModel = new Model();
        baseballModel.initComputerAnswer();
        View.outputGameStart();

        String answerPlayer;
        boolean isPlaying=true;
        Integer[] score;

        do {
            answerPlayer = View.inputPlayerAnswer();
            baseballModel.validateCheckInputAnswer(answerPlayer);


            score = baseballModel.countStrikeBallHits(answerPlayer);
            View.outputGameScore(score[STRIKE], score[BALL]);


            //answer player
            if (score[STRIKE] == 3) {
                String playerInput = View.inputPlayerRestart();
                baseballModel.validateCheckInputRestart(playerInput);
                isPlaying = baseballModel.restartGame(playerInput);
            }


        } while (isPlaying);
    }



}