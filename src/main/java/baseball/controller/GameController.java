package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.NumberList;
import baseball.utils.Convert;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {
    public void startGame() {
        Computer computer = new Computer();
        computer.setAnswer(createRandomTarget());
        while (true) {
            String usersGuessString = InputController.scanUsersGuess();
            NumberList userAnswer = Convert.stringToNumberList(usersGuessString);

            Hint hint = calculateHint(computer.getAnswer(), userAnswer);
            OutputView.printHintMessage(hint);
            if (computer.getAnswer().equals(userAnswer)) {
                OutputView.printSuccessAndEndMessage();
                break;
            }
        }
    }

    public NumberList createRandomTarget() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        return new NumberList(answerList);
    }

    private Hint calculateHint(NumberList answer, NumberList guess) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < answer.getNumberList().size(); i++) {
            for (int j = 0; j < guess.getNumberList().size(); j++) {
                if (Objects.equals(answer.getNumberList().get(i), guess.getNumberList().get(j))) {
                    if (i != j) {
                        ballCount++;
                    } else {
                        strikeCount++;
                    }
                }
            }
        }
        return new Hint(ballCount, strikeCount);
    }

    private static class InputController {
        private static final String WRONG_INPUT_ANSWER = "1~9 사이 수 3자리를 입력해주세요.";

        public static String scanUsersGuess() {
            InputView.printEnterNumbers();
            String userInput = Console.readLine();
            validateUsersGuess(userInput);
            return userInput;
        }

        private static void validateUsersGuess(String userInput) {
            boolean isValid = true;
            if (userInput.length() != 3) {
                isValid = false;
            }
            for (int i = 0; i < userInput.length(); i++) {
                int number = userInput.charAt(i) - '0';
                isValid &= (1 <= number && number <= 9);
            }
            if (!isValid) {
                throw new IllegalArgumentException("[ERROR] " + WRONG_INPUT_ANSWER);
            }
        }
    }
}
