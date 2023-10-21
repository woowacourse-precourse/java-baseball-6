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
        duplicateCheck(s);
        guess = numFormatCheck(s);
    }

    void duplicateCheck(String s) {
        if (Arrays.stream(s.split("")).collect(Collectors.toSet()).size() != 3) {
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

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
