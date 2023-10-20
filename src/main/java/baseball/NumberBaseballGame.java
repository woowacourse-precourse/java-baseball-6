package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class NumberBaseballGame {
    private int strike;
    private int ball;

    public void start() {
        List<Integer> answer = NumberBaseballUtility.generateAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!isAnswer()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!NumberBaseballUtility.isValidInput(input)) {
                throw new IllegalArgumentException();
            }
            List<Integer> playerAnswer = NumberBaseballUtility.convertStringToNumberList(input);
            this.strike = NumberBaseballUtility.calculateStrike(answer, playerAnswer);
            this.ball = NumberBaseballUtility.calculateBall(answer, playerAnswer);
            NumberBaseballUtility.printGameResult(strike, ball);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isAnswer() {
        return (strike == 3);
    }
}
