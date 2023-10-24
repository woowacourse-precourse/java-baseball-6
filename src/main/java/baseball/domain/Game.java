package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Baseballs.*;

public class Game {

    private Baseballs computerBaseballs;
    private boolean isGameOver;

    public void setup() {
        computerBaseballs = new Baseballs(generateRandomNumbers());
        isGameOver = false;
    }

    public Baseballs getComputerBaseballs() {
        return computerBaseballs;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    private List<Integer> generateRandomNumbers() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < BALL_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_BALL, MAX_BALL));
        }
        return new ArrayList<>(ballNumbers);
    }
}