package baseball;

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
        printBallAndStrikeResult(gameResult.getBallAndStrikeResult());
    }

    public void printBallAndStrikeResult(List<String> results) {
        results.forEach(s -> System.out.print(s + BLANK));
        newLine();
    }

    public void printThreeStrike() {
        System.out.println(ProcessMessage.THREE_STRIKE);
    }
}