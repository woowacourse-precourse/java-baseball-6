package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int STRIKE_SIZE = 3;

    private List<Integer> randomNumbers;

    void generateRandomNumbers() {
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
        int ballNum = 0;
        int strikeNum = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == randomNumbers.get(i)) {
                strikeNum++;
                continue;
            }
            if (randomNumbers.contains(userNumbers.get(i))) {
                ballNum++;
            }
        }
        printResult(ballNum, strikeNum);
        return strikeNum == STRIKE_SIZE;
    }

    public void printResult(int ballNum, int strikeNum) {
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
        }

    }
}
