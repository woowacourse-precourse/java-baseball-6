package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

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
}

