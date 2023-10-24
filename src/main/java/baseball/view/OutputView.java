package baseball.view;

import baseball.model.Result;
import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printComputerNumber(List<Integer> computerNumber) {
        System.out.println(computerNumber);
    }

    public void printGameResult(Result result) {
        System.out.println(result.getFormattedResult());
    }

    public void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printExceptionMessage(Exception exception) {
        System.out.printf("[ERROR] %s", exception.getMessage());
    }
}