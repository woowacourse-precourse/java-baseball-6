package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameModel {

    ArrayList<Integer> guess;
    ArrayList<Integer> answer;
    int ball;
    int strike;

    public void generateAnswer() {
        answer = new ArrayList<>(3);
        int num;
        for (int i = 0; i < 3; i++) {
            do {
                num = Randoms.pickNumberInRange(1, 10);
            } while (answer.contains(num));
            answer.add(num);
        }
    }

    public void resetCount() {
        ball = 0;
        strike = 0;
    }

    public void setGuess(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException();
        }
        duplicateCheck(s);
        outOfRangeCheck(s);
        guess = numFormatCheck(s);
    }

    void duplicateCheck(String s) {
        if (Arrays.stream(s.split("")).collect(Collectors.toSet()).size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    void outOfRangeCheck(String s) {
        if (s.contains("0")) {
            throw new IllegalArgumentException();
        }
    }


    ArrayList<Integer> numFormatCheck(String s) {
        ArrayList<Integer> rval;

        try {
            rval = Arrays
                    .stream(s.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return rval;
    }

    public void checkAnswer() {
        int guessIndex = 0;
        for (Integer i : guess) {
            int indexOfStrike = answer.indexOf(i);
            if (indexOfStrike == guessIndex) {
                strike++;
            } else if (indexOfStrike != -1) {
                ball++;
            }
            guessIndex++;
        }
    }

    public StringBuilder getHint() {
        StringBuilder resultStatement = new StringBuilder();
        if (ball > 0) {
            resultStatement.append(ball).append("볼");
        }

        if (strike > 0) {
            if (!resultStatement.isEmpty()) {
                resultStatement.append(" ");
            }
            resultStatement.append(strike).append("스트라이크");
        }

        if (resultStatement.isEmpty()) {
            resultStatement.append("낫싱");
        }

        return resultStatement;
    }

    public int getStrike() {
        return strike;
    }

}
