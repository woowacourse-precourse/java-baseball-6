package baseball.game;

import baseball.io.ConsoleInputReader;
import baseball.io.GameMessageOutput;
import baseball.user.UserNumber;
import java.util.Objects;

public class Game {

    public void start() {
        GameMessageOutput.printGameStartMessage();

        boolean gameOn = true;
        while (gameOn) {
            GameNumber gameNumber = GameNumber.of(); // 1. 생성된 랜덤 숫자

            while (true) {
                UserNumber userNumber = UserNumber.of(); // 2. 사용자로부터 입력받은 숫자

                GameResult result = gameNumber.compare(userNumber); // 3. 숫자 비교
                result.print(); // 4. 결과 출력

                if (result.gameEnd()) { // 5. 게임이 종료되었는지 확인
                    gameOn = restart(); // 6. 게임 재시작 여부 확인
                    break;
                }
            }
        }
    }

    public static boolean restart() {
        GameMessageOutput.printGameRestartMessage();

        String userAnswer = ConsoleInputReader.read();

        if (userAnswer.length() != 1 || !Character.isDigit(userAnswer.charAt(0))) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }

        if (Objects.equals(userAnswer.charAt(0), GameConst.GAME_RESTART)) {
            return true;
        }

        if (Objects.equals(userAnswer.charAt(0), GameConst.GAME_END)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
