package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGameStart {

    // 시작
    public BaseBallGameStart() {
        output();
        ComputerNumbers computerNumbers = ComputerNumbers.createRandomNumbers();
        //TODO: 게임을 플레이 하는 로직 구현 할것
        new BaseBallGamePlay();
    }

    // 출력
    private void output() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 컴퓨터의 숫자를 생성
    public static class ComputerNumbers {
        private final List<Integer> numbers;

        private ComputerNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public static ComputerNumbers createRandomNumbers() {
            List<Integer> computerNumbers = new ArrayList<>();
            while (computerNumbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumbers.contains(randomNumber)) {
                    computerNumbers.add(randomNumber);
                }
            }
            return new ComputerNumbers(computerNumbers);
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }
}

