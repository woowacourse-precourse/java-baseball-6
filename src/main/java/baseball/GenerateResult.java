package baseball;

import java.util.List;
import java.util.Objects;

public class GenerateResult {

    public boolean getResult(List<Integer> inputNumberList, List<Integer> randomNumberList) {
        int strikeNumber = 0;
        int ballNumber = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(inputNumberList.get(i), randomNumberList.get(j))) {
                    if (i == j) {
                        strikeNumber++;
                    } else {
                        ballNumber++;
                    }
                }
            }
        }

        return print(strikeNumber, ballNumber);
    }

    public boolean print(int strikeNumber, int ballNumber) {
        if (strikeNumber != 0 && ballNumber != 0) {
            System.out.println(ballNumber + "볼" + " " + strikeNumber + "스트라이크");
        } else if (strikeNumber != 0) {
            System.out.println(strikeNumber + "스트라이크");
            if (strikeNumber == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        } else if (ballNumber != 0) {
            System.out.println(ballNumber + "볼");
        } else {
            System.out.println("낫싱");
        }

        return false;
    }
}
