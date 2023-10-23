package baseball.controller;

import baseball.model.InputNumber;

public class PrintController {
    private CountController countController = new CountController();
    private int strikeCount;
    private int ballCount;

    public String printCount(InputNumber inputNumber) {
        StringBuilder output = new StringBuilder();
        strikeCount = countController.getStrikeCount(inputNumber);;
        ballCount = countController.getBallCount(inputNumber);;

        if (ballCount != 0) {
            output.append(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            output.append(strikeCount + "스트라이크");
        }
        if (output.isEmpty()) {
            return "낫싱";
        }
        return output.toString();
    }

    public String printSuccess() {
        return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
}
