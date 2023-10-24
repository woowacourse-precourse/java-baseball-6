package baseball.game;

import baseball.io.GameMessageOutput;
import baseball.user.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void start() {
        GameMessageOutput.printGameStartMessage();

        boolean gameOn = true;
        while (gameOn) {
            GameNumber gameNumber = GameNumber.of();

            while (true) {
                UserNumber userNumber = UserNumber.of();

                GameResult result = gameNumber.compare(userNumber);
                result.print();

                if (result.gameEnd()) {
                    gameOn = restart();
                    break;
                }
            }
        }
    }

    public static boolean restart() {
        GameMessageOutput.printGameRestartMessage();

        String answer = Console.readLine().strip();

        if (answer.length() != 1 || !Character.isDigit(answer.charAt(0))) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }

        if (answer.charAt(0) == '2') {
            return false;
        }

        if (answer.charAt(0) == '1') {
            return true;
        }

        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
