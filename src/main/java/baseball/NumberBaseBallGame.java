package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallGame {
    public List<Integer> computer;

    public void ComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
//    public void displayComputerNumbers() {  // 코드를 원활하게 작성하기 위해서 컴퓨터가 생각하는 수를 보기 위한 코드
//        System.out.print("Computer's Numbers: ");
//        for (Integer number : computer) {
//            System.out.print(number + " ");
//        }
//        System.out.println();
//    }
    public String guessNumber(List<Integer> digits) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int j = 0; j < computer.size(); j++) {
            if (computer.get(j).equals(digits.get(j))) {
                strikeCount++;
            } else if (digits.contains(computer.get(j))) {
                ballCount++;
            }
        }

        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if (ballCount > 0 && strikeCount == 0) {
            return ballCount + "볼";
        } else {
            return "낫싱!";
        }
    }
}
