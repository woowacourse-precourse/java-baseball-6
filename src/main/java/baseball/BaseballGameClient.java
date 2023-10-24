package baseball;

import baseball.data.GameResult;

import java.util.List;

public class BaseballGameClient {

    private final User user = new User();
    private final Computer computer = new Computer();
    private final GameCalculator gameCalculator = new GameCalculator();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            play();
        } while (user.isWantRestart());
    }

    public void play() {
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getComputerNumbers();

        while (true) {
            user.askUserNumbers();
            List<Integer> userNumbers = user.getUserNumbers();

            GameResult gameResult = gameCalculator.calculateResult(computerNumbers, userNumbers);
            printGameResult(gameResult);

            if (gameResult.isGameEnd()) {
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printGameResult(GameResult gameResult) {
        StringBuilder gameResultMessage = new StringBuilder();

        if (gameResult.getBall() > 0) {
            gameResultMessage.append(gameResult.getBall()).append("볼 ");
        }

        if (gameResult.getStrike() > 0) {
            gameResultMessage.append(gameResult.getStrike()).append("스트라이크");
        }


        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            gameResultMessage.append("낫싱");
        }

        System.out.println(gameResultMessage.toString().trim());
    }
}
