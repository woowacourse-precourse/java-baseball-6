package baseball.application;

import baseball.presentation.UserInput;
import baseball.presentation.UserOutput;

import java.util.List;

public class GameManager {
    private final Generator generator;
    private final UserInput userInput;
    private final UserOutput userOutput;

    public GameManager(Generator generator, UserInput userInput, UserOutput userOutput) {
        this.generator = generator;
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = generator.generateNumber();
        play(computer);
    }

    private void play(List<Integer> computer) {
        String userRequest = userInput.inputNumber();
        int strikeCount = judge(computer, userRequest);
        restart(strikeCount, computer);
    }

    public int judge(List<Integer> computer, String userRequest) {
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

        userOutput.printBallCount(strike, ball);
        return strike;
    }

    private void restart(int strike, List<Integer> computer) {
        if (strike != 3) {
            play(computer);
        } else {
            userOutput.endingMessage();
            String restartNumber = userInput.inputRestartNumber();
            if (restartNumber.equals("1")) {
                run();
            }
        }
    }
}
