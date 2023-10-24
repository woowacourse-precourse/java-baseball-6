package computer;

import constant.GuideMessageConstant;
import constant.StringConstant;
import java.util.List;

public class CompareTwoValues {

    public static int[] valueExtraction = new int[3];
    public int ballCount = 0;
    public int strikeCount = 0;

    public static void valueExtraction(int inputNumber) {

        for (int i = 2; i > 0; i--) {
            valueExtraction[i] = inputNumber % StringConstant.DIVISION_NUMBERS;
            inputNumber /= StringConstant.DIVISION_NUMBERS;
        }
        valueExtraction[0] = inputNumber;

    }

    public void compareTwoValues(int inputNumber) {

        valueExtraction(inputNumber);
        exploreSequentially();
        countResult(ballCount, strikeCount);

    }

    public void exploreSequentially() {

        List<Integer> computer = RandomPickNumber.computer;
//        System.out.println(computer);
        ballCount = 0;
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i).equals(valueExtraction[j])) {
                    if (i == j) {
                        strikeCount++;
                        break;
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
            System.out.println(ball + GuideMessageConstant.BALL_MESSAGE);
        } else if (ball == 0 && strike >= 1) {
            System.out.println(strike + GuideMessageConstant.STRIKE_MESSAGE);
        } else if (ball >= 1 && strike >= 1) {
            System.out.println(ball + GuideMessageConstant.BALL_MESSAGE + GuideMessageConstant.BLANK + strike
                    + GuideMessageConstant.STRIKE_MESSAGE);
        }
    }

}
