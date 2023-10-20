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
    boolean retry;
    private static final GameModel GAME_MODEL = new GameModel();

    public static GameModel getGameModel() {
        return GAME_MODEL;
    }

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

        try {
            guess = Arrays
                    .stream(s.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkAnswer() {
        int index = 0;
        for (Integer i : guess) {
            int num = answer.indexOf(i);
            if (num == index) {
                strike++;
            } else if (num != -1) {
                ball++;
            }
            index++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public void setRetry(String s) {
        switch (s) {
            case "1":
                retry = true;
                break;
            case "2":
                retry = false;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean getRetry() {
        return retry;
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
}
