package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int pointer, strike, ball;
    List<Integer> result = new ArrayList<>();

    public void strikeZone(User user, Computer computer) {
        pointer = 0;
        strike = 0;
        ball = 0;
        for (char num : user.getUserSelectNum().toCharArray()) {
            int value = Character.getNumericValue(num);
            if (value == computer.getRandomComputerPickNum().get(pointer)) {
                strike++;
                pointer++;
                continue;
            }
            if (computer.getRandomComputerPickNum().contains(value)) {
                ball++;
                pointer++;
                continue;
            }
        }
        result.add(ball);
        result.add(strike);
    }

    public boolean printGameResult(List<Integer> result) {
        if (result.get(1) == 3) {
            System.out.println(result.get(1) + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (result.get(0) != 0 && result.get(1) != 0) {
            System.out.println(result.get(0) + "볼 " + result.get(1) + "스트라이크");
            return false;
        }
        if (result.get(0) != 0 && result.get(1) == 0) {
            System.out.println(result.get(0) + "볼");
            return false;
        }
        if (result.get(0) == 0 && result.get(1) != 0) {
            System.out.println(result.get(1) + "스트라이크");
            return false;
        }
        if (result.get(0) == 0 && result.get(1) == 0) {
            System.out.println("낫싱");
            return false;
        }
        return false;
    }
}
