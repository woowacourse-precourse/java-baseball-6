package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    public void generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.randomNumbers = computer;
    }

    public boolean compareNumbers(List<Integer> userNumbers) {
        int ballNum = calculateBalls(userNumbers);
        int strikeNum = calculateStrikes(userNumbers);
        return printResult(ballNum, strikeNum);
    }

    private int calculateBalls(List<Integer> userNumbers) {
        int ballNum = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (randomNumbers.contains(userNumbers.get(i)) && userNumbers.get(i) != randomNumbers.get(i)) {
                ballNum++;
            }
        }
        return ballNum;
    }

    private int calculateStrikes(List<Integer> userNumbers) {
        int strikeNum = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(randomNumbers.get(i))) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private boolean printResult(int ballNum, int strikeNum) {
        if (ballNum != 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum != 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
