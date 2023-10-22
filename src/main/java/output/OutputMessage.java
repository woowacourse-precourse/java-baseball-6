package output;

import baseball.GameStatus;

public class OutputMessage {
    static final String START = "숫자 야구 게임을 시작합니다.";
    static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    static final String NOTHING = "낫싱";
    static final String BALL = "%d볼";
    static final String STRIKE = "%d스트라이크";
    static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    static final String CORRECT_AND_ASK_RESTART =
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료%n"
                    + "게임을 새로 시작하려면 "
                    + GameStatus.START
                    + ", 종료하려면 "
                    + GameStatus.GAME_OVER
                    + "를 입력하세요.";
}
