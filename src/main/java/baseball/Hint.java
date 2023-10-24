package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public void compareNumber(List<Integer> computerNumbers, List<Integer> userNumbers) {

        for (int i = 0; i < computerNumbers.size(); i++) {

            if (computerNumbers.get(i).equals(userNumbers.get(i))) {

                strikeCount++;

            } else {

                ballCount++;

            }
        }

        printHint(strikeCount, ballCount);
    }

    // 힌트 출력
    private void printHint(int strikeCount, int ballCount) {

        if (strikeCount != 0 && ballCount != 0) {

            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");

        } else {

            if (strikeCount != 0) {

                System.out.println(strikeCount + "스트라이크");

            } else if (ballCount != 0) {

                System.out.println(ballCount + "볼");

            }
        }
    }


}
