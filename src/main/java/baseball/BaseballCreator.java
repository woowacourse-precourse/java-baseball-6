package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballCreator {
    private Validator validator = new Validator();
    private NumberGenerator numberGenerator;

    public BaseballCreator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // 기능: 사용자의 공을 입력 받고 생성한다
    public List<Integer> createPlayerBalls(String number) {
        validator.validatePlayerBallInput(number);
        return number
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    // 기능: 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    public List<Integer> createComputerBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            int randomNumber = numberGenerator.generate();
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }
}
