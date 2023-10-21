package baseball;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String BLANK = " ";

    public void printStartMessage() {
        System.out.println(ProcessMessage.START);
    }

    public void newLine() {
        System.out.println();
    }

    public void printResult(GameResult gameResult) {
        if (gameResult.hasThreeStrike()) {
            printThreeStrikeResult(gameResult.getStrikeResult());
            return;
        }
        printBallAndStrikeResult(gameResult.getBallAndStrikeResult());
    }

    private void printThreeStrikeResult(Integer result) {
        System.out.println(result + CompareStatus.STRIKE.toString());
        System.out.println(ProcessMessage.THREE_STRIKE);
    }

    public void printBallAndStrikeResult(List<String> results) {
        results.forEach(s -> System.out.print(s + BLANK));
        newLine();
    }
}