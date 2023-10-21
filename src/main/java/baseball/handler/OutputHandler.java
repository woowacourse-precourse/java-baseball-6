package baseball.handler;

import baseball.calculator.ResultCalculator;

public class OutputHandler {

    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputRequestMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public boolean printResultMessage(String userInput, String computerNumber) {
        String result = resultCalculator.calculateResult(userInput, computerNumber);
        System.out.println(result);

        return result.contains("3개의 숫자를 모두 맞히셨습니다!");
    }

    public void printAskGameRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
