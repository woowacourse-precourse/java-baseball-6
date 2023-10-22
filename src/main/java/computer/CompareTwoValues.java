package computer;

import constant.GuideMessageConstant;

import java.util.List;

public class CompareTwoValues {

    public static int[] valueExtraction = new int[3];
    int ballCount = 0;
    int strikeCount = 0;

    public static void valueExtraction(int inputNumber) {
        for (int i = 0; i < 2; i++) {
            valueExtraction[i] = inputNumber % 10;
            inputNumber /= 10;
        }
        valueExtraction[2] = inputNumber;

    }

    public String compareTwoValues(int inputNumber) {
        valueExtraction(inputNumber);
        exploreSequentially();
        countResult(ballCount, strikeCount);
        return "null";
    }

    public void exploreSequentially() {
        List<Integer> computer = RandomPickNumber.computer;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i).equals(valueExtraction[j])) {
                    if (i == j) {
                        strikeCount++;
                    }
                    ballCount++;
                }

            }
        }

    }

    public void countResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(GuideMessageConstant.NOTHING_MESSAGE);
        } else if (ball >= 1 && strike == 0) {
            System.out.println(ballCount + GuideMessageConstant.BALL_MESSAGE);
        } else if (ball == 0 && strike >= 1) {
            System.out.println(strikeCount + GuideMessageConstant.NOTHING_MESSAGE);
        } else if (ball == 1 && strike >= 1) {
            System.out.println(ballCount + GuideMessageConstant.BALL_MESSAGE + strikeCount + GuideMessageConstant.NOTHING_MESSAGE);
        }
    }
}
