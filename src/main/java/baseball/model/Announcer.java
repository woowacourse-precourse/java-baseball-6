package baseball.model;

import baseball.Result;

import static baseball.Printer.*;

public class Announcer {
    private static final String START_GAME_COMMENT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_COMMENT = "숫자를 입력해주세요 : ";
    private static final String END_GAME_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void announceStartGame() {
        print(START_GAME_COMMENT);
    }

    public void announceToSpeakNumber() {
        print(INPUT_NUMBER_COMMENT);
    }
    public void announceResult(Result result) {
        printRoundResult(result);
    }

    public void announceGameOver() {
        println(END_GAME_COMMENT);
    }

    public void announceToSpeakRestart() {
        println(RESTART_GAME_COMMENT);
    }
}
