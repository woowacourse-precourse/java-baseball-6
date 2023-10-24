package baseball;

import static baseball.RandomNum.LENGTH;

import baseball.Hint.Hints;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public enum State {RESTART, END}

    private User player;
    private Computer computer;

    private Hint hint = new Hint();

    public Game() {
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        player = new User();
        computer = new Computer();
    }

    public void endGame() {
        System.out.println("숫자 야구 게임을 종료합니다.");

        player = null;
        computer = null;
    }

    public String getGuessNums() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    public void isValidGuessNums(String guessNumsStr) {
        int guessNumsInt;
        ArrayList<Integer> guessNums = new ArrayList<>();

        try {
            guessNumsInt = Integer.parseInt(guessNumsStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        // 3자리인지
        if (!isValidLength(guessNumsStr)) {
            throw new IllegalArgumentException();
        }

        // 0이 들어가지 않았는지
        if (!isValidRange(guessNumsStr)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < LENGTH; i++) {
            int num = guessNumsInt % 10;
            guessNumsInt /= 10;
            guessNums.add(0, num);
        }

        // 서로 다른 숫자인지
        if (!isDifferentNums(guessNums)) {
            throw new IllegalArgumentException();
        }

        player.setGuessNums(guessNums);

    }

    private Boolean isValidLength(String guessNumsStr) {
        return guessNumsStr.length() == LENGTH;
    }

    private Boolean isValidRange(String guessNumsStr) {
        return !guessNumsStr.contains("0");
    }

    private Boolean isDifferentNums(ArrayList<Integer> guessNums) {
        for (int i = 0; i < LENGTH; i++) {
            int g = guessNums.get(i);
            if (Collections.frequency(guessNums, g) > 1) {
                return false;
            }
        }

        return true;
    }

    public int getHint() {
        hint.makeHint(player.getGuessNums(), computer.getNums());
        int ball = hint.getBall();
        int strike = hint.getStrike();
        int result = Hints.NOTHING.ordinal();

        if (strike == LENGTH) {
            System.out.println(strike + "스트라이크");
            System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");

            result = Hints.ALL_STRIKE.ordinal();
        } else if (ball >= 1 && strike >= 1) {
            System.out.println(ball + "볼 " + strike + "스트라이크");

            result = Hints.BALL_STRIKE.ordinal();
        } else if (ball >= 1 && strike == 0) {
            System.out.println(ball + "볼 ");

            result = Hints.BALL_STRIKE.ordinal();
        } else if (ball == 0 && strike >= 1) {
            System.out.println(strike + "스트라이크");

            result = Hints.BALL_STRIKE.ordinal();
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        return result;
    }

    public int isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String valueStr = Console.readLine();
        int value = isValidState(valueStr);

        if (value == 1) {
            return State.RESTART.ordinal();
        } else if (value == 2) {
            return State.END.ordinal();
        }

        return value;
    }

    private int isValidState(String valueStr) {
        int value;

        try {
            value = Integer.parseInt(valueStr);

            if (value != 1 && value != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return -1;
        }

        return value;
    }
}
