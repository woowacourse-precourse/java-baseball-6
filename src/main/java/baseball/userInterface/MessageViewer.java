package baseball.userInterface;

import static baseball.utils.Constants.*;

/*
 화면 출력을 담당하는 클래스
 결과는 주어진 점수에 따라 다른 값을 출력한다.
 */

public class MessageViewer {
    public static void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputRequestMsg() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printResultMsg(int ballCount, int strikeCount) {
        StringBuilder resultMsg = new StringBuilder();

        if (ballCount == 0 && strikeCount == 0) {
            resultMsg.append("낫싱");
        } else if (ballCount > 0 && strikeCount > 0) {
            resultMsg.append(ballCount).append("볼 ")
                    .append(strikeCount).append("스트라이크");
        } else if (ballCount > 0) {
            resultMsg.append(ballCount).append("볼");
        } else if (strikeCount > 0) {
            resultMsg.append(strikeCount).append("스트라이크");
        }

        System.out.println(resultMsg);
    }

    public static void printGameEndMsg() {
        System.out.println(MAX_STRIKES + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartInputRequestMsg() {
        System.out.println("게임을 새로 시작하려면 " + WANNA_KEEP_PLAYING + ", 종료하려면 " + WANNA_END + "를 입력하세요.");
    }

}
