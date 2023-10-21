package baseball.controller;

import baseball.view.GameView;

public class GameController {

    public GameController(){
    }

    public void play(){
        GameView.printStartMessage();
        do {
            createAnswers();
            round();
        } while(true);
    }

    private void createAnswers(){
        // TODO : 정답 생성
    }

    private void round(){
        // TODO : 라운드 수행
    }
}
