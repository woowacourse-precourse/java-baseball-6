package baseball.controller;

import static baseball.utils.Convert.booleanToInt;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.NumberList;
import baseball.model.User;
import baseball.utils.Convert;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    public void startGame() {
        Computer computer = new Computer();
        User user = new User();

        createRandomAnswer(computer);
        do {
            guessing(user);
            OutputView.printHintMessage(calculateHint(computer.getAnswer(), user.getGuess()));
        } while (!computer.getAnswer().equals(user.getGuess()));
        OutputView.printSuccessAndEndGameMessage();
    }

    private void guessing(User user) {
        String guessString = InputController.scanUsersGuess();
        NumberList guess = Convert.stringToNumberList(guessString);
        user.setGuess(guess);
    }

    public void createRandomAnswer(Computer computer) {
        List<Integer> answerList = new ArrayList<>() {{
            while (size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!contains(randomNumber)) {
                    add(randomNumber);
                }
            }
        }};
        computer.setAnswer(new NumberList(answerList));
    }

    private Hint calculateHint(NumberList answer, NumberList guess) {
        int ballCount = calculateBallCount(answer, guess);
        int strikeCount = calculateStrikeCount(answer, guess);
        return new Hint(ballCount, strikeCount);
    }

    private int calculateBallCount(NumberList answer, NumberList guess) {
        int ballCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; i != j && j < guess.size(); j++) {
                ballCount += booleanToInt(answer.get(i).equals(guess.get(j)));
            }
        }
        return ballCount;
    }

    private int calculateStrikeCount(NumberList answer, NumberList guess) {
        int strikeCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            strikeCount += booleanToInt(answer.get(i).equals(guess.get(i)));
        }
        return strikeCount;
    }

    private static class InputController {
        public static String scanUsersGuess() {
            InputView.printEnterGuess();
            String userInput = Console.readLine();
            validateUsersGuess(userInput);
            return userInput;
        }

        private static void validateUsersGuess(String guess) {
            Validator.validateNull(guess);
            Validator.validateSize(guess, 3);
        }
    }
}