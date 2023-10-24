package baseball;

import baseball.data.GameResult;

import java.util.LinkedList;
import java.util.List;

public class BaseballGameClient {

    private final User user = new User();
    private final Computer computer = new Computer();
    private final GameCalculator gameCalculator = new GameCalculator();

    public void play() {

        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getComputerNumbers();

        user.askUserNumbers();
        List<Integer> userNumbers = user.getUserNumbers();

        GameResult gameResult = gameCalculator.calculateResult(computerNumbers, userNumbers);
        printGameResult(gameResult);

    }

    private void printGameResult(GameResult gameResult) {
        StringBuilder gameResultMessage = new StringBuilder();

        if (gameResult.getStrike() > 0) {
            gameResultMessage.append(gameResult.getStrike()).append("스트라이크 ");
        }

        if (gameResult.getBall() > 0) {
            gameResultMessage.append(gameResult.getBall()).append("볼");
        }

        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            gameResultMessage.append("낫싱");
        }

        System.out.println(gameResultMessage.toString().trim());
    }
}
