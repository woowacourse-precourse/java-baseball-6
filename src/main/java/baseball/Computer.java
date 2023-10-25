package baseball;

import java.lang.reflect.Array;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private ArrayList<Integer> answer;
    OutputManager outputManager = new OutputManager();
    InputManager inputManager = new InputManager();
    void makeAnswer() {
        int randomNumber;

        answer = new ArrayList<>();
        while (answer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber))
                answer.add(randomNumber);
        }
    }


    int JudgeHowManyStrike(ArrayList<Integer> userInput) {
        int strike;

        strike = 0;
        if (answer.get(0).equals(userInput.get(0)))
            strike++;
        if (answer.get(1).equals(userInput.get(1)))
            strike++;
        if (answer.get(2).equals(userInput.get(2)))
            strike++;
        return (strike);
    }

    int JudgeHowManyBall(ArrayList<Integer> userInput, int strike) {
        int ball;

        ball = 0;
        if (answer.contains(userInput.get(0)))
            ball++;
        if (answer.contains(userInput.get(1)))
            ball++;
        if (answer.contains(userInput.get(2)))
            ball++;
        ball = ball - strike;
        return (ball);
    }

    boolean playBaseball() {
        ArrayList<Integer> userInput;
        int ball;
        int strike;
        boolean is_end;

        is_end = false;
        outputManager.printStartMessage();
        while (true) {
            outputManager.printRequestInputMessage();
            userInput = inputManager.takeUserAnswerInput();
            strike =  JudgeHowManyStrike(userInput);
            ball = JudgeHowManyBall(userInput, strike);
            outputManager.printStrikeOrBallMessage(ball, strike);
            if (ball == 0 && strike == 3) {
                outputManager.printRetryOrEndMessage();
                if (inputManager.takeUserEndOrRetryInput() == 2)
                    is_end = true;
                else
                    is_end = false;
                break ;
            }
        }
        return (is_end);
    }

    void startBaseballGame() {
        boolean is_end;

        is_end = false;
        while (!is_end) {
            makeAnswer();
            is_end = playBaseball();
        }

    }
}



