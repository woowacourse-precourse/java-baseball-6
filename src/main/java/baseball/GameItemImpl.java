package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class GameItemImpl implements GameItem {

    @Override
    public List<Integer> computer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public void showStrikeAndBall(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (strikes != 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls != 0) {
            System.out.println(balls + "볼");
        }
    }

    @Override
    public boolean checkForStrikes(List<Integer> numList, List<Integer> computer) {
        int strikes = 0;
        int balls = 0;
        boolean yn = false;
        for (int i = 0; i < 3; i++) {
            if (numList.get(i) == computer.get(i)) {
                strikes++;
            } else if (computer.contains(numList.get(i))) {
                balls++;
            }
            
        }
        if (strikes == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            yn = true;
        } else if (strikes != 3) {
            showStrikeAndBall(strikes, balls);
        }
        return yn;
    }
        

    @Override
    public boolean isDuplicated(List<Integer> numList) {
        Set<Integer> number = new HashSet<Integer>(numList);
        return number.size() != numList.size();
    }

    @Override
    public boolean validateLength(String input) {
        return input.length() != 3;
    }

}
