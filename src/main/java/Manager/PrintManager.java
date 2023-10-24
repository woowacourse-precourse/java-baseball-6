package Manager;

import Enum.GameResult;
import Enum.Status;

/**
 * 콘솔 출력을 관리하는 클래스
 */
public class PrintManager {
    // 게임 안내 문구 출력
    public static void showStatus(Status status, boolean newLine) {
        String message = status.getMessage();
        if (newLine) {
            System.out.println(message);
            return;
        }
        System.out.print(message);
    }

    // 게임 결과(볼, 스트라이크 개수) 출력
    public static void showGameResult(int ball, int strike) {
        String result = GameResult.getMessage(ball, strike);
        System.out.println(result);
    }
}
