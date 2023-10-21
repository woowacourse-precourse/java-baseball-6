package baseball.controller;

import baseball.domain.BaseBalls;
import baseball.domain.NumberGenerator;
import baseball.view.GameView;

public class GameController {
    private BaseBalls answers;

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
        this.answers = BaseBalls.getBaseBallNumbers();
    }

    private void round(){
        // TODO : 라운드 수행
    }
}
