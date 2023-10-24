package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    OutputManager outputManager = new OutputManager();
    InputManager inputManager = new InputManager();
    ArrayList<Integer> makeAnswer() {
        ArrayList<Integer> answer;
        int randomNumber;

        answer = new ArrayList<>();
        while (answer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber))
                answer.add(randomNumber);
        }
        return (answer);
    }


    int JudgeHowManyStrike(ArrayList<Integer> answer, ArrayList<Integer> userInput) {
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

    int JudgeHowManyBall(ArrayList<Integer> answer, ArrayList<Integer> userInput, int strike) {
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

    boolean playBaseball(ArrayList<Integer> answer) {
        ArrayList<Integer> userInput;
        int ball;
        int strike;
        boolean is_end;

        is_end = false;
        outputManager.printStartMessage();
        while (!is_end) {
            outputManager.printRequestInputMessage();
            userInput = inputManager.takeUserAnswerInput();
            strike =  JudgeHowManyStrike(answer, userInput);
            ball = JudgeHowManyBall(answer, userInput, strike);
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
        ArrayList<Integer> answer;

        is_end = false;
        while (!is_end) {
            answer = makeAnswer();
            is_end = playBaseball(answer);
        }

    }
}



