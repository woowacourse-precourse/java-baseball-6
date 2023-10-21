package baseball.view;

import static baseball.Constants.END_WANT;
import static baseball.Constants.PLAY_WANT;

public class AskView {

    public static void printAskNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printAskResume() {
        System.out.println("게임을 새로 시작하려면 " + PLAY_WANT + ", 종료하려면 " + END_WANT + "를 입력하세요.");
    }
}
