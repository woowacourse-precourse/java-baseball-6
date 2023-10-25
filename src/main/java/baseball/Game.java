package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int COMPUTER_DIGIT = 3;
    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";

    private static final String WELCOME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String CONTINUE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = COMPUTER_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHECK_RESTART_MESSAGE =
            "게임을 새로 시작하려면 " + RESTART_GAME + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.";
    private static final String NONE_MESSAGE = "낫싱";

    private static List<Integer> computerAnswer;
    private static List<Integer> userAnswer;

    public Game() {
    }

    public static void setComputerAnswer(List<Integer> computerAnswer) {
        Game.computerAnswer = computerAnswer;
    }

    public static List<Integer> getComputerAnswer() {
        return computerAnswer;
    }


    /* 서로 다른 3자리 난수 생성*/
    private static List<Integer> createRandomNum(int digit) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
