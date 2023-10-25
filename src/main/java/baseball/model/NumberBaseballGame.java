package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberBaseballGame implements Game {
    public static final int DIGIT = 3;
    private int randomNumber;
    private int strikes;
    private int balls;

    public NumberBaseballGame() {
        pickRandomNumber();
    }

    public void pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT) {
            int randomOne = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomOne)) {
                computer.add(randomOne);
            }
        }

        int pickNumber = 0;
        for (int i = 0; i < computer.size(); i++) {
            pickNumber += computer.get(i) * Math.pow(10, DIGIT - (i + 1));
        }

        randomNumber = pickNumber;
    }

    public int countStrikes(int number) {
        int strikes = 0;
        String computer = Integer.toString(randomNumber);
        String player = Integer.toString(number);

        for (int i = 0; i < DIGIT; i++) {
            if (computer.charAt(i) == player.charAt(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(int number) {
        Set<Character> computer = makeSet(Integer.toString(randomNumber));
        Set<Character> player = makeSet(Integer.toString(number));
        computer.retainAll(player);

        return computer.size();
    }

    public int validateInput(String input) {
        Set<Character> player = makeSet(input);
        if (player.size() != DIGIT) {
            throw new IllegalArgumentException();
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public Set<Character> makeSet(String number) {
        return number.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
    }

    @Override
    public void play(String input) {
        int number = validateInput(input);

        strikes = countStrikes(number);
        balls = countBalls(number) - strikes;
    }

    @Override
    public boolean continues() {
        return strikes != DIGIT;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
