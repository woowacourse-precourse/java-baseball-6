package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Constant.*;

public class BaseballGame implements NumberGame {

    private NumberGameConfiguration baseballGameConfiguration;

    public BaseballGame(NumberGameConfiguration baseballGameConfiguration) {
        this.baseballGameConfiguration = baseballGameConfiguration;
    }

    @Override
    public void play() {
        System.out.println(UserResponseMessage.GAME_START_MESSAGE);
        do {
            proceedGame();
        } while (shouldRepeatGame());
    }

    private void proceedGame() {
        List<Integer> randomNumber = NumberFactory.createByComputer(baseballGameConfiguration);

        while (true) {
            List<Integer> userGuessNumber = NumberFactory.createByUser();
            validateUserGuessNumber(userGuessNumber);
            Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
            printHint(score);

            if (randomNumber.equals(userGuessNumber)) {
                break;
            }
        }

        System.out.println(UserResponseMessage.ALL_CORRECT_MESSAGE);
    }

    private void printHint(Score score) {
        StringBuilder hint = new StringBuilder();
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        if (ballCount != 0) {
            hint.append(ballCount).append(UserResponseMessage.BALL_MESSAGE);
        }

        if (strikeCount != 0) {
            hint.append(strikeCount).append(UserResponseMessage.STRIKE_MESSAGE);
        }

        if (ballCount == 0 && strikeCount == 0) {
            hint.append(UserResponseMessage.NOTHING_MESSAGE);
        }

        System.out.println(hint);
    }

    private boolean shouldRepeatGame() {
        System.out.println(UserRequestMessage.REPEAT_MESSAGE);
        String userRepeatNumber = Console.readLine();
        validateUserRepeatNumber(userRepeatNumber);

        if (userRepeatNumber.equals("2")) {
            return false;
        }

        return true;
    }

    private void validateUserGuessNumber(List<Integer> userGuessNumber) {
        if (userGuessNumber.size() != baseballGameConfiguration.getNumberOfDigits()) {
            throw new IllegalArgumentException();
        }

        for (int number : userGuessNumber) {
            if (number < baseballGameConfiguration.getMinimumNumberOfRange()) {
                throw new IllegalArgumentException();
            }

            if (number > baseballGameConfiguration.getMaximumNumberOfRange()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateUserRepeatNumber(String userRepeatNumber) {
        if (!userRepeatNumber.equals("1") && !userRepeatNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
