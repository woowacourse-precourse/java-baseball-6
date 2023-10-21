package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void startGame() {
        ArrayList<Integer> computer;
        System.out.println(START_MESSAGE);
        computer = getRandomNumber();
        System.out.println(computer);
    }

    private ArrayList<Integer> getRandomNumber() {
        int MAX_LENGTH = 3;
        int MAX_NUM = 9;
        int MIN_NUM = 1;

        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        do {
            int digit = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            set.add(digit);
        } while(set.size() < MAX_LENGTH);

        return new ArrayList<>(set);
    }
}
