package baseball.manager;

import baseball.domain.BaseBalls;
import baseball.domain.ReGameCommand;
import baseball.domain.RoundResult;
import baseball.printer.GamePrinter;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private BaseBalls answers;

    public GameManager() {
    }

    public void play() {
        GamePrinter.printStartMessage();
        do {
            createAnswers();
            round();
            GamePrinter.printReGameMessage();
        } while (new ReGameCommand(Console.readLine()).equals(new ReGameCommand(ReGameCommand.RESTART)));
    }

    private void createAnswers() {
        this.answers = BaseBalls.getAnswerBaseBallNumbers();
    }

    private void round() {
        RoundResult roundResult = null;
        do {
            GamePrinter.printRequireNumberMessage();
            BaseBalls userNumbers = BaseBalls.getUserBaseBallNumbers(Console.readLine());
            int strikeCount = answers.getStrikeCounts(userNumbers);
            int ballCount = answers.getBallCounts(userNumbers);
            roundResult = new RoundResult(strikeCount, ballCount);
            GamePrinter.printRoundResult(roundResult);
        } while (!roundResult.isWin());
        GamePrinter.printWinMessage();
    }
}
