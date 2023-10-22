package baseball.controller;

import baseball.domain.BaseBalls;
import baseball.domain.NumberGenerator;
import baseball.domain.RoundResult;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

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
        this.answers = BaseBalls.getAnswerBaseBallNumbers();
    }

    private void round(){
        RoundResult roundResult = null;
        do {
            GameView.printRequireNumberMessage();
            BaseBalls userNumbers = BaseBalls.getUserBaseBallNumbers(Console.readLine());
            // TODO : 게임 진행(스트라이크, 볼 계산. 즉, 정답과 사용자 입력을 비교하는 로직), 결과 출력 등
        } while(true);
    }
}
