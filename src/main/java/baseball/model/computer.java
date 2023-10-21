package baseball.model;

import baseball.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class computer {

    private List<Integer> comNumber;
    private NumberGenerator numberGenerator;    // 랜덤 생성

    public computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.comNumber = new ArrayList<>();
        generate();
    }

    // 컴퓨터가 서로 다른 3가지 수 뽑기
    public void generate() {
        while (comNumber.size() < 3) {
            int randomNumber = numberGenerator.generateNumberInRange(1, 9);
            hasNoDuplicateNumber(randomNumber);
        }
    }

    // 랜덤한 수 중에서 중복된 수 제외하기
    private void hasNoDuplicateNumber(int randomNumber) {
        if (!comNumber.contains(randomNumber)) {    // 중복된 숫자 거르고 넣기
            comNumber.add(randomNumber);
        }
    }

    // test하기 위한 코드
    public List<Integer> getComNumber() {
        return comNumber;
    }
}
