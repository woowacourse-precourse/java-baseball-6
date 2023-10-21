package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numbers = new ArrayList<>();

    public void generateNumbers() {
        while(numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public GameResult verifyNumbers(List<Integer> inputNumbers) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.get(i);

            if(numbers.contains(inputNumber)) {
                if(numbers.indexOf(inputNumber) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return new GameResult(strike, ball);
    }
}
