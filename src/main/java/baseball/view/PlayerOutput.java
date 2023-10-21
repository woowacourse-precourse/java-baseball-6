package baseball.view;

import baseball.GameJudge;
import baseball.ValidateNumbers;

public class PlayerOutput {
    static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    static final String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_CHOICE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String NUM_INPUT_MSG = "숫자를 입력해주세요 : ";

    public static void gameStartMsg() {
        System.out.println(GAME_START_MSG);
    }
    public static void gameFinishMsg() {
        System.out.println(GAME_FINISH_MSG);
    }
    public static void restartMsg() {
        System.out.println(RESTART_CHOICE_MSG);
    }
    public static void numInputMsg() {
        System.out.print(NUM_INPUT_MSG);
    }
    public static void gameResult(ValidateNumbers computer, ValidateNumbers player) {
        System.out.println(GameJudge.getResult(computer, player));
    }
}