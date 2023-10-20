package baseball.domain;

import baseball.dto.Score;
import baseball.util.RandomNumberGenerator;

import java.util.List;

public class Computer {
    private final List<Integer> number;

    public Computer() {
        number = RandomNumberGenerator.getRandom3Number();
    }

    public Computer(List<Integer> number) {
        this.number = number;
    }


    public Score getScore(List<Integer> userNum) {
        int ball = 0, strike = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (number.contains(userNum.get(i))) {
                ball++;
            }
            if (number.get(i) == userNum.get(i)) {
                strike++;
            }
        }
        return Score.getInstance(ball - strike, strike);
    }
}
