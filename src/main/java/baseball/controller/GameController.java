package baseball.controller;

import baseball.Umpire;
import baseball.converter.StringInputConverter;
import baseball.factory.NumberFactory;
import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import baseball.view.AskView;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private static final int PLAY_NUMBER_DIGIT = 3;
    private static final int RESTART = 1;
    private static final int END = 2;

    public static void play() {
        boolean playWant = true;
        int computerNumber = selectNewNumber();

        StartView.welcome();

        while (playWant) {
            askUserNumberInput();

            String userInput = receivePlayNumber();

            int userNumber = StringInputConverter.convertStringToInt(userInput);

            int ball = Umpire.countBall(computerNumber, userNumber);
            int strike = Umpire.countStrike(computerNumber, userNumber);

            ResultView.printResult(ball, strike);

            if (isStrikeEqualToGoal(strike)) {
                EndView.end(PLAY_NUMBER_DIGIT);
                AskView.askResume(RESTART, END);
                String resumeInput = receiveResumeNumber();
                int resumeNumber = StringInputConverter.convertStringToInt(resumeInput);
                if (isUserWantMoreGame(resumeNumber)) {
                    computerNumber = selectNewNumber();
                }
                if (isUserWantStopGame(resumeNumber)) {
                    playWant = false;
                }
            }
        }
    }

    private static void askUserNumberInput() {
        AskView.askNumberInput();
    }

    private static String receivePlayNumber() {
        String userInput = Console.readLine();
        assertNumberValue(userInput);

        return userInput;
    }

    private static void assertNumberValue(final String inputNumber) {
        NumberValidator.assertInputNumberWithLength(inputNumber, PLAY_NUMBER_DIGIT);
    }

    private static boolean isStrikeEqualToGoal(final int strike) {
        return strike == PLAY_NUMBER_DIGIT;
    }

    private static String receiveResumeNumber() {
        String resumeInput = Console.readLine();
        assertResumeValue(resumeInput);

        return resumeInput;
    }

    private static void assertResumeValue(final String resume) {
        ResumeValidator.assertResumeInput(resume, RESTART, END);
    }

    private static boolean isUserWantMoreGame(final int resumeNumber) {
        return resumeNumber == RESTART;
    }

    private static int selectNewNumber() {
        return NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
    }

    private static boolean isUserWantStopGame(final int resumeNumber) {
        return resumeNumber == END;
    }
}
