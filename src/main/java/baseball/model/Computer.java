package baseball.model;

import baseball.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> comNumber;
    private NumberGenerator numberGenerator; // 랜덤한 난수 생성

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.comNumber = new ArrayList<>();
    }

    // 컴퓨터가 서로 다른 3가지 수 생성
    public void generateNumbers() {
        List<Integer> randomNumber = numberGenerator.generateNumberInRange();
        for (Integer integer : randomNumber) {
            comNumber.add(integer);
        }
    }

    // test하기 위한 코드
    public List<Integer> getComNumber() {
        return comNumber;
    }
}
