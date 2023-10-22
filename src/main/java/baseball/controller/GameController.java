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
            int strikeCount = answers.getStrikeCounts(userNumbers);
            int ballCount = answers.getBallCounts(userNumbers);
            roundResult = new RoundResult(strikeCount, ballCount);
            GameView.printRoundResult(roundResult);
        } while(!roundResult.isWin());
    }
}
