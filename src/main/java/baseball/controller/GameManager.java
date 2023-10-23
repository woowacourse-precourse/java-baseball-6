package baseball.controller;

import baseball.domain.BaseBalls;
import baseball.domain.ReGameCommand;
import baseball.domain.RoundResult;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private BaseBalls answers;

    public GameManager(){
    }

    public void play(){
        GameView.printStartMessage();
        do {
            createAnswers();
            round();
            GameView.printReGameMessage();
        } while(new ReGameCommand(Console.readLine()).equals(new ReGameCommand(ReGameCommand.RESTART)));
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
        GameView.printWinMessage();
    }
}
