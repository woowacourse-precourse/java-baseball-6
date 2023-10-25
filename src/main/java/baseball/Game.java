package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Integer> target; // 게임의 목표 숫자를 저장하는 리스트

    public Game() {
        target = generateRandomTarget(); // 게임 시작 시 무작위 목표 숫자 생성
    }

    private List<Integer> generateRandomTarget() {
        List<Integer> target = new ArrayList<>();
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1에서 9까지 무작위 숫자 선택
            if (!target.contains(randomNumber)) {
                target.add(randomNumber); // 중복되지 않는 세 개의 숫자를 목표로 설정
            }
        }
        return target;
    }

    public int checkGuess(Player player) {
        int strike = 0, ball = 0;
        List<Integer> input = player.getInput();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(target.get(i), input.get(i))) {
                strike++; // 위치와 값이 일치하면 스트라이크 증가
            } else if (target.contains(input.get(i))) {
                ball++; // 값은 일치하지만 위치가 다르면 볼 증가
            }
        }
        return strike * 10 + ball;
    }
}

