package baseball;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public void compareNumber(List<Integer> computerNumbers, List<Integer> userNumbers) {

        for (int i = 0; i < computerNumbers.size(); i++) {

            if (computerNumbers.get(i).equals(userNumbers.get(i))) {

                strikeCount++;

            }
        }

        printHint(strikeCount);
    }


    private void printHint(int strikeCount) {

        if (strikeCount != 0) {

            System.out.println(strikeCount + "스트라이크");

        }

    }
}
