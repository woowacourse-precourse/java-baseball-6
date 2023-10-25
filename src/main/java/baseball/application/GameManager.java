package baseball.application;

import baseball.presentation.UserInput;

import java.util.List;

public class GameManager {
    Generator generator = new Generator();
    UserInput userInput = new UserInput();

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = generator.generateNumber();
        String userRequest = userInput.inputNumber();

        String judge = judge(computer, userRequest);
    }

    public String judge(List<Integer> computer, String userRequest) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            int answerDigit = computer.get(i);
            int userDigit = Character.getNumericValue(userRequest.charAt(i));

            if (answerDigit == userDigit) {
                strike++;
            } else if (computer.contains(userDigit)) {
                ball++;
            }
        }

        if (strike > 0 && ball > 0) {
            return strike + "스트라이크 " + ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }
}
