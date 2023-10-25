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

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
