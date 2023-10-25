package baseball.view;

import baseball.status.CompareStatus;
import baseball.message.ProcessMessage;
import baseball.domain.GameResult;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";

    public void printStartMessage() {
        System.out.println(ProcessMessage.START);
    }

    public void newLine() {
        System.out.println();
    }

    public void printResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            printNotingResult();
            return;
        }
        printBallAndStrikeResult(gameResult.getBallAndStrikeResult());
    }

    private void printNotingResult() {
        System.out.println(CompareStatus.NOTHING);
    }

    public void printBallAndStrikeResult(List<String> results) {
        results.forEach(s -> System.out.print(s + BLANK));
        newLine();
    }

    public void printThreeStrike() {
        System.out.println(ProcessMessage.THREE_STRIKE);
        printRestartOrExit();
    }

    public void printRestartOrExit() {
        System.out.println(ProcessMessage.RESTART_OR_EXIT);
    }

    public void printExit() {
        System.out.println(ProcessMessage.EXIT);
    }

    public void printInputNumberMessage() {
        System.out.print(ProcessMessage.INPUT_NUMBER);
    }
}