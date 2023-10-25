package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Game {
    private final int GOAL;
    private List<Integer> computer;
    private List<Integer> user;
    int strike;
    int ball;
    private static final String END_OF_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTING = "낫싱";

    public Game(final int gameSize) {
        GOAL = gameSize;
    }

    public void init(final int startInclusive, final int endInclusive) {
        computer = NumberGenerator.makeNumbers(startInclusive, endInclusive, GOAL);
        strike = -1;
        ball = -1;
    }

    public void run() {
        do {
            user = getUserNumbers();
            strike = countStrike(user, computer);
            ball = countBall(user, computer, strike);
            call(strike, ball);
        } while (!isFinish(strike));
        System.out.println(END_OF_GAME);
    }

    private void call(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) {
            sb.append(NOTING);
        }
        if (ball != 0) {
            sb.append(ball).append(BALL).append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append(STRIKE);
        }
        System.out.println(sb);
    }

    private List<Integer> getUserNumbers() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println(INPUT_NUMBERS);
        String input = Console.readLine();
        validate(input);
        numbers = toIntegerList(input);
        return numbers;
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }
        return numbers;
    }

    private void validate(String input) throws IllegalArgumentException {
        digitCheck(input);
        lengthCheck(input.length());
        duplicateCheck(input);
    }

    private void digitCheck(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("NOT A DIGIT");
            }
        }
    }

    private void lengthCheck(int length) throws IllegalArgumentException {
        if (length != GOAL) {
            throw new IllegalArgumentException("BAD INPUT");
        }
    }

    private void duplicateCheck(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (set.contains(c)) {
                throw new IllegalArgumentException("DUPLICATE NUMBER");
            }
            set.add(c);
        }
    }

    private boolean isFinish(int strike) {
        return strike == GOAL;
    }

    public int countStrike(List<Integer> user, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(user.get(i), computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> user, List<Integer> computer, final int strike) {
        int ball = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                ball++;
            }
        }
        return ball - strike;
    }
}
