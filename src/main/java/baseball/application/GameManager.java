package baseball.application;

import baseball.presentation.UserInput;
import baseball.presentation.UserOutput;

import java.util.List;

public class GameManager {
    Generator generator = new Generator();
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = generator.generateNumber();
        String userRequest = userInput.inputNumber();

        judge(computer, userRequest);
    }

    public void judge(List<Integer> computer, String userRequest) {
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

        boolean result = userOutput.outputMessage(strike, ball);
    }
}
