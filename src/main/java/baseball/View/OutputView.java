package baseball.View;

import java.util.List;

public class OutputView {
    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void showUserInputResult(List<Integer> compareResult) {
        String inputResult = "";
        if (compareResult.get(0) != 0) {
            inputResult += compareResult.get(0) + "볼 ";
        }
        if (compareResult.get(1) != 0) {
            inputResult += compareResult.get(1) + "스트라이크";
        }
        if (inputResult == "") {
            inputResult = "낫싱";
        }
        System.out.println(inputResult);
    }


}
