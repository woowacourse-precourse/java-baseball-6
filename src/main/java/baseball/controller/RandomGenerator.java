package baseball.controller;

import baseball.model.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public List<Ball> computer;
    public RandomGenerator() {
        make_balls();
    }


    private void make_balls() {
        computer = new ArrayList<>();
        int i=0;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(new Ball(randomNumber, i));
                i++;
            }

        }
    }
    public List<Ball> getComputer() {
        return computer;
    }
}
