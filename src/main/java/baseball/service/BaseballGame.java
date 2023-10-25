package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

import java.util.HashSet;

import static baseball.constants.Constants.NUMBER_LENGTH;
import static baseball.constants.Constants.REQUIRED_STRIKES_FOR_WIN;
import static baseball.constants.Messages.START_MESSAGE;

public class BaseballGame {

    private static final String RESTART_CHOICE = "1";

    private User user;
    private Computer computer;

    public BaseballGame() {
        System.out.println(START_MESSAGE.getMessage());
        user = new User();
        computer = new Computer();
    }

    public void start() {
        do {
            playSingleRound();
        } while (isUserWantsToRestart());
    }

    private void playSingleRound() {
        computer.generateRandomAnswer();
        do {
            user.setNumber(Input.get());
        } while (!isGuessCorrect());
        Output.printAnswerMessage();
    }

    private boolean isGuessCorrect() {
        String number = user.getNumber();
        String answer = computer.getAnswer();
        int strike = countStrike(number, answer);
        int ball = countBall(number, answer);
        Output.print(ball, strike);

        return strike == REQUIRED_STRIKES_FOR_WIN.getValue();
    }

    private boolean isUserWantsToRestart() {
        return RESTART_CHOICE.equals(Input.restart());
    }


    public static int countBall(String number, String answer) {
        HashSet<Character> set = new HashSet<>();
        for (char c : answer.toCharArray()) {
            set.add(c);
        }
        int ballCount = 0;
        for (int index = 0; index < NUMBER_LENGTH.getValue(); index++) {
            if (number.charAt(index) != answer.charAt(index) && set.contains(number.charAt(index))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static int countStrike(String number, String answer) {
        if (number.equals(answer)) {
            return REQUIRED_STRIKES_FOR_WIN.getValue();
        }

        int strikeCount = 0;
        for (int index = 0; index < NUMBER_LENGTH.getValue(); index++) {
            if (number.charAt(index) == answer.charAt(index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

