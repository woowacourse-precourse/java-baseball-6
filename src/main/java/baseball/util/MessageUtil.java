package baseball.util;

import static baseball.constant.MessageConst.*;

/**
 * 메시지 출력 관리 클래스
 */
public class MessageUtil {

    /**
     * 게임 시작 전 출력 메시지
     */
    public void printInitMessage() {

        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 숫자 입력 메시지
     */
    public void printInputMessage() {

        System.out.println(INPUT_MESSAGE);
    }

    /**
     * 결과에 대한 메시지
     */
    public void printResultMessage(int strike, int ball) {

        StringBuilder result = new StringBuilder();

        if (strike == 0 && ball == 0) {

            System.out.println(NOTHING);
            return;
        }

        if (ball != 0) {
            result.append(ball).append(BALL).append(" ");
        }

        if (strike != 0) {
            result.append(strike).append(STRIKE);
        }

        System.out.println(result.toString());
    }

    /**
     * 성공 메시지
     */
    public void printSuccessMessage(){

        System.out.println(SUCCESS_MESSAGE);
        System.out.println(GAME_CONTROL_MESSAGE);
    }
}
