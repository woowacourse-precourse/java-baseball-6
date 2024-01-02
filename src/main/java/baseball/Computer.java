package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class Computer {
    private ArrayList<Integer> numbers;
    public void init(){
        this.numbers = new ArrayList<>(3);
        while (this.numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.numbers.contains(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }

    public HashMap<String, Integer> checkNumber(ArrayList<Integer> numbers) {
        HashMap<String, Integer> result = new HashMap<>();
        int strike = this.countStrike(numbers);
        int ball = this.countBall(numbers);
        result.put("strike", strike);
        result.put("ball", ball);
        return result;
    }

    private int countStrike(ArrayList<Integer> numbers) {
        int strike = 0;
        for (int i = 0; i < 3; i++){
            if (this.numbers.get(i).equals(numbers.get(i))){
                strike++;
            }
        }
        return strike;
    }

    private int countBall(ArrayList<Integer> numbers) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            Integer num = numbers.get(i);
            if (this.numbers.contains(num) && !this.numbers.get(i).equals(num)){
                ball++;
            }
        }
        return ball;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
