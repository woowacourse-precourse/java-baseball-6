package baseball;


import static baseball.GameController.LOGGERNAME;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class GameView {

    Logger log = Logger.getLogger(LOGGERNAME);

    private static GameView gameView;

    private GameView() {
    }

    public static GameView getInstance() {
        if (gameView == null) {
            gameView = new GameView();
        }
        return gameView;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String enterAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = Console.readLine();

        if (!answer.matches("[1-9]{3}") || hasDuplicate(answer)) {
            Console.close();
            throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 3개를 입력하여야 합니다.");
        }

        return answer;
    }

    public boolean hasDuplicate(String answer) {
        int number = Integer.parseInt(answer);
        int hundreds = number % 100;
        int tens = (number / 100) % 10;
        int unit = number % 10;
        return hundreds == tens || hundreds == unit || tens == unit;
    }

    public void markAnswer(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크").append(" ");
        }
        if (strike == 3) {
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString().strip());
    }

    public int selectMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!("1".equals(input) || "2".equals(input))) {
            Console.close();
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        return Integer.parseInt(input);
    }

}
