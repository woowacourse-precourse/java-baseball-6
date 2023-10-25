package baseball.domain.baseballplayer.team;

import baseball.domain.baseballplayer.dto.Ball;
import baseball.domain.baseballplayer.team.validator.UserInputValidator;
import baseball.domain.input.ConsoleReader;

import java.util.List;
import java.util.stream.Collectors;

public final class User implements BaseBallTeam {
    private final UserInputValidator userInputValidator;
    private Ball ball;

    private User(final UserInputValidator userInputValidator) {
        this.userInputValidator = userInputValidator;
    }

    public static User newInstance(final UserInputValidator userInputValidator) {
        return new User(userInputValidator);
    }

    @Override
    public Ball getBall() {
        return ball;
    }

    @Override
    public void createNewBall() {
        printInputNumberMessage();
        String userInputString = ConsoleReader.input();
        userInputValidator.inputValidNumbers(userInputString);
        List<Integer> numbers = convertUserInputToNumbers(userInputString);
        ball = new Ball(numbers);
    }

    private void printInputNumberMessage() {
        final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    private List<Integer> convertUserInputToNumbers(final String userInputString) {
        return userInputString.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

}
