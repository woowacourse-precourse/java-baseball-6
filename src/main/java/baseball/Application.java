package baseball;

import baseball.game.GameNumber;
import baseball.game.GameResult;
import baseball.user.UserNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static boolean GAME_MODE = true;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (GAME_MODE) {
            GameNumber.generateNumbers();

            while (true) {
                List<Integer> userNumbers = UserNumber.readUserNumbers();

                GameResult result = GameNumber.compare(userNumbers);

                result.print();

                if (result.gameEnd()) {
                    GAME_MODE = restart();
                    break;
                }
            }
        }
    }

    private static boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String answer = Console.readLine();

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